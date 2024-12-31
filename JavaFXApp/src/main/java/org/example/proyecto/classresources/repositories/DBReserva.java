package org.example.proyecto.classresources.repositories;

import org.example.proyecto.classresources.sistema_reserva_vuelos.Cliente;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Reserva;
import org.example.proyecto.classresources.sistema_reserva_vuelos.ICrud;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class DBReserva extends DatabaseRepository implements ICrud<Reserva> {

    public DBReserva() {
        super("reservas.txt");
    }

    @Override
    public ArrayList<Reserva> getListData() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            for (String line : lines) {
                try {
                    StringTokenizer tokens = new StringTokenizer(line, "|");
                    int numReserva = Integer.parseInt(tokens.nextToken());
                    LocalDate dateReserva = LocalDate.parse(tokens.nextToken());
                    int equipaje = Integer.parseInt(tokens.nextToken());
                    String nombre = tokens.nextToken();
                    Cliente cliente = new Cliente(nombre);
                    int pasajerosList = Integer.parseInt(tokens.nextToken());
                    reservas.add(new Reserva(numReserva, dateReserva, cliente, equipaje, pasajerosList));
                } catch (NoSuchElementException | NumberFormatException | DateTimeParseException e) {
                    System.err.println("Skipping line due to error: " + line);
                }
            }
        }
        return reservas;
    }

    @Override
    public Boolean addData(Reserva reserva) {
        String lineReserva = reserva.getNumReserva() + "|" + reserva.getDateReserva() + "|" + reserva.getEquipaje() + "|" + reserva.getCliente().getNombre() + "|" + reserva.getPasajerosList();
        return this.fileManage.insertDataInFile(lineReserva + "\n");
    }

    @Override
    public Boolean updateData(Reserva oldReserva, Reserva newReserva) {
        String lineOldReserva = oldReserva.getNumReserva() + "|" + oldReserva.getDateReserva() + "|" + oldReserva.getEquipaje() + "|" + oldReserva.getCliente().getNombre() + "|" + oldReserva.getPasajerosList();
        String lineNewReserva = newReserva.getNumReserva() + "|" + newReserva.getDateReserva() + "|" + newReserva.getEquipaje() + "|" + newReserva.getCliente().getNombre() + "|" + newReserva.getPasajerosList();
        return this.fileManage.updateDataInFile(lineOldReserva, lineNewReserva);
    }

    @Override
    public void deleteData(Reserva reserva) {
        String lineReserva = reserva.getNumReserva() + "|" + reserva.getDateReserva() + "|" + reserva.getEquipaje() + "|" + reserva.getCliente().getNombre() + "|" + reserva.getPasajerosList();
        this.fileManage.deleteDataInFile(lineReserva);
    }

    // New methods to support Cliente updates and deletes
    public ArrayList<Reserva> findReservasByCliente(Cliente cliente) {
        ArrayList<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : getListData()) {
            if (reserva.getCliente().getNombre().equals(cliente.getNombre())) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }

    public void updateClienteInReservas(Cliente oldCliente, Cliente newCliente) {
        ArrayList<Reserva> reservas = getListData();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getNombre().equals(oldCliente.getNombre())) {
                reserva.setCliente(newCliente);
                updateData(reserva, reserva);
            }
        }
    }
}
