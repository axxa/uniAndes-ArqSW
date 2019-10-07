
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asan123456
 */
public class ClassInfo {
    private List<ClassInfo> tablaDatos;
    private String className;
    private double LOCMehtod;
    private double avg;
    private double lnxi; 
    private double lnxiavg2;
    //private int id;
    public ClassInfo(String className, double  LOCMethod){
        this.avg = 0;
        this.className =className;
        this.LOCMehtod =LOCMethod;
    }
    
    public ClassInfo(){
        super();
    }
    
    public void llenarTabla1(){
        tablaDatos = new LinkedList<ClassInfo>();
        tablaDatos.add(new ClassInfo("each_char",6));
        tablaDatos.add(new ClassInfo("string_read",6));
        tablaDatos.add(new ClassInfo("single_character",8.3333));
        tablaDatos.add(new ClassInfo("each_line",10.3333));
        tablaDatos.add(new ClassInfo("single_char",12.3333));
        tablaDatos.add(new ClassInfo("string_builder",16.4000));
        tablaDatos.add(new ClassInfo("string_manager",20.5000));
        tablaDatos.add(new ClassInfo("ist_clump",21.7500));
        tablaDatos.add(new ClassInfo("ist_clip",22.2500));
        
        tablaDatos.add(new ClassInfo("string_decrementer",23.0000));
        tablaDatos.add(new ClassInfo("Char",28.3333));
        tablaDatos.add(new ClassInfo("Character",29.0000));
        tablaDatos.add(new ClassInfo("Converter",55.8000));
        calculadas();
    }
    public void llenarTabla2(){
        tablaDatos = new LinkedList<ClassInfo>();
        tablaDatos.add(new ClassInfo("Preface",7));
        tablaDatos.add(new ClassInfo("Chapter 1",12));
        tablaDatos.add(new ClassInfo("Chapter 2",10));
        tablaDatos.add(new ClassInfo("Chapter 3",12));
        tablaDatos.add(new ClassInfo("Chapter 4",10));
        tablaDatos.add(new ClassInfo("Chapter 5",12));
        tablaDatos.add(new ClassInfo("Chapter 6",12));
        tablaDatos.add(new ClassInfo("Chapter 7",12));
        tablaDatos.add(new ClassInfo("Chapter 8",12));
        
        tablaDatos.add(new ClassInfo("Chapter 9",8));
        tablaDatos.add(new ClassInfo("Appendix A",8));
        tablaDatos.add(new ClassInfo("Appendix B",8));
        tablaDatos.add(new ClassInfo("Appendix C",20));
        tablaDatos.add(new ClassInfo("Appendix D",14));
        tablaDatos.add(new ClassInfo("Appendix E",18));
        tablaDatos.add(new ClassInfo("Appendix F",12));
        calculadas();
    }
    private void calculadas(){
        int size = tablaDatos.size();
        for(int i =0;i<size;i++){  
            tablaDatos.get(i).lnxi     = Math.log(tablaDatos.get(i).LOCMehtod);
            this.avg = this.getAvg() + tablaDatos.get(i).lnxi;
        }
        this.avg = this.getAvg() / size;
        for(int i =0;i<size;i++){            
            tablaDatos.get(i).lnxiavg2 = Math.pow(tablaDatos.get(i).lnxi - this.getAvg(),2);
        }
    }
    /**
     * @return the tablaDatos
     */
    public List<ClassInfo> getTablaDatos() {
        return tablaDatos;
    }
    /**
     * @return the LOCMehtod
     */
    public double getLOCMehtod() {
        return LOCMehtod;
    }
    /**
     * @return the lnxi
     */
    public double getLnxi() {
        return lnxi;
    }
    /**
     * @return the lnxiavg2
     */
    public double getLnxiavg2() {
        return lnxiavg2;
    }   

    /**
     * @return the avg
     */
    public double getAvg() {
        return avg;
    }
}
