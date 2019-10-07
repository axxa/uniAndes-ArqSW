/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author asan123456
 */
public class CalculadoraDatosTest extends TestCase { 
    /**
     * Test of stdDev method, of class CalculadoraDatos.
     */
    public void testStdDev() {
        CalculadoraDatos instance = new CalculadoraDatos(1);
        double average = 2.8015;
        double incertidumbre = 0.001;
        ClassInfo t= new ClassInfo();
        t.llenarTabla1();
        List<ClassInfo> listaDatos = t.getTablaDatos();
        double expResult = instance.getStdDev();
        double result = instance.stdDev(average, listaDatos);
        System.out.println("expResult: "+expResult);
        System.out.println("result: "+result);
        assertTrue("testStdDev:fail",expResult == result);       
    } 
}
