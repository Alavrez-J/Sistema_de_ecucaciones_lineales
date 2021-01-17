package ec.edu.epn.g6;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

public class Ecuacion {
    float[] coeficiente;
    int tamanio;

    public Ecuacion(int t){
        this.tamanio = t+1;
        this.coeficiente = new float[tamanio];
        ingresarCoeficientes();
    }

    public void ingresarTamanio(){
        try {
            tamanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del sistema de ecuaciones"));

        }catch(NumberFormatException e){
            ingresarTamanio();

        }
    }

    public float[] ingresarCoeficientes(){
        String entrada;
        for(int i = 0; i< tamanio; i++){
            entrada=JOptionPane.showInputDialog("Ingrese el coeficiente"+(i+1));
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