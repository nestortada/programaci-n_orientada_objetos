package org.example.proyecto;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.proyecto.classresources.repositories.DBCliente;
import org.example.proyecto.classresources.repositories.DBReserva;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Cliente;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReservaController {
    @FXML
    private ObservableList<Reserva> reservaList = FXCollections.observableArrayList();
    @FXML
    private TableView<Reserva> reservaTableView;
    @FXML
    private TableColumn<Reserva, String> numReservaColumn;
    @FXML
    private TableColumn<Reserva, String> dateReservaColumn;
    @FXML
    private TableColumn<Reserva, String> equipajeColumn;
    @FXML
    private TableColumn<Reserva, String> clienteColumn;
    @FXML
    private TableColumn<Reserva, String> pasajerosListColumn;

    @FXML
    private TextField numReservaField;

    @FXML
    private TextField clienteField;

    @FXML
    private DatePicker dateReservaPicker;
    @FXML
    private Spinner<Integer> equipajeSpinner;
    @FXML
    private Spinner<Integer> pasajerosSpinner;

    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonDelete;

    @FXML
    private void initialize() {
        // Reserva
        DBReserva dbReserva = new DBReserva();
        ArrayList<Reserva> reservas = dbReserva.getListData();
        this.convertDataReserva();
        reservaList.setAll(reservas);
        reservaTableView.setItems(reservaList);

        // Configuración inicial de los spinners
        SpinnerValueFactory<Integer> equipajeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0);
        equipajeSpinner.setValueFactory(equipajeValueFactory);

        SpinnerValueFactory<Integer> pasajerosValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0);
        pasajerosSpinner.setValueFactory(pasajerosValueFactory);

        // Configuración del DatePicker
        dateReservaPicker.setValue(LocalDate.now());
    }

    private void convertDataReserva() {
        numReservaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumReserva())));
        dateReservaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateReserva().toString()));
        equipajeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEquipaje())));
        clienteColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        pasajerosListColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPasajerosList())));
    }

    @FXML
    public void onButtonRegisterClick() {
        try {
            int numReserva = Integer.parseInt(numReservaField.getText());
            LocalDate dateReserva = dateReservaPicker.getValue(); // Se obtiene el valor del DatePicker
            int equipaje = equipajeSpinner.getValue();
            String nombreCliente = clienteField.getText();
            int pasajerosList = pasajerosSpinner.getValue();

            if (!isClienteValid(nombreCliente)) {
                // Mostrar advertencia y opciones de clientes disponibles
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cliente no válido");
                alert.setHeaderText("El cliente ingresado no es válido.");
                alert.setContentText("Los clientes disponibles son: " + obtenerNombresClientes());
                alert.showAndWait();
                return;
            }

            Reserva reserva = new Reserva(numReserva, dateReserva, new Cliente(nombreCliente), equipaje, pasajerosList); // Establece numReserva y cliente vacíos por ahora
            DBReserva db = new DBReserva();
            db.addData(reserva);
            reservaList.add(reserva);
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
        Reserva reserva = reservaTableView.getSelectionModel().getSelectedItem();
        if (reserva != null) {
            DBReserva db = new DBReserva();
            db.deleteData(reserva);
            reservaList.remove(reserva);
            reservaTableView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    public void onButtonSelectedClick() {
        Reserva reserva = reservaTableView.getSelectionModel().getSelectedItem();
        if (reserva != null) {
            numReservaField.setText(String.valueOf(reserva.getNumReserva()));
            dateReservaPicker.setValue(reserva.getDateReserva());
            equipajeSpinner.getValueFactory().setValue(reserva.getEquipaje());
            clienteField.setText(reserva.getCliente().getNombre());
            pasajerosSpinner.getValueFactory().setValue(reserva.getPasajerosList());
        } else {
            System.out.println("Por favor seleccionar una reserva para actualizar");
        }
    }

    @FXML
    public void onButtonUpdateClick() {
        Reserva reserva = reservaTableView.getSelectionModel().getSelectedItem(); // Seleccionada la reserva a actualizar
        if (reserva != null) { // Se verifica que se haya seleccionado
            try {
                int numReserva = Integer.parseInt(numReservaField.getText());
                LocalDate dateReserva = dateReservaPicker.getValue(); // Se obtiene el valor del DatePicker
                int equipaje = equipajeSpinner.getValue();
                String nombreCliente = clienteField.getText();
                int pasajerosList = pasajerosSpinner.getValue();

                if (!isClienteValid(nombreCliente)) {
                    // Mostrar advertencia y opciones de clientes disponibles
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Cliente no válido");
                    alert.setHeaderText("El cliente ingresado no es válido.");
                    alert.setContentText("Los clientes disponibles son: " + obtenerNombresClientes());
                    alert.showAndWait();
                    return;
                }

                Reserva newReserva = new Reserva(numReserva, dateReserva, new Cliente(nombreCliente), equipaje, pasajerosList); // Define un nuevo objeto con la reserva que se quiere actualizar
                DBReserva db = new DBReserva();
                boolean updated = db.updateData(reserva, newReserva);
                if (updated) {
                    System.out.println("Se actualizó la reserva correctamente");
                } else {
                    System.out.println("No se actualizó la reserva");
                }
                reserva.setNumReserva(numReserva);
                reserva.setDateReserva(dateReserva);
                reserva.setEquipaje(equipaje);
                reserva.getCliente().setNombre(nombreCliente);
                reserva.setPasajerosList(pasajerosList);
                reservaTableView.refresh();
                reservaTableView.getSelectionModel().clearSelection();
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
            System.out.println("Por favor seleccionar una reserva para actualizar");
        }
    }

    private boolean isClienteValid(String nombreCliente) {
        DBCliente dbCliente = new DBCliente();
        ArrayList<Cliente> clientes = dbCliente.getListData();
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return true;
            }
        }
        return false;
    }

    private String obtenerNombresClientes() {
        DBCliente dbCliente = new DBCliente();
        ArrayList<Cliente> clientes = dbCliente.getListData();
        StringBuilder nombresClientes = new StringBuilder();
        for (Cliente cliente : clientes) {
            nombresClientes.append(cliente.getNombre()).append(", ");
        }
        // Eliminar la última coma y espacio
        if (nombresClientes.length() > 0) {
            nombresClientes.delete(nombresClientes.length() - 2, nombresClientes.length());
        }
        return nombresClientes.toString();
    }

    private void clearFields() {
        numReservaField.setText("");
        clienteField.setText("");
        dateReservaPicker.setValue(LocalDate.now());
        equipajeSpinner.getValueFactory().setValue(0);
        pasajerosSpinner.getValueFactory().setValue(0);
    }
}
