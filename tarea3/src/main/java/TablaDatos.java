
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
public class TablaDatos {
    private List<TablaDatos> tablaDatos;
    private double x; 
    private double y; 
    private double x2;
    private double xy;
    private double y2;
    //private int id;
    public TablaDatos(double  x,double y){
        this.x =x;
        this.y =y;
    }
    
    public TablaDatos(){
        super();
    }
    
    public void llenarTabla1(){
        tablaDatos = new LinkedList<TablaDatos>();
        tablaDatos.add(new TablaDatos(130,186));
        tablaDatos.add(new TablaDatos(650,699));
        tablaDatos.add(new TablaDatos(99,132));
        tablaDatos.add(new TablaDatos(150,272));
        tablaDatos.add(new TablaDatos(128,291));
        tablaDatos.add(new TablaDatos(302,331));
        tablaDatos.add(new TablaDatos(95,199));
        tablaDatos.add(new TablaDatos(945,1890));
        tablaDatos.add(new TablaDatos(368,788));
        tablaDatos.add(new TablaDatos(961,1601));
        calculadas();
    }
    
    //test2
    public void llenarTabla2(){
        tablaDatos = new LinkedList<TablaDatos>();
        tablaDatos.add(new TablaDatos(130.0,15.0));
        tablaDatos.add(new TablaDatos(650.0,69.9));
        tablaDatos.add(new TablaDatos(99.0,6.5));
        tablaDatos.add(new TablaDatos(150.0,22.4));
        tablaDatos.add(new TablaDatos(128.0,28.4));
        tablaDatos.add(new TablaDatos(302.0,65.9));
        tablaDatos.add(new TablaDatos(95.0,19.4));
        tablaDatos.add(new TablaDatos(945.0,198.7));
        tablaDatos.add(new TablaDatos(368.0,38.8));
        tablaDatos.add(new TablaDatos(961.0,138.2));
        calculadas();
        
    }
    //test3
    public void llenarTabla3(){
        tablaDatos = new LinkedList<TablaDatos>();
        tablaDatos.add(new TablaDatos(163,186));
        tablaDatos.add(new TablaDatos(765,699));
        tablaDatos.add(new TablaDatos(141,132));
        tablaDatos.add(new TablaDatos(166,272));
        tablaDatos.add(new TablaDatos(137,291));
        tablaDatos.add(new TablaDatos(355,331));
        tablaDatos.add(new TablaDatos(136,199));
        tablaDatos.add(new TablaDatos(1206,1890));
        tablaDatos.add(new TablaDatos(433,788));
        tablaDatos.add(new TablaDatos(1130,1601));
        calculadas();
        
    }
    //test4
    public void llenarTabla4(){
        tablaDatos = new LinkedList<TablaDatos>();
        tablaDatos.add(new TablaDatos(163,15.0));
        tablaDatos.add(new TablaDatos(765,69.9));
        tablaDatos.add(new TablaDatos(141,6.5));
        tablaDatos.add(new TablaDatos(166,22.4));
        tablaDatos.add(new TablaDatos(137,28.4));
        tablaDatos.add(new TablaDatos(355,65.9));
        tablaDatos.add(new TablaDatos(136,19.4));
        tablaDatos.add(new TablaDatos(1206,198.7));
        tablaDatos.add(new TablaDatos(433,38.8));
        tablaDatos.add(new TablaDatos(1130,138.2));
        calculadas();
        
    }
    private void calculadas(){
        for(int i =0;i<getTablaDatos().size();i++){
            tablaDatos.get(i).x2 = Math.pow(getTablaDatos().get(i).getX(),2);
            tablaDatos.get(i).xy = getTablaDatos().get(i).getX() * getTablaDatos().get(i).getY();
            tablaDatos.get(i).y2 = Math.pow(getTablaDatos().get(i).getY(),2);
        }
    }
    /**
     * @return the tablaDatos
     */
    public List<TablaDatos> getTablaDatos() {
        return tablaDatos;
    }
    /**
     * @return the x
     */
    public double getX() {
        return x;
    }
    /**
     * @return the y
     */
    public double getY() {
        return y;
    }
    /**
     * @return the x2
     */
    public double getX2() {
        return x2;
    }
    /**
     * @return the xy
     */
    public double getXy() {
        return xy;
    }
    /**
     * @return the y2
     */
    public double getY2() {
        return y2;
    }
    
}
