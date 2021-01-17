package ec.edu.epn.g6;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SistemaTest {
    int tamanio;
    public Sistema s;
    @Before
    public void setUP() {
        s = new Sistema();
    }

    @Test
    public void given_two_strings_when_compare_then_ok(){

        float a[] = {2,5};
        Ecuacion ecu = new Ecuacion(1,a);
        s.llenarMatriz(ecu);
        assertEquals("2.0x1 = 5.0\n",s.toString());

    }

    @Test
    public void given_a_EquationSystem_when_resolve_then_ok(){
        float[] esperado = {0,5};

        float a[]={1,1,5};
        Ecuacion ecu1 = new Ecuacion(2,a);
        s.llenarMatriz(ecu1);

        float b[] = {3,2,10};
        Ecuacion ecu2 = new Ecuacion(2,b);
        s.llenarMatriz(ecu2);
        float [] solucion = s.getSolucion();
        assertArrayEquals(esperado,solucion,1);
    }

    @Test
    public void given_a_Equation_when_compareAString_ok(){
        float a[] = {2,4,1};
        Ecuacion ec = new Ecuacion(2,a);
        assertEquals("2.0x1 + 4.0x2 = 1.0",ec.toString());
    }

}
