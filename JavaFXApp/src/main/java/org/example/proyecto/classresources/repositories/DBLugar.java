package org.example.proyecto.classresources.repositories;

import org.example.proyecto.classresources.sistema_reserva_vuelos.Lugar;
import org.example.proyecto.classresources.sistema_reserva_vuelos.ICrud;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class DBLugar extends DatabaseRepository implements ICrud<Lugar> {

    public DBLugar() {
        super("lugares.txt");
    }

    @Override
    public ArrayList<Lugar> getListData() {
        ArrayList<Lugar> lugares = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            lugares = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, "|");
                try {
                    String pais = tokens.nextToken();
                    String ciudad = tokens.nextToken();
                    String aeropuerto = tokens.nextToken();
                    lugares.add(new Lugar(pais, ciudad, aeropuerto));
                } catch (NoSuchElementException e) {
                    System.err.println("Skipping line due to missing tokens: " + line);
                }
            }
        }
        return lugares;
    }

    @Override
    public Boolean addData(Lugar lugar) {
        String lineLugar = lugar.getPais() + "|" + lugar.getCiudad() + "|" + lugar.getAeropuerto();
        return this.fileManage.insertDataInFile(lineLugar+"\n");
    }

    @Override
    public Boolean updateData(Lugar oldLugar, Lugar newLugar) {
        String lineOldLugar = oldLugar.getPais() + "|" + oldLugar.getCiudad() + "|" + oldLugar.getAeropuerto();
        String lineNewLugar = newLugar.getPais() + "|" + newLugar.getCiudad() + "|" + newLugar.getAeropuerto();
        return this.fileManage.updateDataInFile(lineOldLugar, lineNewLugar);
    }

    @Override
    public void deleteData(Lugar lugar) {
        String lineLugar = lugar.getPais() + "|" + lugar.getCiudad() + "|" + lugar.getAeropuerto();
        this.fileManage.deleteDataInFile(lineLugar);
    }
}
