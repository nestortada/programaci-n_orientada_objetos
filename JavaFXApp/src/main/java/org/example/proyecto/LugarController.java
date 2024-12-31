package org.example.proyecto;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.proyecto.classresources.repositories.DBLugar;
import org.example.proyecto.classresources.repositories.DBVuelo;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Lugar;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Vuelo;

import java.util.ArrayList;

public class LugarController {
    private ObservableList<Lugar> lugarList = FXCollections.observableArrayList();
    private DBVuelo dbVuelo = new DBVuelo();

    @FXML
    private TableView<Lugar> lugarTableView;
    @FXML
    private TableColumn<Lugar, String> paisColumn;
    @FXML
    private TableColumn<Lugar, String> ciudadColumn;
    @FXML
    private TableColumn<Lugar, String> aeropuertoColumn;

    @FXML
    private TextField paisField;
    @FXML
    private TextField ciudadField;
    @FXML
    private TextField aeropuertoField;

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
        // Load places
        DBLugar dbLugar = new DBLugar();
        ArrayList<Lugar> lugares = dbLugar.getListData();
        convertDataLugar();
        lugarList.setAll(lugares);
        lugarTableView.setItems(lugarList);
    }

    private void convertDataLugar() {
        paisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPais()));
        ciudadColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCiudad()));
        aeropuertoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAeropuerto()));
    }

    @FXML
    public void onButtonRegisterClick() {
        String pais = paisField.getText();
        String ciudad = ciudadField.getText();
        String aeropuerto = aeropuertoField.getText();

        Lugar lugar = new Lugar(pais, ciudad, aeropuerto);
        lugarList.add(lugar);
        DBLugar db = new DBLugar();
        db.addData(lugar);
        clearFields();
    }

    @FXML
    public void onButtonDeleteClick() {
        Lugar lugar = lugarTableView.getSelectionModel().getSelectedItem();
        if (lugar != null) {
            ArrayList<Vuelo> vuelos = dbVuelo.getListData();
            boolean enUso = vuelos.stream()
                    .anyMatch(vuelo -> vuelo.getOrigen().getCiudad().equals(lugar.getCiudad()) ||
                            vuelo.getDestino().getCiudad().equals(lugar.getCiudad()));
            if (enUso) {
                showError("No se puede eliminar el lugar porque está en uso en un vuelo.");
            } else {
                DBLugar db = new DBLugar();
                db.deleteData(lugar);
                lugarList.remove(lugar);
                lugarTableView.getSelectionModel().clearSelection();
            }
        }
    }

    @FXML
    public void onButtonSelectedClick() {
        Lugar lugar = lugarTableView.getSelectionModel().getSelectedItem();
        if (lugar != null) {
            paisField.setText(lugar.getPais());
            ciudadField.setText(lugar.getCiudad());
            aeropuertoField.setText(lugar.getAeropuerto());
        } else {
            showError("Please select a place to update.");
        }
    }

    @FXML
    public void onButtonUpdateClick() {
        Lugar lugar = lugarTableView.getSelectionModel().getSelectedItem();
        if (lugar != null) {
            String pais = paisField.getText();
            String ciudad = ciudadField.getText();
            String aeropuerto = aeropuertoField.getText();

            Lugar newLugar = new Lugar(pais, ciudad, aeropuerto);
            DBLugar db = new DBLugar();
            boolean updated = db.updateData(lugar, newLugar);
            if (updated) {
                // Actualizar vuelos asociados
                ArrayList<Vuelo> vuelos = dbVuelo.getListData();
                for (Vuelo vuelo : vuelos) {
                    boolean modificado = false;
                    if (vuelo.getOrigen().getCiudad().equals(lugar.getCiudad())) {
                        vuelo.setOrigen(newLugar);
                        modificado = true;
                    }
                    if (vuelo.getDestino().getCiudad().equals(lugar.getCiudad())) {
                        vuelo.setDestino(newLugar);
                        modificado = true;
                    }
                    if (modificado) {
                        dbVuelo.updateData(vuelo, vuelo); // Update vuelo in the database
                    }
                }
                System.out.println("Place updated successfully.");
                lugar.setPais(pais);
                lugar.setCiudad(ciudad);
                lugar.setAeropuerto(aeropuerto);
                lugarTableView.refresh();
                lugarTableView.getSelectionModel().clearSelection();
                clearFields();
            } else {
                System.out.println("Failed to update place.");
            }
        } else {
            showError("Please select a place to update.");
        }
    }

    private void clearFields() {
        paisField.setText("");
        ciudadField.setText("");
        aeropuertoField.setText("");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
