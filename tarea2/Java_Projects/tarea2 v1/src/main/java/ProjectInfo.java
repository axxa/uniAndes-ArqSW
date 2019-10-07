

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author asan123456
 */
public class ProjectInfo {
    private String programName;
    private List<ClassInfo> classs;
    private int totalSize;
    
    public ProjectInfo(String programName){
        this.programName = programName;
        this.classs = new LinkedList<ClassInfo>();
        this.totalSize = 0;
    }

    /**
     * @return the classs
     */
    public List<ClassInfo> getClasss() {
        return classs;
    }

    /**
     * @param classs the classs to set
     */
    public void setClasss(List<ClassInfo> classs) {
        this.classs = classs;
    }

    /**
     * @return the totalSize
     */
    public int getTotalSize() {
        return totalSize;
    }

    /**
     * @return the programName
     */
    public String getProgramName() {
        return programName;
    }
    
    public void pushClass(ClassInfo c){
       classs.add(c);
    }
    
    public void calcTotalSize(){
        for (int i =0;i<classs.size();i++){
            this.totalSize = this.totalSize+classs.get(i).getTotalSize();
        }
    }
}
