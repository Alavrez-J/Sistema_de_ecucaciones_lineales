package ec.edu.epn.g6;


import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ecuacion {
    float[] coeficiente;
    int tamanio;

    public Ecuacion(int t){
        this.tamanio = t+1;
        this.coeficiente = new float[tamanio];
        ingresarCoeficientes();
    }

    public Ecuacion(int t,float[] coef){
        this.tamanio = t+1;
        this.coeficiente = coef;

    }

    public void ingresarTamanio(){
        Scanner s;
        try {
            System.out.println("Ingrese el tamaño del sistema de ecuaciones");
            s= new Scanner(System.in);
            tamanio = Integer.parseInt(s.next());

        }catch(NumberFormatException e){
            ingresarTamanio();

        }
    }

    public float[] ingresarCoeficientes(){
        String entrada;
        Scanner s;
        for(int i = 0; i< tamanio; i++){

            System.out.println("Ingrese el coeficiente"+(i+1));
            s= new Scanner(System.in);
            entrada=s.next();
            coeficiente[i]=Float.parseFloat(entrada);
        }
        return coeficiente;
    }


    @Override
    public String toString() {
        String salida = "";
        for(int i =0; i<tamanio-2; i++){
            salida+=coeficiente[i]+"x"+(i+1)+ " + ";
        }
        salida+=coeficiente[this.coeficiente.length-2]+"x"+(this.coeficiente.length-1)+" = "+coeficiente[this.coeficiente.length-1];
        return salida;
    }
}