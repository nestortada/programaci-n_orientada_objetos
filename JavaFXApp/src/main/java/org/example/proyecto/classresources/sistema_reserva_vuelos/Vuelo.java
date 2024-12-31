package org.example.proyecto.classresources.sistema_reserva_vuelos;

import java.time.LocalDateTime;

public class Vuelo {
    private int flightId;
    private Lugar origen;
    private LocalDateTime fechaSalida; // Cambio de tipo de dato
    private Lugar destino;
    private double precio;
    private Avion avion;

    public Vuelo(int flightId, Lugar origen, LocalDateTime fechaSalida, Lugar destino, double precio, Avion avion) {
        this.flightId = flightId;
        this.origen = origen;
        this.fechaSalida = fechaSalida;
        this.destino = destino;
        this.precio = precio;
        this.avion = avion;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Lugar getOrigen() {
        return origen;
    }

    public void setOrigen(Lugar origen) {
        this.origen = origen;
    }

    public LocalDateTime getFechaSalida() { // Cambio en el tipo de retorno
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) { // Cambio en el tipo de parámetro
        this.fechaSalida = fechaSalida;
    }

    public Lugar getDestino() {
        return destino;
    }

    public void setDestino(Lugar destino) {
        this.destino = destino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
