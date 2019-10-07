
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase Distribution guarda los parametros base para la funcion de simpson 
 * @author alvaro suarez
 * @version 1.0.20150225
 * @since 1.0.20150225
 */
public class Distribution {
    private double limitei;
    private double limitef;
    private double dof; 
    private double w;
    private double num_seg;
    /**
     * Constructor
     * @param limitei double
     * @param limitef double
     * @param dof double
     * @param num_seg double
     */
    public Distribution(double limitei,double limitef,double dof, double num_seg){
        this.limitei = limitei;
        this.limitef = limitef;
        this.dof = dof;
        this.num_seg = num_seg;
        
        try {
            this.w = truncDouble(limitef / num_seg);
        } catch (ParseException ex) {
            Logger.getLogger(Distribution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Constructor generico
     */
    public Distribution(){
        super();
    }
    /**
     * Trunca un double en el formato ###0.##
     * @param d double
     * @return double d
     * @throws ParseException excepcion
     */
    public double truncDouble(double d) throws ParseException{
        DecimalFormat formateador = new DecimalFormat("###0.##");        
        return formateador.parse(formateador.format(d)).doubleValue();
    }
    /**
     * @return the limitei
     */
    public double getLimitei() {
        return limitei;
    }

    /**
     * @return the limitef
     */
    public double getLimitef() {
        return limitef;
    }

    /**
     * @return the dof
     */
    public double getDof() {
        return dof;
    }

    /**
     * @return the w
     */
    public double getW() {
        return w;
    }

    /**
     * @return the num_seg
     */
    public double getNum_seg() {
        return num_seg;
    }
    
    
    
}
