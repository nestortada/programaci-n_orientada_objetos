
package org.example.proyecto.classresources.sistema_reserva_vuelos;


public class Lugar {
    
    private String pais;
    private String ciudad;
    private String aeropuerto;

    public Lugar(String pais, String ciudad, String aeropuerto) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.aeropuerto = aeropuerto;
    }

    public Lugar(String origen) {
        this.ciudad = origen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(String aeropuerto) {
        this.aeropuerto = aeropuerto;
    }


}
