package ec.edu.epn.g6;

import javax.swing.*;
import java.util.ArrayList;

public class Sistema {
    ArrayList <Ecuacion>matrizCoeficientes;
    float []dRet;
    public Sistema(){
        this.matrizCoeficientes = new ArrayList<Ecuacion>();
        this.dRet = new float[this.matrizCoeficientes.size()];
    }

    public void llenarMatriz(Ecuacion ec){
        matrizCoeficientes.add(ec);
    }

    public float[] getSolucion() {
        float x;
        float y;
        int j;
        int i;
        int k;
        for(j=0; j < this.matrizCoeficientes.size(); j++) {

            //Encontramos la primera ecuacion con un coeficiente no cero

            //en la columna (ecuación) que estemos mirando (j)

            for(i=j; i < this.matrizCoeficientes.size(); i++){

                if(matrizCoeficientes.get(i).coeficiente[j] != 0D) {

                    break;

                }

                //throw new NoUniqueSolutionException(

                //Messages.getString("SistemaEcuaciones.SolucionNoUnica"));

            }

            //(+) Movemos esa ecuación a la primera fila

            for(k=0; k < this.matrizCoeficientes.size()+1; k++){

                x = matrizCoeficientes.get(j).coeficiente[k] ;

                matrizCoeficientes.get(j).coeficiente[k] = matrizCoeficientes.get(i).coeficiente[k];

                matrizCoeficientes.get(i).coeficiente[k] = x;

            }



            //(+) Obtenemos un coeficiente unidad en la primera columna no cero

            y = 1/matrizCoeficientes.get(j).coeficiente[j];

            for(k=0; k < this.matrizCoeficientes.size()+1; k++){

                matrizCoeficientes.get(j).coeficiente[k]=y*matrizCoeficientes.get(j).coeficiente[k];

            }



            for(i=0; i < this.matrizCoeficientes.size(); i++){

                y = -matrizCoeficientes.get(i).coeficiente[j];

                for(k=0; k < this.matrizCoeficientes.size()+1; k++){

                    if(i==j) break;

                    matrizCoeficientes.get(i).coeficiente[k]=matrizCoeficientes.get(i).coeficiente[k]+y*matrizCoeficientes.get(j).coeficiente[k];

                }

            }

        }

        float dRet[] = new float[this.matrizCoeficientes.size()];

        for(i=0; i < this.matrizCoeficientes.size(); i++){

            float dRes1 = (float) (matrizCoeficientes.get(i).coeficiente[this.matrizCoeficientes.size()]*1000+0.5);

            int iRes = (int)dRes1;

            float dRes2 = (float) (iRes/1000D);

            dRet[i] = dRes2;

        }
        imprimirResultado(dRet);

        return dRet;

    }

    public String imprimirResultado(float [] dRet){
        String resultado = "";
        for(int i=0; i < this.matrizCoeficientes.size(); i++){

            resultado += "x"+(i+1)+"= "+dRet[i]+"\n";

        }
        JOptionPane.showMessageDialog(null,resultado);
        return resultado;
    }

    @Override
    public String toString() {
        String salida = "";
        for (Ecuacion ec : matrizCoeficientes){
            salida += ec+"\n";
        }
        return salida;
    }

    public int suma (int a, int b){
        return a+b;
    }
}