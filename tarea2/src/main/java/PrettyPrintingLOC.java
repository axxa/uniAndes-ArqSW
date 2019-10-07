/*
 * Clase encargada de imprimir la data solicitada en el requerimiento de
 * forma legible
 */
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author asan123456
 */
public class PrettyPrintingLOC {
    private List<ProjectInfo> projects;
    private List<String> printing; 
    public PrettyPrintingLOC(){
        projects = new LinkedList<ProjectInfo>();
        printing = new LinkedList<String>();
    }
    /**
     * @return the projects
     */
    public List<ProjectInfo> getProjects() {
        return projects;
    }
    /**
     * @param projects the projects to set
     */
    public void setProjects(List<ProjectInfo> projects) {
        this.projects = projects;
    }
    public int getIndexProjectbyName(String name){
        int indx= -1;
     for(int i = 0 ; i< projects.size();i++){
         if(projects.get(i).getProgramName().equals(name)){
            indx = i; 
         }
         
     }  
     return indx;
    }
    public void getProjectSize(){
        for(int i = 0; i < projects.size() ;i++ ){
                projects.get(i).calcTotalSize();
            }
    }
    public void prettyPrinting(){
        for(int i = 0 ; i< projects.size();i++){
                getPrinting().add("-----------------------------------------------");
                getPrinting().add("PROGRAM NAME:  " + projects.get(i).getProgramName());
                getPrinting().add("Total size: " + projects.get(i).getTotalSize());
                for(int j = 0 ; j< projects.get(i).getClasss().size();j++){
                    getPrinting().add("    Class name:  " + projects.get(i).getClasss().get(j).getClassName());
                    getPrinting().add("    Method count:  " + projects.get(i).getClasss().get(j).getMethodCount() );
                    getPrinting().add("    Location:  " + projects.get(i).getClasss().get(j).getLocation());
                    getPrinting().add("    Size:  " + projects.get(i).getClasss().get(j).getTotalSize());
                    getPrinting().add("    -----------------------------------------------");
                }
            }
    }
    /**
     * @return the printing
     */
    public List<String> getPrinting() {
        return printing;
    }
    /**
     * @param printing the printing to set
     */
    public void setPrinting(String msj) {
        this.printing.add(msj);
    }  
}