package org.example.proyecto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.proyecto.classresources.repositories.DBPasajero;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Pasajero;

import java.util.ArrayList;

public class PasajeroController {
    private ObservableList<Pasajero> pasajeroList = FXCollections.observableArrayList();

    @FXML
    private TableView<Pasajero> pasajeroTableView;
    @FXML
    private TableColumn<Pasajero, String> nombreColumn;
    @FXML
    private TableColumn<Pasajero, String> apellidoColumn;
    @FXML
    private TableColumn<Pasajero, Integer> idNumColumn;
    @FXML
    private TableColumn<Pasajero, String> idTypeColumn;

    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField idNumField;
    @FXML
    private ChoiceBox<String> idTypeChoiceBox;

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
        // Configure ChoiceBox with identity types
        idTypeChoiceBox.setItems(FXCollections.observableArrayList("CC", "TI", "CE", "PAS"));

        // Load passengers
        DBPasajero dbPasajero = new DBPasajero();
        ArrayList<Pasajero> pasajeros = dbPasajero.getListData();
        convertDataPasajero();
        pasajeroList.setAll(pasajeros);
        pasajeroTableView.setItems(pasajeroList);
    }

    private void convertDataPasajero() {
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        apellidoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        idNumColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdNum()).asObject());
        idTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdType()));
    }

    @FXML
    public void onButtonRegisterClick() {
        try {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            int idNum = Integer.parseInt(idNumField.getText());
            String idType = idTypeChoiceBox.getValue();

            Pasajero pasajero = new Pasajero(nombre, apellido, idType, idNum);
            pasajeroList.add(pasajero);
            DBPasajero db = new DBPasajero();
            db.addData(pasajero);
            clearFields();
        } catch (NumberFormatException e) {
            showError("Invalid ID number. Please enter a valid integer.");
        }
    }

    @FXML
    public void onButtonDeleteClick() {
        Pasajero pasajero = pasajeroTableView.getSelectionModel().getSelectedItem();
        if (pasajero != null) {
            DBPasajero db = new DBPasajero();
            db.deleteData(pasajero);
            pasajeroList.remove(pasajero);
            pasajeroTableView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    public void onButtonSelectedClick() {
        Pasajero pasajero = pasajeroTableView.getSelectionModel().getSelectedItem();
        if (pasajero != null) {
            nombreField.setText(pasajero.getNombre());
            apellidoField.setText(pasajero.getApellido());
            idNumField.setText(String.valueOf(pasajero.getIdNum()));
            idTypeChoiceBox.setValue(pasajero.getIdType());
        } else {
            showError("Please select a passenger to update.");
        }
    }

    @FXML
    public void onButtonUpdateClick() {
        Pasajero pasajero = pasajeroTableView.getSelectionModel().getSelectedItem();
        if (pasajero != null) {
            try {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int idNum = Integer.parseInt(idNumField.getText());
                String idType = idTypeChoiceBox.getValue();

                Pasajero newPasajero = new Pasajero(nombre, apellido, idType, idNum);
                DBPasajero db = new DBPasajero();
                boolean updated = db.updateData(pasajero, newPasajero);
                if (updated) {
                    System.out.println("Passenger updated successfully.");
                } else {
                    System.out.println("Failed to update passenger.");
                }
                pasajero.setNombre(nombre);
                pasajero.setApellido(apellido);
                pasajero.setIdNum(idNum);
                pasajero.setIdType(idType);
                pasajeroTableView.refresh();
                pasajeroTableView.getSelectionModel().clearSelection();
                clearFields();
            } catch (NumberFormatException e) {
                showError("Invalid ID number. Please enter a valid integer.");
            }
        } else {
            showError("Please select a passenger to update.");
        }
    }

    private void clearFields() {
        nombreField.setText("");
        apellidoField.setText("");
        idNumField.setText("");
        idTypeChoiceBox.setValue(null);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
