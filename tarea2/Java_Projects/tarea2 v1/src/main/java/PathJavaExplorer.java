

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author asan123456
 */
public class PathJavaExplorer {
    private PrettyPrintingLOC pje;
    
    public PathJavaExplorer(){
        String sDirectorio = "Java_Projects";
        File f = new File(sDirectorio);
        
        if (f.exists()){ // Directorio existe 
            //System.out.println("Directorio existe");
            
            File[] ficheros = f.listFiles();
            
            pje = new PrettyPrintingLOC();
            int cont =0;
            
            for (int x=1;x<ficheros.length;x++){
                    crearProyectos(ficheros[x].getName());
                    lsDirectory(cont,"Java_Projects/" + ficheros[x].getName(),ficheros[x]);
                    cont++;                  
            }
            pje.getProjectSize();
            pje.prettyPrinting();
                   
        }
        
        else { 
        //Directorio no existe 
            pje.setPrinting("Directorio no existe");
        }
        
    }
    
    private void crearProyectos(String name){
        ProjectInfo p = new ProjectInfo(name);
        getPje().getProjects().add(p);    
    }
    private List<String> obtenerRutasProyecto(){
        List<String> l = new LinkedList<String>();
        return l;
    }
    
    public void lsDirectory ( int index,String padre,File dir ) {
        
        File[] archivos = dir.listFiles();
        int j=0;
        //if(archivos !=null)
        for ( int i=0 ; i<archivos.length;i++) 
        {   
            String ruta= padre+"/"+archivos[i].getName();
            if(ruta.contains(".java"))
                getPje().getProjects().get(index).pushClass(new ClassInfo(ruta));
            if ( archivos[i].isDirectory() ) {
                lsDirectory( index,padre+"/"+archivos[i].getName(),archivos[i] );
            }
        }       
    }

    /**
     * @return the pje
     */
    public PrettyPrintingLOC getPje() {
        return pje;
    }
}
