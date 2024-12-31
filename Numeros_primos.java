import javax.swing.*;

public class Numeros_primos {
    public static void main(String[] args){
        int cont;
        int num;
        cont =1;
        num = Integer.parseInt(JOptionPane.showInputDialog("Escriba un valor"));
        while (num<1){
            num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero mayor o igual a 1:   "));
        }
        while (true){
            if (num%cont==0 & num!=cont & cont!=1){
                JOptionPane.showMessageDialog(null , "El numero "+ num + " no es un numero primo");
                break;
            }
            else{
                if(num == cont){
                    JOptionPane.showMessageDialog(null, "El numero "+ num + " es un numero primo");
                    break;
                }
                else{
                    cont = cont +1;
                }
            }
        }


    }

}
