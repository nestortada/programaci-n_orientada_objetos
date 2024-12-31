package org.example.proyecto.classresources.repositories;

import org.example.proyecto.classresources.sistema_reserva_vuelos.Cliente;
import org.example.proyecto.classresources.sistema_reserva_vuelos.ICrud;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class DBCliente extends DatabaseRepository implements ICrud<Cliente> {

    public DBCliente() {
        super("clientes.txt");
    }

    @Override
    public ArrayList<Cliente> getListData() {
        ArrayList<Cliente> clientes = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            clientes = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, "|");
                try {
                    String nombre = tokens.nextToken();
                    String apellido = tokens.nextToken();
                    int numId = Integer.parseInt(tokens.nextToken());
                    String tipoId = tokens.nextToken();
                    String nacionalidad = tokens.nextToken();
                    String correo = tokens.nextToken();
                    clientes.add(new Cliente(nombre, apellido, numId, tipoId, nacionalidad, correo));
                } catch (NoSuchElementException | NumberFormatException e) {
                    System.err.println("Skipping line due to error: " + line);
                }
            }
        }
        return clientes;
    }

    @Override
    public Boolean addData(Cliente cliente) {
        String lineCliente = cliente.getNombre() + "|" + cliente.getApellido() + "|" + cliente.getNumId() + "|" + cliente.getTipoId() + "|" + cliente.getNacionalidad() + "|" + cliente.getCorreo();
        return this.fileManage.insertDataInFile(lineCliente+ "\n");
    }

    @Override
    public Boolean updateData(Cliente oldCliente, Cliente newCliente) {
        String lineOldCliente = oldCliente.getNombre() + "|" + oldCliente.getApellido() + "|" + oldCliente.getNumId() + "|" + oldCliente.getTipoId() + "|" + oldCliente.getNacionalidad() + "|" + oldCliente.getCorreo();
        String lineNewCliente = newCliente.getNombre() + "|" + newCliente.getApellido() + "|" + newCliente.getNumId() + "|" + newCliente.getTipoId() + "|" + newCliente.getNacionalidad() + "|" + newCliente.getCorreo();
        return this.fileManage.updateDataInFile(lineOldCliente, lineNewCliente);
    }

    @Override
    public void deleteData(Cliente cliente) {
        String lineCliente = cliente.getNombre() + "|" + cliente.getApellido() + "|" + cliente.getNumId() + "|" + cliente.getTipoId() + "|" + cliente.getNacionalidad() + "|" + cliente.getCorreo();
        this.fileManage.deleteDataInFile(lineCliente);
    }
}
