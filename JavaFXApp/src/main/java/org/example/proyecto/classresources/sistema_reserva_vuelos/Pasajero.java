
package org.example.proyecto.classresources.sistema_reserva_vuelos;


public class Pasajero {
    private String nombre;
    private String apellido;
    private String idType;
    private int idNum;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, String idType, int idNum) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
        this.idNum = idNum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }
    
    
}



   