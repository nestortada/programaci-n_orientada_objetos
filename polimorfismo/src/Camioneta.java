import java.lang.*;
public class Camioneta extends Carro {
        Boolean salir;
        public Camioneta(String marca, String modelo, Boolean salir) {
            super(marca, modelo);
            this.salir = salir;


        }
        public void manejar() {
            System.out.println("Manejando camioneta " + super.toString());
        }
        public void manejar(Boolean salir){
            System.out.println("El Carro puede salir " + salir);
        }
}
