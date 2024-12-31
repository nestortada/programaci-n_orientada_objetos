package org.example.proyecto;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.proyecto.classresources.repositories.DBAerolinea;
import org.example.proyecto.classresources.repositories.DBAvion;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Aerolinea;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Avion;

import java.util.ArrayList;

public class AerolineaController {
    @FXML
    private ObservableList<Aerolinea> aerolineaList = FXCollections.observableArrayList();
    @FXML
    private TableView<Aerolinea> aerolineaTableView;
    @FXML
    private TableColumn<Aerolinea, String> nombreColumn;
    @FXML
    private TableColumn<Aerolinea, String> paisOrigenColumn;
    @FXML
    private TableColumn<Aerolinea, String> destinosQueCubreColumn;

    @FXML
    private TextField Destino;
    @FXML
    private TextField nombre;
    @FXML
    private TextField PaisOrigen;

    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonDelete;

    @FXML
    private void initialize() {
        DBAerolinea dbAerolinea = new DBAerolinea();
        ArrayList<Aerolinea> aerolineas = dbAerolinea.getListData();
        aerolineaList.setAll(aerolineas);
        convertDataAerolinea();
        aerolineaTableView.setItems(aerolineaList);
    }

    private void convertDataAerolinea() {
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        paisOrigenColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaisOrigen()));
        destinosQueCubreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestinosQueCubre()));
    }

    public void onButtonRegisterClick() {
        if (isAerolineaNameUsed(nombre.getText())) {
            System.out.println("El nombre de la aerolínea ya está en uso. Por favor, elige otro nombre.");
            return;
        }

        Aerolinea aerolinea = new Aerolinea(nombre.getText(), PaisOrigen.getText(), Destino.getText());
        aerolineaList.add(aerolinea);
        DBAerolinea db = new DBAerolinea();
        db.addData(aerolinea);
        nombre.setText("");
        PaisOrigen.setText("");
        Destino.setText("");
    }

    public void onButtonDeleteClick() {
        Aerolinea aerolinea = aerolineaTableView.getSelectionModel().getSelectedItem();
        if (aerolinea != null) {
            DBAvion dbAvion = new DBAvion();
            ArrayList<Avion> aviones = dbAvion.getListData();
            boolean aerolineaEnUso = aviones.stream().anyMatch(avion -> avion.getAerolinea().getNombre().equals(aerolinea.getNombre()));

            if (!aerolineaEnUso) {
                DBAerolinea db = new DBAerolinea();
                db.deleteData(aerolinea);
                aerolineaList.remove(aerolinea);
                aerolineaTableView.getSelectionModel().clearSelection();
            } else {
                System.out.println("No se puede eliminar la aerolínea, hay aviones asociados.");
            }
        }
    }

    public void onButtonSelectedClick() {
        Aerolinea aerolinea = aerolineaTableView.getSelectionModel().getSelectedItem();
        if (aerolinea != null) {
            nombre.setText(aerolinea.getNombre());
            PaisOrigen.setText(aerolinea.getPaisOrigen());
            Destino.setText(aerolinea.getDestinosQueCubre());
        } else {
            System.out.println("Por favor seleccionar una aerolínea para actualizar");
        }
    }

    public void onButtonUpdateClick() {
        Aerolinea selectedAerolinea = aerolineaTableView.getSelectionModel().getSelectedItem();
        if (selectedAerolinea == null) {
            System.out.println("Por favor seleccionar una aerolínea para actualizar");
            return;
        }

        if (!selectedAerolinea.getNombre().equalsIgnoreCase(nombre.getText()) && isAerolineaNameUsed(nombre.getText())) {
            System.out.println("El nombre de la aerolínea ya está en uso. Por favor, elige otro nombre.");
            return;
        }

        Aerolinea newAerolinea = new Aerolinea(nombre.getText(), PaisOrigen.getText(), Destino.getText());
        DBAerolinea db = new DBAerolinea();
        boolean updated = db.updateData(selectedAerolinea, newAerolinea);
        if (updated) {
            updateAssociatedAviones(selectedAerolinea, newAerolinea);
            System.out.println("Se actualizó la aerolínea correctamente");
            aerolineaList.set(aerolineaList.indexOf(selectedAerolinea), newAerolinea);
            aerolineaTableView.refresh();
            nombre.setText("");
            PaisOrigen.setText("");
            Destino.setText("");
        } else {
            System.out.println("No se actualizó la aerolínea");
        }
        aerolineaTableView.getSelectionModel().clearSelection();
    }

    private boolean isAerolineaNameUsed(String name) {
        return aerolineaList.stream().anyMatch(a -> a.getNombre().equalsIgnoreCase(name));
    }

    private void updateAssociatedAviones(Aerolinea oldAerolinea, Aerolinea newAerolinea) {
        DBAvion dbAvion = new DBAvion();
        ArrayList<Avion> aviones = dbAvion.getListData();
        for (Avion avion : aviones) {
            if (avion.getAerolinea().getNombre().equals(oldAerolinea.getNombre())) {
                avion.getAerolinea().setNombre(newAerolinea.getNombre());
                dbAvion.updateData(avion, avion);
            }
        }
    }
}
