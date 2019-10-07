/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author asan123456
 */
public class ProjectInfoTest extends TestCase {
    
    public ProjectInfoTest(String testName) {
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
     * Test of getClasss method, of class ProjectInfo.
     */
    public void testGetClasss() {
        System.out.println("getClasss");
        ProjectInfo instance = new ProjectInfo("Prg1");
        List<ClassInfo> expResult = new LinkedList<ClassInfo>();
        ClassInfo c = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        ClassInfo c2 = new ClassInfo("Java_Projects/psp0/src/main/java/edu/uniandes/ecos/ASE/app/App.java");
        expResult.add(c);
        expResult.add(c2);
        instance.setClasss(expResult);
        List<ClassInfo> result = instance.getClasss();
        assertTrue("testGetClasss:fail",expResult.get(1).getClassName().equals(result.get(1).getClassName()));
    }

    /**
     * Test of setClasss method, of class ProjectInfo.
     */
    public void testSetClasss() {
        System.out.println("setClasss");
        List<ClassInfo> classs = new LinkedList<ClassInfo>();
        ClassInfo c = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        ClassInfo c2 = new ClassInfo("Java_Projects/psp0/src/main/java/edu/uniandes/ecos/ASE/app/App.java");
        classs.add(c);
        classs.add(c2);
        ProjectInfo instance = new ProjectInfo("Prg1");
        instance.setClasss(classs);
        assertTrue("testSetClasss:fail",instance.getClasss().size() == 2);
    }

    /**
     * Test of getTotalSize method, of class ProjectInfo.
     */
    public void testGetTotalSize() {
        System.out.println("calcTotalSize");
        List<ClassInfo> classs = new LinkedList<ClassInfo>();
        ClassInfo c = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        ClassInfo c2 = new ClassInfo("Java_Projects/psp0/src/main/java/edu/uniandes/ecos/ASE/app/App.java");
        classs.add(c);
        classs.add(c2);
        ProjectInfo instance = new ProjectInfo("Prg1");
        instance.setClasss(classs);
        instance.calcTotalSize();
        
        assertTrue("testGetTotalSize:fail",instance.getTotalSize()== 67);//67
    }

    /**
     * Test of getProgramName method, of class ProjectInfo.
     */
    public void testGetProgramName() {
        System.out.println("getProgramName");
        ProjectInfo instance = new ProjectInfo("Prg1");
        String expResult = "Prg1";
        String result = instance.getProgramName();
        assertTrue("testGetProgramName:fail",expResult.equals(result));
    }

    /**
     * Test of pushClass method, of class ProjectInfo.
     */
    public void testPushClass() {
        System.out.println("pushClass");
        ClassInfo c = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        ProjectInfo instance = new ProjectInfo("Prg1");
        instance.pushClass(c);
        assertTrue("testPushClass:fail",instance.getClasss().get(0).getClassName().equals("Lab1.java"));
    }

    /**
     * Test of calcTotalSize method, of class ProjectInfo.
     */
    
    public void testCalcTotalSize() {
        System.out.println("calcTotalSize");
        List<ClassInfo> classs = new LinkedList<ClassInfo>();
        ClassInfo c = new ClassInfo("Java_Projects/lab1/src/lab1/Lab1.java");
        ClassInfo c2 = new ClassInfo("Java_Projects/psp0/src/main/java/edu/uniandes/ecos/ASE/app/App.java");
        classs.add(c);
        classs.add(c2);
        ProjectInfo instance = new ProjectInfo("Prg1");
        instance.setClasss(classs);
        instance.calcTotalSize();
        assertTrue("testCalcTotalSize:fail",instance.getTotalSize()== 67);//67
    }
    
}
