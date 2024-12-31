/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialPractico;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author abell
 */
//GRUPO FELIPE ABELLA Y NÉSTOR TABARES
public class GestionLibros {
    private ArrayList<Libro> listaLibros;

    public GestionLibros() {
        listaLibros = new ArrayList<>();
    }

    public void menu() {        
        int opcion;
        do{
            opcion=Integer.parseInt(JOptionPane.showInputDialog("""
                                                                ==========OPCIONES==========
                                                                1. Agregar libro 
                                                                2. Ver lista de libros 
                                                                3. Actualizar datos de un libro
                                                                4. Eliminar libro
                                                                0. Salir"""));
 
            switch(opcion)
            {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    listaLibros();
                    break;
                case 3:
                    actualizarLibro();
                    break;
                case 4:
                    eliminarLibro();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar nuestros servicios!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Opción inválida, inténtelo nuevamente!");
                    break;
            }
    }
        while (opcion != 0);
    }
    
    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        String nombreAutor = JOptionPane.showInputDialog("Ingrese el nombre del autor:");
        String apellidoAutor = JOptionPane.showInputDialog("Ingrese el apellido del autor:");
        Autor autor = new Autor(nombreAutor,apellidoAutor);
        listaLibros.add(new Libro(titulo, autor));
        JOptionPane.showMessageDialog(null, "¡Libro agregado exitosamente!");
    }
    
    private void listaLibros() {
        if (listaLibros.isEmpty()) {
        JOptionPane.showMessageDialog(null,"¡No hay libros agregados!");
    } else {
            String lista = "Lista de libros:\n";
        for (int i = 0; i < listaLibros.size(); i++) {
            lista += (i + 1) + ". " + listaLibros.get(i) + "\n";
        }
        System.out.println(lista);
        }
    }

    private void eliminarLibro() {
        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡No hay libros agregados!");
        }
        else{
            listaLibros();
            int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del libro que quiere eliminar:"));
            indice--;
            if (indice >= 0 && indice < listaLibros.size()) {
                listaLibros.remove(indice);
                JOptionPane.showMessageDialog(null, "¡Libro eliminado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido, inténtelo nuevamente");
            }
        }
    }

    private void actualizarLibro() {
        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡No hay libros agregados!");
        }
        else{
            listaLibros();
            int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del libro que quiere actualizar:"));
            indice--;
            if (indice >= 0 && indice < listaLibros.size()) {
                listaLibros.remove(indice);
                String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
                String nombreAutor = JOptionPane.showInputDialog("Ingrese el nombre del autor:");
                String apellidoAutor = JOptionPane.showInputDialog("Ingrese el apellido del autor:");
                Autor autor = new Autor(nombreAutor,apellidoAutor);
                listaLibros.add(new Libro(titulo, autor));
                JOptionPane.showMessageDialog(null, "¡Libro actualizado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido, inténtelo nuevamente");
            }
        }
    }
}