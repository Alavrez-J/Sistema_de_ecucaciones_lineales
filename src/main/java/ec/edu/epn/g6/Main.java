package ec.edu.epn.g6;
import javax.swing.*;
import java.util.Scanner;

public class Main {
    static int tamanio;
    public static void main(String[] args) {
        Sistema s = new Sistema();
        ingresarTamanio();
        for(int i = 0; i<tamanio; i++) {
            Ecuacion ec = new Ecuacion(tamanio);
            s.llenarMatriz(ec);

        }
        System.out.println(s.toString());
        s.getSolucion();
        System.out.println("cambio");
    }

    public static void ingresarTamanio(){
        Scanner s;
        try {
            System.out.println("Ingrese el tamaño del sistema de ecuaciones");
            s = new Scanner(System.in);
            tamanio = Integer.parseInt(s.next());

        }catch(NumberFormatException e) {
            ingresarTamanio();

        }}
}