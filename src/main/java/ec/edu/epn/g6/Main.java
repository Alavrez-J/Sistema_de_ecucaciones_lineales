package ec.edu.epn.g6;
import javax.swing.*;
import java.util.Scanner;

public class Main {
    static int tamanio;
    public static void main(String[] args) {
        Sistema s = new Sistema();
        float[] esperado = {0,5};

        float a[]={1,1,5};
        Ecuacion ecu1 = new Ecuacion(2,a);
        s.llenarMatriz(ecu1);

        float b[] = {3,4,11};
        Ecuacion ecu2 = new Ecuacion(2,b);
        s.llenarMatriz(ecu2);
        s.getSolucion();

        System.out.println("cambio 3");
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