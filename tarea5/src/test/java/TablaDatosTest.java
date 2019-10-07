/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;

/**
 *
 * @author asan123456
 */
public class TablaDatosTest extends TestCase {
    
    public TablaDatosTest(String testName) {
        super(testName);
    }
    /**
     * Test of cuantosDecimales method, of class TablaDatos.
     */
    public void testCuantosDecimales() {
        System.out.println("cuantosDecimales");
        double d = 1.12345;
        TablaDatos instance = new TablaDatos();
        int expResult = 5;
        int result = instance.cuantosDecimales(d);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of truncDouble method, of class TablaDatos.
     */
    public void testTruncDouble() throws Exception {
        System.out.println("truncDouble");
        double d = 1.123456789;
        TablaDatos instance = new TablaDatos();
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
        TablaDatos instance = new TablaDatos();
        double expResult = 11.631728396567446;
        double result = instance.la_gamma(x);
        
        assertEquals(expResult, result);       
    }
    
}
