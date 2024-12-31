package org.example.proyecto;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.proyecto.classresources.repositories.DBLugar;
import org.example.proyecto.classresources.repositories.DBVuelo;
import org.example.proyecto.classresources.repositories.DBAvion;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Avion;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Lugar;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Vuelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VueloController {
    @FXML
    private ObservableList<Vuelo> vueloList = FXCollections.observableArrayList();
    @FXML
    private TableView<Vuelo> vueloTableView;
    @FXML
    private TableColumn<Vuelo, String> flightIdColumn;
    @FXML
    private TableColumn<Vuelo, String> origenColumn;
    @FXML
    private TableColumn<Vuelo, String> fechaSalidaColumn;
    @FXML
    private TableColumn<Vuelo, String> destinoColumn;
    @FXML
    private TableColumn<Vuelo, String> precioColumn;
    @FXML
    private TableColumn<Vuelo, String> avionColumn;

    @FXML
    private TextField flightIdField;
    @FXML
    private TextField origenField;
    @FXML
    private DatePicker fechaSalidaPicker;
    @FXML
    private TextField destinoField;
    @FXML
    private TextField precioField;
    @FXML
    private TextField avionField;

    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonDelete;

    @FXML
    private void initialize() {
        // Vuelo
        DBVuelo dbVuelo = new DBVuelo();
        ArrayList<Vuelo> vuelos = dbVuelo.getListData();
        this.convertDataVuelo();
        vueloList.setAll(vuelos);
        vueloTableView.setItems(vueloList);

        // Configuración del DatePicker
        fechaSalidaPicker.setValue(LocalDateTime.now().toLocalDate());
    }

    private void convertDataVuelo() {
        flightIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getFlightId())));
        origenColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOrigen().getCiudad()));
        fechaSalidaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaSalida().toString()));
        destinoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestino().getCiudad()));
        precioColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
        avionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAvion().getModelo()));
    }

    @FXML
    public void onButtonRegisterClick() {
        try {
            int flightId = Integer.parseInt(flightIdField.getText());
            String origen = origenField.getText();
            LocalDateTime fechaSalida = fechaSalidaPicker.getValue().atStartOfDay(); // Se obtiene la fecha y se establece la hora a las 00:00
            String destino = destinoField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String avion = avionField.getText();

            if (!isLugarValid(origen) || !isLugarValid(destino)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Lugar no válido");
                alert.setHeaderText("El lugar ingresado no es válido.");
                alert.setContentText("Por favor, ingrese un lugar válido.");
                alert.showAndWait();
                return;
            }

            if (origen.equalsIgnoreCase(destino)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Lugares duplicados");
                alert.setHeaderText("El origen y destino no pueden ser iguales.");
                alert.setContentText("Por favor, ingrese lugares diferentes.");
                alert.showAndWait();
                return;
            }

            if (!isAvionValid(avion)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Modelo de avión no válido");
                alert.setHeaderText("El modelo de avión ingresado no es válido.");
                alert.setContentText("Por favor, ingrese un modelo de avión válido.");
                alert.showAndWait();
                return;
            }

            Vuelo vuelo = new Vuelo(flightId, new Lugar(origen), fechaSalida, new Lugar(destino), precio, new Avion(avion));
            DBVuelo db = new DBVuelo();
            db.addData(vuelo);
            vueloList.add(vuelo);
            clearFields();
        } catch (NumberFormatException e) {
            // Mostrar mensaje de error si se ingresa un valor no numérico
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de entrada");
            alert.setHeaderText("El valor ingresado no es válido.");
            alert.setContentText("Por favor, ingrese un valor numérico en el campo correspondiente.");
            alert.showAndWait();
        }
    }

    @FXML
    public void onButtonDeleteClick() {
        Vuelo vuelo = vueloTableView.getSelectionModel().getSelectedItem();
        if (vuelo != null) {
            DBVuelo db = new DBVuelo();
            db.deleteData(vuelo);
            vueloList.remove(vuelo);
            vueloTableView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    public void onButtonSelectedClick() {
        Vuelo vuelo = vueloTableView.getSelectionModel().getSelectedItem();
        if (vuelo != null) {
            flightIdField.setText(String.valueOf(vuelo.getFlightId()));
            origenField.setText(vuelo.getOrigen().getCiudad());
            fechaSalidaPicker.setValue(vuelo.getFechaSalida().toLocalDate());
            destinoField.setText(vuelo.getDestino().getCiudad());
            precioField.setText(String.valueOf(vuelo.getPrecio()));
            avionField.setText(vuelo.getAvion().getModelo());
        } else {
            System.out.println("Por favor seleccionar un vuelo para actualizar");
        }
    }

    @FXML
    public void onButtonUpdateClick() {
        Vuelo vuelo = vueloTableView.getSelectionModel().getSelectedItem();
        if (vuelo != null) {
            try {
                int flightId = Integer.parseInt(flightIdField.getText());
                String origen = origenField.getText();
                LocalDateTime fechaSalida = fechaSalidaPicker.getValue().atStartOfDay(); // Se obtiene la fecha y se establece la hora a las 00:00
                String destino = destinoField.getText();
                double precio = Double.parseDouble(precioField.getText());
                String avion = avionField.getText();

                if (!isLugarValid(origen) || !isLugarValid(destino)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Lugar no válido");
                    alert.setHeaderText("El lugar ingresado no es válido.");
                    alert.setContentText("Por favor, ingrese un lugar válido.");
                    alert.showAndWait();
                    return;
                }

                if (origen.equalsIgnoreCase(destino)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Lugares duplicados");
                    alert.setHeaderText("El origen y destino no pueden ser iguales.");
                    alert.setContentText("Por favor, ingrese lugares diferentes.");
                    alert.showAndWait();
                    return;
                }

                if (!isAvionValid(avion)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Modelo de avión no válido");
                    alert.setHeaderText("El modelo de avión ingresado no es válido.");
                    alert.setContentText("Por favor, ingrese un modelo de avión válido.");
                    alert.showAndWait();
                    return;
                }

                Vuelo newVuelo = new Vuelo(flightId, new Lugar(origen), fechaSalida, new Lugar(destino), precio, new Avion(avion));
                DBVuelo db = new DBVuelo();
                boolean updated = db.updateData(vuelo, newVuelo);
                if (updated) {
                    System.out.println("Se actualizó el vuelo correctamente");
                } else {
                    System.out.println("No se actualizó el vuelo");
                }
                vuelo.setFlightId(flightId);
                vuelo.setOrigen(new Lugar(origen));
                vuelo.setFechaSalida(fechaSalida);
                vuelo.setDestino(new Lugar(destino));
                vuelo.setPrecio(precio);
                vuelo.setAvion(new Avion(avion));
                vueloTableView.refresh();
                vueloTableView.getSelectionModel().clearSelection();
                clearFields();
            } catch (NumberFormatException e) {
                // Mostrar mensaje de error si se ingresa un valor no numérico
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de entrada");
                alert.setHeaderText("El valor ingresado no es válido.");
                alert.setContentText("Por favor, ingrese un valor numérico en el campo correspondiente.");
                alert.showAndWait();
            }
        } else {
            System.out.println("Por favor seleccionar un vuelo para actualizar");
        }
    }

    private boolean isLugarValid(String ciudad) {
        DBLugar dbLugar = new DBLugar();
        ArrayList<Lugar> lugares = dbLugar.getListData();
        for (Lugar lugar : lugares) {
            if (lugar.getCiudad().equalsIgnoreCase(ciudad)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAvionValid(String modelo) {
        DBAvion dbAvion = new DBAvion();
        ArrayList<Avion> aviones = dbAvion.getListData();
        for (Avion avion : aviones) {
            if (avion.getModelo().equalsIgnoreCase(modelo)) {
                return true;
            }
        }
        return false;
    }

    private void clearFields() {
        flightIdField.setText("");
        origenField.setText("");
        fechaSalidaPicker.setValue(LocalDateTime.now().toLocalDate());
        destinoField.setText("");
        precioField.setText("");
        avionField.setText("");
    }
}
