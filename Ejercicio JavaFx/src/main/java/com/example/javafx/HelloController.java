package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label ageLabel;

    @FXML
    protected void onHelloButtonClick() {
        String name = nameTextField.getText();
        String age = ageTextField.getText();

        welcomeText.setText("Welcome to JavaFX Application!");
        nameLabel.setText("Mi nombre es " + name);
        ageLabel.setText("Mi edad es de " + age + " años");
    }
}