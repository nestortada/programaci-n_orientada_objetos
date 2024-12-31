import java.lang.*;
public class Main {
    public static void main(String[] args) {

        Sedan sedan = new Sedan("Toyota","Camry",false);
        sedan.menejar();
        sedan.manejar(false);

        Camioneta camioneta = new Camioneta("Ford","F-150", true);
        camioneta.menejar();
        camioneta.manejar(true);
    }
}