package org.example.proyecto.classresources.sistema_reserva_vuelos;

public class Usuario {
    private String userID;
    private String userPassword;

    public Usuario(String userID, String userPassword) {
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }
}