package org.example.proyecto.classresources.repositories;

import org.example.proyecto.classresources.sistema_reserva_vuelos.Avion;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Lugar;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Vuelo;
import org.example.proyecto.classresources.sistema_reserva_vuelos.ICrud;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class DBVuelo extends DatabaseRepository implements ICrud<Vuelo> {

    public DBVuelo() {
        super("vuelos.txt");
    }

    @Override
    public ArrayList<Vuelo> getListData() {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            for (String line : lines) {
                try {
                    StringTokenizer tokens = new StringTokenizer(line, "|");
                    int flightId = Integer.parseInt(tokens.nextToken());
                    String origen = tokens.nextToken();
                    Lugar lugarorigen = new Lugar(origen);
                    LocalDateTime fechaSalida = LocalDateTime.parse(tokens.nextToken());
                    Lugar destino = new Lugar(tokens.nextToken());
                    double precio = Double.parseDouble(tokens.nextToken());
                    String nombreAvion = tokens.nextToken();
                    Avion avion = new Avion(nombreAvion);
                    vuelos.add(new Vuelo(flightId, lugarorigen, fechaSalida, destino, precio, avion));
                } catch (NoSuchElementException | NumberFormatException | DateTimeParseException e) {
                    System.err.println("Skipping line due to error: " + line);
                }
            }
        }
        return vuelos;
    }

    @Override
    public Boolean addData(Vuelo vuelo) {
        String lineVuelo = vuelo.getFlightId() + "|" + vuelo.getOrigen().getCiudad() + "|" + vuelo.getFechaSalida() + "|" + vuelo.getDestino().getCiudad() + "|" + vuelo.getPrecio() + "|" + vuelo.getAvion().getModelo();
        return this.fileManage.insertDataInFile(lineVuelo + "\n");
    }

    @Override
    public Boolean updateData(Vuelo oldVuelo, Vuelo newVuelo) {
        String lineOldVuelo = oldVuelo.getFlightId() + "|" + oldVuelo.getOrigen().getCiudad() + "|" + oldVuelo.getFechaSalida() + "|" + oldVuelo.getDestino().getCiudad() + "|" + oldVuelo.getPrecio() + "|" + oldVuelo.getAvion().getModelo();
        String lineNewVuelo = newVuelo.getFlightId() + "|" + newVuelo.getOrigen().getCiudad() + "|" + newVuelo.getFechaSalida() + "|" + newVuelo.getDestino().getCiudad() + "|" + newVuelo.getPrecio() + "|" + newVuelo.getAvion().getModelo();
        return this.fileManage.updateDataInFile(lineOldVuelo, lineNewVuelo);
    }

    @Override
    public void deleteData(Vuelo vuelo) {
        String lineVuelo = vuelo.getFlightId() + "|" + vuelo.getOrigen().getCiudad() + "|" + vuelo.getFechaSalida() + "|" + vuelo.getDestino().getCiudad() + "|" + vuelo.getPrecio() + "|" + vuelo.getAvion().getModelo();
        this.fileManage.deleteDataInFile(lineVuelo);
    }

    public void updateAvionInVuelos(String oldModelo, Avion newAvion) {
        ArrayList<Vuelo> vuelos = getListData();
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getAvion().getModelo().equals(oldModelo)) {
                vuelo.setAvion(newAvion);
                updateData(vuelo, vuelo); // Actualiza el vuelo con la nueva información del avión
            }
        }
    }
}
