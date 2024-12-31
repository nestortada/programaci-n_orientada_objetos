
package org.example.proyecto.classresources.sistema_reserva_vuelos;


public class Aerolinea {
    
    private String nombre;
    private String paisOrigen;
    private String destinosQueCubre;

    public Aerolinea() {
    }

    public Aerolinea(String nombre, String paisOrigen, String destinosQueCubre) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.destinosQueCubre = destinosQueCubre;
    }

    public Aerolinea(String nombreAerolinea) {
        this.nombre = nombreAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getDestinosQueCubre() {
        return destinosQueCubre;
    }

    public void setDestinosQueCubre(String destinosQueCubre) {
        this.destinosQueCubre = destinosQueCubre;
    }
    
    //metodos de clase
    public void promocionarVuelo(){
        
    }
    
    public void generarPaquetesDeViaje(){
        
    }
    
}
