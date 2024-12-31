
package org.example.proyecto.classresources.repositories;


import org.example.proyecto.classresources.sistema_reserva_vuelos.Aerolinea;
import org.example.proyecto.classresources.sistema_reserva_vuelos.ICrud;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class DBAerolinea extends DatabaseRepository implements ICrud<Aerolinea> {

    public DBAerolinea() {
        super("aerolineas.txt");
    }

    @Override
    public ArrayList<Aerolinea> getListData() {
        ArrayList<Aerolinea> aerolineas = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            aerolineas = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, "|");
                String nombre = tokens.nextToken();
                String paisOrigen = tokens.nextToken();
                String destinosQueCubre = tokens.nextToken();
                aerolineas.add(new Aerolinea(nombre, paisOrigen, destinosQueCubre));

            }
        }
        return aerolineas;
    }

    @Override
    public Boolean addData(Aerolinea aerolinea) {
        String lineAerolinea = aerolinea.getNombre() + "|" + aerolinea.getPaisOrigen() + "|" + aerolinea.getDestinosQueCubre();
        return this.fileManage.insertDataInFile(lineAerolinea+"\n");
    }

    @Override
    public Boolean updateData(Aerolinea oldAerolinea, Aerolinea newAerolinea) {
        String lineOldAerolinea = oldAerolinea.getNombre() + "|" + oldAerolinea.getPaisOrigen() + "|" + oldAerolinea.getDestinosQueCubre();
        String lineNewAerolinea = newAerolinea.getNombre() + "|" + newAerolinea.getPaisOrigen() + "|" + newAerolinea.getDestinosQueCubre();
        return this.fileManage.updateDataInFile(lineOldAerolinea, lineNewAerolinea);
    }

    @Override
    public void deleteData(Aerolinea aerolinea) {
        String lineAerolinea = aerolinea.getNombre() + "|" + aerolinea.getPaisOrigen() + "|" + aerolinea.getDestinosQueCubre();
        this.fileManage.deleteDataInFile(lineAerolinea);
    }

}
