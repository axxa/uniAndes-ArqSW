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
public class ClassInfoTest extends TestCase {
    
    //private ClassInfo instance;
    
    public ClassInfoTest(String testName) {
        
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
     * Test of getClassName method, of class ClassInfo.
     */
    public void testGetClassName() {
        System.out.println("getClassName");
        ClassInfo instance = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        String expResult = "Lab1.java";
        String result = instance.getClassName();
        assertTrue("testGetClassName:fail",expResult.equals(result));
    }

    /**
     * Test of getTotalSize method, of class ClassInfo.
     */
    public void testGetTotalSize() {
        System.out.println("getTotalSize");
        ClassInfo instance = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        int expResult = 53;
        int result = instance.getTotalSize();
        assertTrue("testGetTotalSize:fail",expResult== (result));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMethodCount method, of class ClassInfo.
     */
    public void testGetMethodCount() {
        System.out.println("getMethodCount");
        ClassInfo instance = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        int expResult = 2;
        int result = instance.getMethodCount();
        assertTrue("testGetMethodCount:fail",expResult== (result));
    }

    /**
     * Test of getLocation method, of class ClassInfo.
     */
    public void testGetLocation() {
        System.out.println("getLocation");
        ClassInfo instance = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        String expResult = "Java_Projects/lab1/src/lab1/Lab1.java";
        String result = instance.getLocation();
        assertTrue("testGetLocation:fail",expResult.equals(result));
    }
    
}
