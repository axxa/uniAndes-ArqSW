

/*
 * esta clase tiene la informacion de las clases encontradas en cada programa
 * ademas de su locacion, su tamaño y numero de metodos
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asan123456
 */
public class ClassInfo {
    private String className;
    private String location;
    private int totalSize;
    private int methodCount;
    private List<String> line;

    public ClassInfo(String location){
        //this.className = className;
        this.location = location.trim();
        totalSize = 0;
        methodCount = 0;
        line = new LinkedList<String>();
        try {
            calcTotalSize();
        } catch (IOException ex) {
            Logger.getLogger(ClassInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        setClassName();
        calcMethodCount();       
    }
    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }
    /**
     * @param className the className to set
     */
    private void setClassName() {
        for (int i = location.length()-5; i>0;i-- ) {
            if(location.charAt(i) == '/'){
             this.className = location.substring(i+1, location.length());
             break;
            }
        }                
    }
    /**
     * @return the totalSize
     */
    public int getTotalSize() {
        return totalSize;
    }
    /**
     * @return the methodCount
     */
    public int getMethodCount() {
        return methodCount;
    }
    /**
     * @param methodCount the methodCount to set
     */
    public void setMethodCount(int methodCount) {
        this.methodCount = methodCount;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }  
    private void calcTotalSize() throws FileNotFoundException, IOException{
        String nombreFich = this.location;
        File fichero = new File(nombreFich);
        BufferedReader fich = new BufferedReader(new FileReader(nombreFich));
        
        String linea;
        while((linea = fich.readLine()) != null){
            if(!linea.trim().isEmpty()){
                totalSize++;
                this.line.add(linea);
            }    
        }
    }
    private void calcMethodCount(){
        int i = line.size()-1;
        do{
            if((line.get(i).contains("public") || line.get(i).contains("private")) && line.get(i).contains("{")){
                this.methodCount++;
            }
            i--;
        }while (!line.get(i).contains(" class ") || i == 0);    
    }    
}