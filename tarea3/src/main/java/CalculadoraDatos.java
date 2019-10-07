
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
public class CalculadoraDatos {
    public static final int XK = 386;
    private double sumatoriaxi;
    private double sumatoriayi;
    private double sumatoriax2i;
    private double sumatoriaxyi;
    private double sumatoriay2i;
    private double xavg;
    private double yavg;
    private double beta0;
    private double beta1;
    private double rxy;
    private double r2;
    private double yk;
    
    public CalculadoraDatos(int mostrar){
        sumatoriaxi  =0;
        sumatoriayi  =0;
        sumatoriax2i =0;
        sumatoriaxyi =0;
        sumatoriay2i =0;
        beta0 =0;
        beta1 =0;
        rxy   =0;
        r2    =0;
        yk    =0;
        TablaDatos t= new TablaDatos();
        if(mostrar == 1){            
            t.llenarTabla1();
            calcSumatoriasyAVG(t.getTablaDatos());
            calcBetas(t.getTablaDatos().size());
            calcRs(t.getTablaDatos().size());
            calcYk();
        }
        if(mostrar == 2){       
            t.llenarTabla2();
            calcSumatoriasyAVG(t.getTablaDatos());
            calcBetas(t.getTablaDatos().size());
            calcRs(t.getTablaDatos().size());
            calcYk();
        }
        if(mostrar == 3){       
            t.llenarTabla3();
            calcSumatoriasyAVG(t.getTablaDatos());
            calcBetas(t.getTablaDatos().size());
            calcRs(t.getTablaDatos().size());
            calcYk();
        }
        if(mostrar == 4){       
            t.llenarTabla4();
            calcSumatoriasyAVG(t.getTablaDatos());
            calcBetas(t.getTablaDatos().size());
            calcRs(t.getTablaDatos().size());
            calcYk();
        }
    }
    private void calcSumatoriasyAVG(List<TablaDatos> t){
        for(int i= 0 ; i<t.size();i++){
            sumatoriaxi   += t.get(i).getX();
            sumatoriayi   += t.get(i).getY();
            sumatoriax2i  += t.get(i).getX2();
            sumatoriaxyi  += t.get(i).getXy();
            sumatoriay2i  += t.get(i).getY2();
        }
        xavg = sumatoriaxi/t.size();
        yavg = sumatoriayi/t.size();        
    }   
    private void calcBetas(int n){
        beta1= (sumatoriaxyi - n*xavg*yavg) / (sumatoriax2i - n * ( Math.pow(xavg, 2) ));
        beta0= yavg -getBeta1()*xavg;
    }   
    private void calcRs(int n){
        double denominador1 = n* sumatoriax2i - Math.pow(sumatoriaxi, 2);
        double denominador2 = n* sumatoriay2i - Math.pow(sumatoriayi, 2);
        double denominador = Math.sqrt( denominador1 * denominador2 );
        double numerador   = n * sumatoriaxyi - sumatoriaxi*sumatoriayi;
        rxy= numerador/denominador;
        r2 = Math.pow(getRxy(), 2);
    }
    private void calcYk(){
        yk =getBeta0() + getBeta1()*XK;
    }
    /**
     * @return the beta0
     */
    public double getBeta0() {
        return beta0;
    }
    /**
     * @return the beta1
     */
    public double getBeta1() {
        return beta1;
    }
    /**
     * @return the rxy
     */
    public double getRxy() {
        return rxy;
    }
    /**
     * @return the r2
     */
    public double getR2() {
        return r2;
    }
    /**
     * @return the yk
     */
    public double getYk() {
        return yk;
    }    
}
