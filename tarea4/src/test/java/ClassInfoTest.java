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
public class ClassInfoTest extends TestCase {
    /**
     * Test of llenarTabla1 method, of class ClassInfo.
     */
    public void testLlenarTabla1() {
        ClassInfo instance = new ClassInfo();
        instance.llenarTabla1();
        assertTrue("testLlenarTabla1:fail",instance.getTablaDatos().get(0).getLOCMehtod() == 6);
    }

    /**
     * Test of llenarTabla2 method, of class ClassInfo.
     */
    public void testLlenarTabla2() {
        ClassInfo instance = new ClassInfo();
        instance.llenarTabla2();
        assertTrue("testLlenarTabla2:fail",instance.getTablaDatos().get(0).getLOCMehtod() == 7);
    }  
}
