import javax.swing.*;

public class fibonacci {
    public static void main(String[] args) {
        int[] serie;
        int num;
        int cont;

        num = Integer.parseInt(JOptionPane.showInputDialog("Escriba hasta el numero de la serie que desea llegar"));

        while (true) {
            if (num >= 0) {
                break;
            }
            else {
                num = Integer.parseInt(JOptionPane.showInputDialog("El numero de la serie debe ser mayor o igual a 0:  "));
            }
        }

        serie = new int[num + 1];

        for (cont = 0; num >= cont; cont++) {
            if (cont == 0) {
                serie[0] = 0;
            }
            else if (cont == 1) {
                serie[1] = 1;
            }
            else {
                serie[cont] = serie[cont - 1] + serie[cont - 2];
            }
        }

        JOptionPane.showMessageDialog(null, "El elemento " + num + " de la serie de Fibonacci es " + serie[num]);
    }
}

