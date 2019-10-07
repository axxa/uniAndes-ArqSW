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
public class TablaDatosTest extends TestCase {
    
    public TablaDatosTest(String testName) {
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
     * Test of llenarTabla1 method, of class TablaDatos.
     */
    public void testLlenarTabla1() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla1();
        assertTrue("testLlenarTabla1:fail",instance.getTablaDatos().get(9).getX() == 961);
    }
    /**
     * Test of llenarTabla2 method, of class TablaDatos.
     */
    public void testLlenarTabla2() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla2();
        assertTrue("testLlenarTabla2:fail",instance.getTablaDatos().get(4).getY() == 28.4);
    }
    /**
     * Test of llenarTabla3 method, of class TablaDatos.
     */
    public void testLlenarTabla3() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla3();
        assertTrue("testLlenarTabla3:fail",instance.getTablaDatos().get(1).getX() == 765);
    }
    /**
     * Test of llenarTabla4 method, of class TablaDatos.
     */
    public void testLlenarTabla4() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla4();
        int i = instance.getTablaDatos().size() - 1;
        assertTrue("testLlenarTabla4:fail",instance.getTablaDatos().get(i).getY() == 138.2);
    }
    /**
     * Test of getTablaDatos method, of class TablaDatos.
     */
    public void testGetTablaDatos() {
        TablaDatos instance = new TablaDatos();
        List<TablaDatos> expResult = instance.getTablaDatos();
        List<TablaDatos> result = instance.getTablaDatos();
        assertEquals(expResult, result);       
    }
    /**
     * Test of getX method, of class TablaDatos.
     */
    public void testGetX() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla1();
        double expResult = 130.0;
        double result = instance.getTablaDatos().get(0).getX();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getY method, of class TablaDatos.
     */
    public void testGetY() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla1();
        double expResult = 186.0;
        double result = instance.getTablaDatos().get(0).getY();
        assertEquals(expResult, result);       
    }
    /**
     * Test of getX2 method, of class TablaDatos.
     */
    public void testGetX2() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla1();
        double expResult = Math.pow(130, 2);
        double result = instance.getTablaDatos().get(0).getX2();
        assertEquals(expResult, result);       
    }
    /**
     * Test of getXy method, of class TablaDatos.
     */
    public void testGetXy() {       
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla1();
        double expResult = 130*186;
        double result = instance.getTablaDatos().get(0).getXy();
        assertEquals(expResult, result);
    }
    /**
     * Test of getY2 method, of class TablaDatos.
     */
    public void testGetY2() {
        TablaDatos instance = new TablaDatos();
        instance.llenarTabla1();
        double expResult = Math.pow(186, 2);
        double result = instance.getTablaDatos().get(0).getY2();
        assertEquals(expResult, result);
    }
}
