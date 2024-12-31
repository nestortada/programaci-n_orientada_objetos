package org.example.proyecto.classresources.sistema_reserva_vuelos;

import java.time.LocalDate; // Importar la clase LocalDate de java.time

public class Reserva {

    private int numReserva;
    private LocalDate dateReserva; // Cambiado a LocalDate
    private int equipaje = 0;
    private Cliente cliente;
    private int pasajerosList; // Cambiado a int

    public Reserva() {
    }

    public Reserva(int numReserva, LocalDate dateReserva, Cliente cliente, int equipaje, int pasajerosList) { // Modificado el tipo de dateReserva
        this.numReserva = numReserva;
        this.dateReserva = dateReserva;
        this.cliente = cliente;
        this.equipaje = equipaje;
        this.pasajerosList = pasajerosList;
    }


    public int getPasajerosList() {
        return pasajerosList;
    }

    public void setPasajerosList(int pasajerosList) {
        this.pasajerosList = pasajerosList;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public LocalDate getDateReserva() { // Cambiado el tipo de retorno
        return dateReserva;
    }

    public void setDateReserva(LocalDate dateReserva) { // Cambiado el tipo de parámetro
        this.dateReserva = dateReserva;
    }

    public int getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(int equipaje) {
        this.equipaje = equipaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
