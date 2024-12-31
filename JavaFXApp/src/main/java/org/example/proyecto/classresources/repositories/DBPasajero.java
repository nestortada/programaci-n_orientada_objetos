package org.example.proyecto.classresources.repositories;


import org.example.proyecto.classresources.sistema_reserva_vuelos.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class DBPasajero extends DatabaseRepository implements ICrud<Pasajero> {

    public DBPasajero() {
        super("pasajeros.txt");
    }

    @Override
    public ArrayList<Pasajero> getListData() {
        ArrayList<Pasajero> pasajeros = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            pasajeros = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, "|");
                String nombre = tokens.nextToken();
                String apellido = tokens.nextToken();
                String idType = tokens.nextToken();
                int idNum = Integer.parseInt(tokens.nextToken());
                pasajeros.add(new Pasajero(nombre, apellido, idType, idNum));
            }
        }
        return pasajeros;
    }

    @Override
    public Boolean addData(Pasajero pasajero) {
        String linePasajero = pasajero.getNombre() + "|" + pasajero.getApellido() + "|" + pasajero.getIdType() + "|" + pasajero.getIdNum();
        return this.fileManage.insertDataInFile(linePasajero+"\n");
    }

    @Override
    public Boolean updateData(Pasajero oldPasajero, Pasajero newPasajero) {
        String lineOldPasajero = oldPasajero.getNombre() + "|" + oldPasajero.getApellido() + "|" + oldPasajero.getIdType() + "|" + oldPasajero.getIdNum();
        String lineNewPasajero = newPasajero.getNombre() + "|" + newPasajero.getApellido() + "|" + newPasajero.getIdType() + "|" + newPasajero.getIdNum();
        return this.fileManage.updateDataInFile(lineOldPasajero, lineNewPasajero);
    }

    @Override
    public void deleteData(Pasajero pasajero) {
        String linePasajero = pasajero.getNombre() + "|" + pasajero.getApellido() + "|" + pasajero.getIdType() + "|" + pasajero.getIdNum();
        this.fileManage.deleteDataInFile(linePasajero);
    }
}

