public class carro {

        private String marca;
        private String modelo;
        private static Tablero tablero;

        public carro(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
            tablero = new Tablero();
        }

        public void mostrarInfo() {
            System.out.println("Marca: " + marca + ", Modelo: " + modelo);
            tablero.mostrarEstado();
        }

        public static class Tablero {
            private int velocidad;
            private int gasolina;

            public Tablero() {
                this.velocidad = 0;
                this.gasolina = 100;
            }

            public void mostrarEstado() {
                System.out.println("Velocidad: " + velocidad + ", Gasolina: " + gasolina + "%");
            }
        }

}
