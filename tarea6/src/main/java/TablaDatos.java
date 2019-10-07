
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase TablaDatos tiene los datos de prueba y los calcula
 * @author alvaro suarez
 * @version 1.0.20150225
 * @since 1.0.20150225
 */
public class TablaDatos {
    /*
    public static double ACCEPTABLEERROR = 0.00001;
    public static double NUM_SEG = 10;
    public static double LIMITEI = 0;*/
    private List<TablaDatos> tablaDatos;
    private Distribution d;
    int i;
    private double xi;
    private double fX;
    private int multiplier;
    private double terms;
    private double p;
    
    /**
     * 
     * @param limitei double
     * @param limitef double
     * @param dof double
     * @param num_seg double
     */
    public TablaDatos(double limitei,double limitef,double dof, double num_seg){
         p = 0;
        llenarTabladatos1(limitei,limitef,dof,num_seg);
    }
    /**
     * Constructor de fila para TablaDatos
     * @param i int
     * @param xi double
     * @param multiplier int 
     */
    private TablaDatos(int i,double xi,int multiplier){
        this.i = i;
        this.xi = xi;
        this.multiplier = multiplier;
    }
    /**
     * Llena la tabla con los datos a buscar
     * @param limitei double
     * @param limitef double
     * @param dof double
     * @param num_seg double
     */
    private void llenarTabladatos1(double limitei,double limitef,double dof, double num_seg){
        this.d = new Distribution(limitei,limitef,dof,num_seg);
        this.tablaDatos = new LinkedList<TablaDatos>();
        
        double aux = getD().getLimitei();
        int mult;
        double w = getD().getW();
        getTablaDatos().add(new TablaDatos(0,aux,1));
        for(int j = 1 ; j < getD().getNum_seg() + 1 ;j++ ){
            aux  = aux + w;
            mult = esPar(j);//multiplier(aux);
            if(j == getD().getNum_seg())
                mult = 1;
            
            getTablaDatos().add(new TablaDatos(j,aux,mult));           
        }
        calculadas();
    }
    /**
     * Calcula la integral
     */
    private void calculadas(){
        double exp = (getD().getDof() + 1)/2;
        double rightside;
        double numeradorrightside;
        double denominadorrightside;
        double leftside;
        for(int i = 0; i<getTablaDatos().size();i++){
            try {
                fX = 1 + Math.pow(getTablaDatos().get(i).xi, 2)/getD().getDof();               
                fX = truncDouble(Math.pow(getfX(), -exp));
                numeradorrightside =la_gamma(exp);
                denominadorrightside = Math.pow(getD().getDof()* Math.PI, 0.5)*la_gamma(getD().getDof()/2);
                rightside = numeradorrightside/denominadorrightside;
                fX = rightside * getfX();
                terms = (getD().getW()/3) * getTablaDatos().get(i).multiplier * getfX();
                fX = truncDouble(getfX());
                terms = truncDouble(getTerms());
                p = p + terms;
                //System.out.println("\n fx: " + fX);
                //System.out.println("\n terms: " + terms);
            } catch (ParseException ex) {
                Logger.getLogger(TablaDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Retorna 2 si es par en caso contrario retorn 4
     * @param n int
     * @return int
     */
    private int esPar(int n){
        if(n % 2 == 0)
            return 2;
        else
            return 4;
    }
    /**
     * Trunca un double en el formato ###0.#####
     * @param d double
     * @return double d
     * @throws ParseException 
     */
    public double truncDouble(double d) throws ParseException{
        DecimalFormat formateador = new DecimalFormat("###0.#####");        
        return formateador.parse(formateador.format(d)).doubleValue();
    }
    
    /**
     * factorial de un entero
     * @param d double
     * @return double
     */
    
    private double factorial(double d){
        if (d <= 1)
                return 1;
            else
                return d * factorial(d - 1);
    }
    /**
     * factorial de un fraccionario o entero
     * @param x double
     * @return double
     */
    public double la_gamma(double x){
	if(x % 1 == 0){            
            return factorial(x-1);
        }
        else{
                double[] p = {0.99999999999980993, 676.5203681218851, -1259.1392167224028,
			     	  771.32342877765313, -176.61502916214059, 12.507343278686905,
			     	  -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7};
		int g = 7;
		if(x < 0.5) return Math.PI / (Math.sin(Math.PI * x)*la_gamma(1-x));
 
		x -= 1;
		double a = p[0];
		double t = x+g+0.5;
		for(int i = 1; i < p.length; i++){
			a += p[i]/(x+i);
		}
 
		return Math.sqrt(2*Math.PI)*Math.pow(t, x+0.5)*Math.exp(-t)*a;
        }
    }
    public double getfX() {
        return fX;
    }
    public double getTerms() {
        return terms;
    }
    public double getP() {
        return p;
    }
    public List<TablaDatos> getTablaDatos() {
        return tablaDatos;
    }
    public Distribution getD() {
        return d;
    }    
}
