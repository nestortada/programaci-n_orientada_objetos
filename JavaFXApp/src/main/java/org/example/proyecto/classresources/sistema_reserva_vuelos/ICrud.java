
package org.example.proyecto.classresources.sistema_reserva_vuelos;


import java.util.ArrayList;

public interface ICrud<T> {
    ArrayList<T> getListData(); //Read
    Boolean addData(T data); //Create
    Boolean updateData(T oldData, T newData); //Update
    void deleteData(T data); //Delete
}
