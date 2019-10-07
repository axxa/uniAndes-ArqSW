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
//-22.55	1.7279	0.9545	0.9111	644.429
public class CalculadoraDatosTest extends TestCase {
    
    public CalculadoraDatosTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getBeta0 method, of class CalculadoraDatos.
     */
    public void testGetBeta0() {
        CalculadoraDatos instance = new CalculadoraDatos(1);
        double expResult = -22.55;
        double incertidumbre= 0.01;
        double result = instance.getBeta0();
        assertTrue("testGetBeta0:fail", result + incertidumbre > expResult && result - incertidumbre < expResult);
    }
    /**
     * Test of getBeta1 method, of class CalculadoraDatos.
     */
    public void testGetBeta1() {
        CalculadoraDatos instance = new CalculadoraDatos(1);
        double expResult = 1.7279;
        double incertidumbre= 0.01;
        double result = instance.getBeta1();
        //System.out.println("asd: "+instance.getBeta1());
        assertTrue("testGetBeta1:fail", result + incertidumbre > expResult && result - incertidumbre < expResult);
    }
    /**
     * Test of getRxy method, of class CalculadoraDatos.
     */   	
    public void testGetRxy() {
        CalculadoraDatos instance = new CalculadoraDatos(1);
        double expResult = 0.9545;
        double incertidumbre= 0.01;
        double result = instance.getRxy();
        assertTrue("testGetRxy:fail", result + incertidumbre > expResult && result - incertidumbre < expResult);
    }

    /**
     * Test of getR2 method, of class CalculadoraDatos.
     */
    public void testGetR2() {
        CalculadoraDatos instance = new CalculadoraDatos(1);
        double expResult = 0.9111;
        double incertidumbre= 0.01;
        double result = instance.getR2();
        assertTrue("testGetR2:fail", result + incertidumbre > expResult && result - incertidumbre < expResult);        
    }

    /**
     * Test of getYk method, of class CalculadoraDatos.
     */
    public void testGetYk() {
        CalculadoraDatos instance = new CalculadoraDatos(1);
        double expResult = 644.429;
        double incertidumbre= 0.01;
        double result = instance.getYk();
        assertTrue("testGetYk:fail", result + incertidumbre > expResult && result - incertidumbre < expResult);
    }
    
}
