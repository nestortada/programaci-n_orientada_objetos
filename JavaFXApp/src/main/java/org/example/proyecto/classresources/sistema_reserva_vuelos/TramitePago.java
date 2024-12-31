
package org.example.proyecto.classresources.sistema_reserva_vuelos;

//Esta clase se llamaba cuenta bancaria
public class TramitePago {

    private int montoPago;
    private boolean exitoTransaccion;
    private Cliente cliente;

    public TramitePago() {
    }

    public TramitePago(int montoPago, boolean exitoTransaccion, Cliente cliente) {
        this.montoPago = montoPago;
        this.exitoTransaccion = exitoTransaccion;
        this.cliente = cliente;
    }

    public int getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(int montoPago) {
        this.montoPago = montoPago;
    }

    public boolean isExitoTransaccion() {
        return exitoTransaccion;
    }

    public void setExitoTransaccion(boolean exitoTransaccion) {
        this.exitoTransaccion = exitoTransaccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    //metodos de clase
    public void aprobacionPago(){

    }
}
