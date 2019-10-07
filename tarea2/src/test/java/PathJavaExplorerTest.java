/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import junit.framework.TestCase;

/**
 *
 * @author asan123456
 */
public class PathJavaExplorerTest extends TestCase {
    
    public PathJavaExplorerTest(String testName) {
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
     * Test of lsDirectory method, of class PathJavaExplorer.
     */
    public void testFullPathJavaExplorer() {      
        String name = "tarea2 v1";      
        PathJavaExplorer instance = new PathJavaExplorer();
        //System.out.println("lsDirectory:::"+ instance.getPje().getProjects().get(0).getProgramName().equals(name));
        assertTrue("testFullPathJavaExplorer:fail",name.equals( instance.getPje().getProjects().get(3).getProgramName()));
        
    }

    
    
}
