package org.example.proyecto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.proyecto.classresources.repositories.DBCliente;
import org.example.proyecto.classresources.repositories.DBReserva;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Cliente;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Reserva;

import java.util.ArrayList;

public class ClienteController {
    private ObservableList<Cliente> clienteList = FXCollections.observableArrayList();

    @FXML
    private TableView<Cliente> clienteTableView;
    @FXML
    private TableColumn<Cliente, String> nombreColumn;
    @FXML
    private TableColumn<Cliente, String> apellidoColumn;
    @FXML
    private TableColumn<Cliente, Integer> numIdColumn;
    @FXML
    private TableColumn<Cliente, String> tipoIdColumn;
    @FXML
    private TableColumn<Cliente, String> nacionalidadColumn;
    @FXML
    private TableColumn<Cliente, String> correoColumn;

    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField numIdField;
    @FXML
    private ChoiceBox<String> tipoIdChoiceBox;
    @FXML
    private TextField nacionalidadField;
    @FXML
    private TextField correoField;

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
        tipoIdChoiceBox.setItems(FXCollections.observableArrayList("CC", "TI", "CE", "PAS"));

        // Load clients
        DBCliente dbCliente = new DBCliente();
        ArrayList<Cliente> clientes = dbCliente.getListData();
        convertDataCliente();
        clienteList.setAll(clientes);
        clienteTableView.setItems(clienteList);
    }

    private void convertDataCliente() {
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        apellidoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        numIdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumId()).asObject());
        tipoIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoId()));
        nacionalidadColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNacionalidad()));
        correoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
    }

    @FXML
    public void onButtonRegisterClick() {
        try {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            int numId = Integer.parseInt(numIdField.getText());
            String tipoId = tipoIdChoiceBox.getValue();
            String nacionalidad = nacionalidadField.getText();
            String correo = correoField.getText();

            Cliente cliente = new Cliente(nombre, apellido, numId, tipoId, nacionalidad, correo);
            clienteList.add(cliente);
            DBCliente db = new DBCliente();
            db.addData(cliente);
            clearFields();
        } catch (NumberFormatException e) {
            showError("Invalid ID number. Please enter a valid integer.");
        }
    }

    @FXML
    public void onButtonDeleteClick() {
        Cliente cliente = clienteTableView.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            DBReserva dbReserva = new DBReserva();
            ArrayList<Reserva> reservas = dbReserva.findReservasByCliente(cliente);
            if (!reservas.isEmpty()) {
                showError("Cannot delete client with existing reservations.");
                return;
            }
            DBCliente dbCliente = new DBCliente();
            dbCliente.deleteData(cliente);
            clienteList.remove(cliente);
            clienteTableView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    public void onButtonSelectedClick() {
        Cliente cliente = clienteTableView.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            nombreField.setText(cliente.getNombre());
            apellidoField.setText(cliente.getApellido());
            numIdField.setText(String.valueOf(cliente.getNumId()));
            tipoIdChoiceBox.setValue(cliente.getTipoId());
            nacionalidadField.setText(cliente.getNacionalidad());
            correoField.setText(cliente.getCorreo());
        } else {
            showError("Please select a client to update.");
        }
    }

    @FXML
    public void onButtonUpdateClick() {
        Cliente cliente = clienteTableView.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            try {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int numId = Integer.parseInt(numIdField.getText());
                String tipoId = tipoIdChoiceBox.getValue();
                String nacionalidad = nacionalidadField.getText();
                String correo = correoField.getText();

                Cliente newCliente = new Cliente(nombre, apellido, numId, tipoId, nacionalidad, correo);
                DBCliente dbCliente = new DBCliente();
                boolean updated = dbCliente.updateData(cliente, newCliente);
                if (updated) {
                    DBReserva dbReserva = new DBReserva();
                    dbReserva.updateClienteInReservas(cliente, newCliente);
                    System.out.println("Client updated successfully.");
                } else {
                    System.out.println("Failed to update client.");
                }
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setNumId(numId);
                cliente.setTipoId(tipoId);
                cliente.setNacionalidad(nacionalidad);
                cliente.setCorreo(correo);
                clienteTableView.refresh();
                clienteTableView.getSelectionModel().clearSelection();
                clearFields();
            } catch (NumberFormatException e) {
                showError("Invalid ID number. Please enter a valid integer.");
            }
        } else {
            showError("Please select a client to update.");
        }
    }

    private void clearFields() {
        nombreField.setText("");
        apellidoField.setText("");
        numIdField.setText("");
        tipoIdChoiceBox.setValue(null);
        nacionalidadField.setText("");
        correoField.setText("");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
