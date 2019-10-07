/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;

/**
 * Clase TablaDatosTest JUnit 
 * @author alvaro suarez
 * @version 1.0.20150225
 * @since 1.0.20150225
 */
public class TablaDatosTest extends TestCase {
    
    public TablaDatosTest(String testName) {
        super(testName);
    }
    /**
     * Test of truncDouble method, of class TablaDatos.
     */
    public void testTruncDouble() throws Exception {
        System.out.println("truncDouble");
        double d = 1.123456789;
        TablaDatos instance = new TablaDatos(0,0.55338,6,10);
        double expResult = 1.12346;
        double result = instance.truncDouble(d);
        System.out.println(result);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of la_gamma method, of class TablaDatos.
     */
    public void testLa_gamma() {
        System.out.println("la_gamma");
        double x = 4.5;
        TablaDatos instance = new TablaDatos(0,0.55338,6,10);
        double expResult = 11.631728396567446;
        double result = instance.la_gamma(x);
        
        assertEquals(expResult, result);       
    }
    /**
     * Test de calculo de TablaDatos.
     */
    public void escenarioCalculo() {
        System.out.println("escenarioCalculo");
        double incertidumbre = 0.01;
        TablaDatos instance = new TablaDatos(0,0.55338,6,10);
        double expResult = 0.35006;
        double result = instance.getP();
        assertTrue("fail",result>expResult && result<expResult+incertidumbre);
    }
    
}
