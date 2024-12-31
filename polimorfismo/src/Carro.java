import java.lang.*;
public class Carro {
    private String marca;
    private String modelo;

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void menejar() {
        System.out.println("Manejando un " + marca + " " + modelo);
    }
}
