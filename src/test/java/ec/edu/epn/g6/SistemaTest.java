package ec.edu.epn.g6;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SistemaTest {
    int tamanio;
    public Sistema s;
    @Before
    public void setUP() {
        s = new Sistema();
    }

    public Ecuacion ec;
    @Test
    public void given_two_strings_when_compare_then_ok(){

        ingresarTamanio();
        for(int i = 0; i<tamanio; i++) {
            getEcuacion();
            s.llenarMatriz(ec);

        }

        assertEquals("2.0x1 = 5.0\n",s.toString());

    }

    public void getEcuacion() {
        ec = new Ecuacion(tamanio);
    }


    @Test
    public void given_a_EquationSystem_when_resolve_then_ok(){
        float[] esperado = {0,5};
        System.out.println("Test 2");
        ingresarTamanio();
        for(int i = 0; i<tamanio; i++) {
            getEcuacion();
            s.llenarMatriz(ec);
        }
        float [] solucion = s.getSolucion();
        assertArrayEquals(esperado,solucion,1);
    }

    public void ingresarTamanio(){
        try {
            tamanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del sistema de ecuaciones"));

        }catch(NumberFormatException e) {
            ingresarTamanio();

        }}

}
