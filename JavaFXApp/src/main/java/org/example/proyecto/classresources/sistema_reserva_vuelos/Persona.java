
package org.example.proyecto.classresources.sistema_reserva_vuelos;


abstract class Persona {
    
    private String nombre;
    private String apellido;
    private int numId;
    private String tipoId;
    private String nacionalidad;
    private String correo;
    private String addInfo;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int numId, String tipoId, String nacionalidad, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numId = numId;
        this.tipoId = tipoId;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public abstract void obtenerItinerario();
    
    public void encuestaSatisfaccion(){
        
    }
    
    public abstract void actualizarDatos();

    public  String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}
