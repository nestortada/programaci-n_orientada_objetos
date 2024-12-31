import java.lang.*;
public class Sedan extends Carro {
    Boolean salir;
    public Sedan(String marca, String modelo, Boolean salir) {
        super(marca, modelo);
        this.salir = salir;
    }
    public void manejar() {
        System.out.println("Manejando  Sedan " + super.toString());
    }
     public void manejar(Boolean salir){
         System.out.println("El Carro puede salir " + salir);
     }
}
