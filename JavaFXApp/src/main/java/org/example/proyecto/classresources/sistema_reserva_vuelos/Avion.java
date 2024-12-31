
package org.example.proyecto.classresources.sistema_reserva_vuelos;


public class Avion {

    private int id;
    private int numSillas;
    private String modelo;
    private String marca;
    private Aerolinea aerolinea;

    public Avion() {
    }

    public Avion(int id, int numSillas, String modelo, String marca, Aerolinea aerolinea) {
        this.id = id;
        this.numSillas = numSillas;
        this.modelo = modelo;
        this.marca = marca;
        this.aerolinea = aerolinea;
    }

    public Avion(String s) {
        this.modelo=s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String tipo) {
        this.marca = tipo;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }
}
