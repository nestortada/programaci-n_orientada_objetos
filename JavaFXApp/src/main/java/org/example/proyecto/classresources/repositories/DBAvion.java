package org.example.proyecto.classresources.repositories;

import org.example.proyecto.classresources.sistema_reserva_vuelos.Aerolinea;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Avion;
import org.example.proyecto.classresources.sistema_reserva_vuelos.ICrud;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class DBAvion extends DatabaseRepository implements ICrud<Avion> {

    public DBAvion() {
        super("aviones.txt");
    }

    @Override
    public ArrayList<Avion> getListData() {
        ArrayList<Avion> aviones = new ArrayList<>();
        ArrayList<String> lines = this.fileManage.getDataOfFile();

        if (lines == null) {
            System.out.println("No data found in aviones.txt");
            return aviones;
        }

        for (String line : lines) {
            try {
                StringTokenizer tokens = new StringTokenizer(line, "|");
                int id = Integer.parseInt(tokens.nextToken().trim());
                int numSillas = Integer.parseInt(tokens.nextToken().trim());
                String modelo = tokens.nextToken().trim();
                String marca = tokens.nextToken().trim();
                String nombreAerolinea = tokens.nextToken().trim(); // Here, we only get the name of the airline
                Aerolinea aerolinea = new Aerolinea(nombreAerolinea); // Create an Aerolinea instance with just the name

                Avion avion = new Avion(id, numSillas, modelo, marca, aerolinea);
                aviones.add(avion);
            } catch (Exception e) {
                System.err.println("Error parsing line: " + line);
                e.printStackTrace();
            }
        }

        return aviones;
    }

    @Override
    public Boolean addData(Avion avion) {
        String lineAvion = avion.getId() + "|" + avion.getNumSillas() + "|" + avion.getModelo() + "|" + avion.getMarca() + "|" + avion.getAerolinea().getNombre();
        return this.fileManage.insertDataInFile(lineAvion + "\n");
    }

    @Override
    public Boolean updateData(Avion oldAvion, Avion newAvion) {
        String lineOldAvion = oldAvion.getId() + "|" + oldAvion.getNumSillas() + "|" + oldAvion.getModelo() + "|" + oldAvion.getMarca() + "|" + oldAvion.getAerolinea().getNombre();
        String lineNewAvion = newAvion.getId() + "|" + newAvion.getNumSillas() + "|" + newAvion.getModelo() + "|" + newAvion.getMarca() + "|" + newAvion.getAerolinea().getNombre();
        return this.fileManage.updateDataInFile(lineOldAvion, lineNewAvion);
    }

    @Override
    public void deleteData(Avion avion) {
        String lineAvion = avion.getId() + "|" + avion.getNumSillas() + "|" + avion.getModelo() + "|" + avion.getMarca() + "|" + avion.getAerolinea().getNombre();
        this.fileManage.deleteDataInFile(lineAvion);
    }
}
