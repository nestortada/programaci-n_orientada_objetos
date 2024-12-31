package org.example.proyecto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.proyecto.classresources.repositories.DBAerolinea;
import org.example.proyecto.classresources.repositories.DBAvion;
import org.example.proyecto.classresources.repositories.DBVuelo;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Aerolinea;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Avion;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Vuelo;

import java.util.ArrayList;

public class AvionController {

    @FXML
    private ObservableList<Avion> aircraftList = FXCollections.observableArrayList();
    @FXML
    private TableView<Avion> avionTableView;
    @FXML
    private TableColumn<Avion, Integer> idColumn;
    @FXML
    private TableColumn<Avion, Integer> numSillasColumn;
    @FXML
    private TableColumn<Avion, String> modeloColumn;
    @FXML
    private TableColumn<Avion, String> marcaColumn;
    @FXML
    private TableColumn<Avion, String> aerolineaColumn;

    @FXML
    private TextField idField;
    @FXML
    private Spinner<Integer> numSillasField;
    @FXML
    private TextField modeloField;
    @FXML
    private TextField marcaField;
    @FXML
    private TextField aerolineaField;

    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonSelect;
    @FXML
    private Button buttonUpdate;

    @FXML
    private void initialize() {
        DBAvion dbAvion = new DBAvion();
        ArrayList<Avion> aviones = dbAvion.getListData();
        this.convertDataAvion();
        aircraftList.setAll(aviones);
        avionTableView.setItems(aircraftList);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0, 1);
        numSillasField.setValueFactory(valueFactory);
    }

    private void convertDataAvion() {
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        numSillasColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumSillas()).asObject());
        modeloColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        marcaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        aerolineaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAerolinea().getNombre()));
    }

    @FXML
    public void onButtonRegisterClick() {
        String idText = idField.getText();

        // Verificar si el campo de ID está vacío o no es un número
        if (idText.isEmpty() || !idText.matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de entrada");
            alert.setHeaderText("ID inválido");
            alert.setContentText("Por favor ingresa un ID válido.");
            alert.showAndWait();
            return;
        }

        int id = Integer.parseInt(idText);
        if (idExists(id)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ID Duplicado");
            alert.setHeaderText("ID ya existente");
            alert.setContentText("El ID ingresado ya existe. Por favor ingresa un ID diferente.");
            alert.showAndWait();
            return;
        }

        int numSillas = numSillasField.getValue();
        String modelo = modeloField.getText();
        String marca = marcaField.getText();
        String nombreAerolinea = aerolineaField.getText();

        if (!isAerolineaValid(nombreAerolinea)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aerolínea no válida");
            alert.setHeaderText("La aerolínea ingresada no es válida.");
            alert.setContentText("Las aerolíneas disponibles son: " + obtenerNombresAerolineas());
            alert.showAndWait();
            return;
        }

        Aerolinea aerolinea = new Aerolinea(nombreAerolinea);
        Avion avion = new Avion(id, numSillas, modelo, marca, aerolinea);

        aircraftList.add(avion);
        DBAvion db = new DBAvion();
        db.addData(avion);

        clearFields();
    }

    @FXML
    public void onButtonDeleteClick() {
        Avion avion = avionTableView.getSelectionModel().getSelectedItem();
        if (avion != null) {
            DBVuelo dbVuelo = new DBVuelo();
            ArrayList<Vuelo> vuelos = dbVuelo.getListData();

            for (Vuelo vuelo : vuelos) {
                if (vuelo.getAvion().getId() == avion.getId()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error de eliminación");
                    alert.setHeaderText("El avión está asociado con vuelos");
                    alert.setContentText("No se puede eliminar el avión porque está asociado con uno o más vuelos.");
                    alert.showAndWait();
                    return;
                }
            }

            DBAvion db = new DBAvion();
            db.deleteData(avion);
            aircraftList.remove(avion);
            avionTableView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    public void onButtonSelectedClick() {
        Avion avion = avionTableView.getSelectionModel().getSelectedItem();
        if (avion != null) {
            idField.setText(String.valueOf(avion.getId()));
            numSillasField.getValueFactory().setValue(avion.getNumSillas());
            modeloField.setText(avion.getModelo());
            marcaField.setText(avion.getMarca());
            aerolineaField.setText(avion.getAerolinea().getNombre());
        } else {
            System.out.println("Please select an aircraft to update.");
        }
    }

    @FXML
    public void onButtonUpdateClick() {
        Avion selectedAvion = avionTableView.getSelectionModel().getSelectedItem();
        if (selectedAvion != null) {
            int id = Integer.parseInt(idField.getText());
            int numSillas = numSillasField.getValue();
            String modelo = modeloField.getText();
            String marca = marcaField.getText();
            String nombreAerolinea = aerolineaField.getText();

            if (!isAerolineaValid(nombreAerolinea)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Aerolínea no válida");
                alert.setHeaderText("La aerolínea ingresada no es válida.");
                alert.setContentText("Las aerolíneas disponibles son: " + obtenerNombresAerolineas());
                alert.showAndWait();
                return;
            }

            // Verificar si el ID ha cambiado y ya existe
            if (selectedAvion.getId() != id && idExists(id)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de ID");
                alert.setHeaderText("ID duplicado");
                alert.setContentText("El ID proporcionado ya existe. Por favor, use un ID diferente.");
                alert.showAndWait();
                return;
            }

            Aerolinea aerolinea = new Aerolinea(nombreAerolinea);
            Avion newAvion = new Avion(id, numSillas, modelo, marca, aerolinea);

            DBAvion dbAvion = new DBAvion();
            boolean updated = dbAvion.updateData(selectedAvion, newAvion);
            if (updated) {
                aircraftList.remove(selectedAvion);
                aircraftList.add(newAvion);
                avionTableView.refresh();
                avionTableView.getSelectionModel().clearSelection();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Actualización exitosa");
                alert.setHeaderText(null);
                alert.setContentText("Avión actualizado correctamente.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Actualización fallida");
                alert.setHeaderText(null);
                alert.setContentText("No se pudo actualizar el avión.");
                alert.showAndWait();
            }
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selección de avión");
            alert.setHeaderText("Ningún avión seleccionado");
            alert.setContentText("Por favor, selecciona un avión para actualizar.");
            alert.showAndWait();
        }
    }


    private boolean idExists(int id) {
        return aircraftList.stream().anyMatch(avion -> avion.getId() == id);
    }

    private boolean isAerolineaValid(String nombreAerolinea) {
        DBAerolinea dbAerolinea = new DBAerolinea();
        return dbAerolinea.getListData().stream().anyMatch(aerolinea -> aerolinea.getNombre().equals(nombreAerolinea));
    }

    private String obtenerNombresAerolineas() {
        DBAerolinea dbAerolinea = new DBAerolinea();
        return dbAerolinea.getListData().stream().map(Aerolinea::getNombre).reduce((a, b) -> a + ", " + b).orElse("");
    }

    private void clearFields() {
        idField.clear();
        numSillasField.getValueFactory().setValue(0);
        modeloField.clear();
        marcaField.clear();
        aerolineaField.clear();
    }
}



