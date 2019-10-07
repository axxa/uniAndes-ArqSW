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
public class CalculadoraDatos {
    private double stdDev;
    private double lnVS;
    private double lnS;
    private double lnM;
    private double lnL;
    private double lnVL;
    private double vS;
    private double s;
    private double m;
    private double l;
    private double vL;
    
    public CalculadoraDatos(int mostrar){
        double avg;
        ClassInfo t= new ClassInfo();        
        if(mostrar == 1)
            t.llenarTabla1();
        if(mostrar == 2)
            t.llenarTabla2();
        avg = t.getAvg();
        stdDev=stdDev(avg,t.getTablaDatos());
        lnVS= avg - 2*stdDev;
        lnS= avg - stdDev;
        lnM = avg;
        lnL = avg + stdDev;
        lnVL = avg + 2*stdDev;      
        vS =Math.exp(lnVS);
        s =Math.exp(lnS);
        m =Math.exp(lnM);
        l =Math.exp(lnL);
        vL =Math.exp(lnVL);
    }    
    public double stdDev(double average,List<ClassInfo> listaDatos){
        double result = 0;
        for(int i = 0 ; i< listaDatos.size();i++){
            result = result + listaDatos.get(i).getLnxiavg2();
        }
        result = result / (listaDatos.size()-1);
        return  Math.sqrt(result);      
    }
    /**
     * @return the stdDev
     */
    public double getStdDev() {
        return stdDev;
    }
    /**
     * @return the lnVS
     */
    public double getLnVS() {
        return lnVS;
    }
    /**
     * @return the lnS
     */
    public double getLnS() {
        return lnS;
    }
    /**
     * @return the lnM
     */
    public double getLnM() {
        return lnM;
    }
    /**
     * @return the lnL
     */
    public double getLnL() {
        return lnL;
    }
    /**
     * @return the lnVL
     */
    public double getLnVL() {
        return lnVL;
    }
    /**
     * @return the vS
     */
    public double getvS() {
        return vS;
    }
    /**
     * @return the s
     */
    public double getS() {
        return s;
    }
    /**
     * @return the m
     */
    public double getM() {
        return m;
    }
    /**
     * @return the l
     */
    public double getL() {
        return l;
    }
    /**
     * @return the vL
     */
    public double getvL() {
        return vL;
    }
}
