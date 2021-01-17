package ec.edu.epn.g6;
import javax.swing.*;

public class Main {
    static int tamanio;
    public static void main(String[] args) {
        Sistema s = new Sistema();
        ingresarTamanio();
        for(int i = 0; i<tamanio; i++) {
            Ecuacion ec = new Ecuacion(tamanio);
            s.llenarMatriz(ec);

        }
        JOptionPane.showMessageDialog(null,s.toString());
        s.getSolucion();
    }

    public static void ingresarTamanio(){
        try {
            tamanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del sistema de ecuaciones"));

        }catch(NumberFormatException e) {
            ingresarTamanio();

        }}
}