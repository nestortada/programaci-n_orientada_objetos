package org.example.proyecto.classresources.repositories;

import org.example.proyecto.classresources.sistema_reserva_vuelos.ICrud;
import org.example.proyecto.classresources.sistema_reserva_vuelos.Usuario;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class DBUsuario extends DatabaseRepository implements ICrud<Usuario> {

    public DBUsuario() {
        super("usuarios.txt");
    }

    @Override
    public ArrayList<Usuario> getListData() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, "|");
                String userID = tokens.nextToken();
                String userPassword = tokens.nextToken();
                usuarios.add(new Usuario(userID, userPassword));
            }
        }
        return usuarios;
    }

    @Override
    public Boolean addData(Usuario usuario) {
        String lineUsuario = usuario.getUserID() + "|" + usuario.getUserPassword();
        return this.fileManage.insertDataInFile(lineUsuario);
    }

    @Override
    public Boolean updateData(Usuario oldUsuario, Usuario newUsuario) {
        String lineOldUsuario = oldUsuario.getUserID() + "|" + oldUsuario.getUserPassword();
        String lineNewUsuario = newUsuario.getUserID() + "|" + newUsuario.getUserPassword();
        return this.fileManage.updateDataInFile(lineOldUsuario, lineNewUsuario);
    }

    @Override
    public void deleteData(Usuario usuario) {
        String lineUsuario = usuario.getUserID() + "|" + usuario.getUserPassword();
        this.fileManage.deleteDataInFile(lineUsuario);
    }
}

