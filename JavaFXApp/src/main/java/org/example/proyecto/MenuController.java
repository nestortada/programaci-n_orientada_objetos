package org.example.proyecto;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    public void OnButtonAerolinea() {
        loadFXML("Aerolinea-view.fxml");
    }

    public void OnButtonAvion() {
        loadFXML("Aviones-view.fxml");
    }

    public void OnButtonCliente() {
        loadFXML("Cliente-view.fxml");
    }

    public void OnButtonLugar() {
        loadFXML("Lugar-view.fxml");
    }

    public void OnButtonPasajero() {
        loadFXML("Pasajero-view.fxml");
    }

    public void OnButtonReserva() {
        loadFXML("Reserva-view.fxml");
    }

    public void OnButtonVuelos() {
        loadFXML("Vuelo-view.fxml");
    }

    private void loadFXML(String fxmlFileName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
