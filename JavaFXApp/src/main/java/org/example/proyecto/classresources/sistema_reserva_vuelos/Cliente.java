
package org.example.proyecto.classresources.sistema_reserva_vuelos;


public class Cliente extends Persona{

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int numId, String tipoId, String nacionalidad, String correo) {
        super(nombre, apellido, numId, tipoId, nacionalidad, correo);
    }

    public Cliente(String nombre) {
        super(nombre);
    }

    public Cliente(String newUserNameString, int newUserIdentificationInt, String newUserEmailString) {

    }


    //metodos de clase
    @Override
    public void obtenerItinerario(){
        
    }
    
    public void responderEncuesta(){
        encuestaSatisfaccion();
    }
    
    @Override
    public void actualizarDatos(){
        
    }
    
    public void registrar(){
        
    }



}
