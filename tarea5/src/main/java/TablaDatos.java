
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
 * @since 
 */
public class TablaDatos {
    private List<TablaDatos> tablaDatos;
    private Distribution d;
    private int    i;
    private double xi;
    private double fX;
    private int multiplier;
    private double terms;
    private double p;
    
    /**
     * Constructor TablaDatos casos
     * @param mostrar int
     */
    public TablaDatos(int mostrar){
        p = 0;
        if(mostrar == 1)
            d = new Distribution(0,1.1,9,10);
        if(mostrar == 2)
            d = new Distribution(0,1.1812,10,10);
        if(mostrar == 3)
            d = new Distribution(0,2.750,30,10);
        llenarTabladatos1();
        
        
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
     * Constructor generico de TablaDatos
     */
    public TablaDatos(){
        super();
    }
    /**
     * Llenar la tabla de datos
     */
    private void llenarTabladatos1(){
        tablaDatos = new LinkedList<TablaDatos>();
        double aux = d.getLimitei();
        int mult;
        double w = d.getW();
        tablaDatos.add(new TablaDatos(0,aux,1));
        for(int j = 1 ; j < d.getNum_seg() + 1 ;j++ ){
            aux  = aux + w;
            mult = esPar(j);//multiplier(aux);
            if(j == d.getNum_seg())
                mult = 1;
            
            tablaDatos.add(new TablaDatos(j,aux,mult));           
        }
        calculadas();
    }
    /**
     * Calcula la funcion de simpson
     */
    private void calculadas(){
        double exp = (d.getDof() + 1)/2;
        double rightside;
        double numeradorrightside;
        double denominadorrightside;
        double leftside;
        for(int i = 0; i<tablaDatos.size();i++){
            try {
                fX = 1 + Math.pow(tablaDatos.get(i).xi, 2)/d.getDof();               
                fX = truncDouble(Math.pow(getfX(), -exp));
                numeradorrightside =la_gamma(exp);
                denominadorrightside = Math.pow(d.getDof()* Math.PI, 0.5)*la_gamma(d.getDof()/2);
                rightside = numeradorrightside/denominadorrightside;
                fX = rightside * getfX();
                terms = (d.getW()/3) * tablaDatos.get(i).multiplier * getfX();
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
     * 
     * @param numero double
     * @return int
     */
    private int multiplier(double numero){
        String s;
        int cont=0;
        do{
            numero *= 10;
            cont++;
        }while(cont<=cuantosDecimales(numero));
        if(numero % 2 == 0)
            return 2;
        else
            return 4;    
    }   
    /**
     * Retorna el numero de decimales de un numero
     * @param d double
     * @return int
     */
    public int cuantosDecimales(double d){        
        String doble =String.valueOf(d); 
        double num = Double.parseDouble(doble);//únicamente lo uso para arrojar la excepción 

        boolean bandera= false;//para saber si se van a contar decimales 
        int decimales=0;//contador de decimales; 
        for (int i=0; i<doble.length();i++){ 
            if(bandera)
                decimales++; 
            if(doble.charAt(i)=='.'){
                bandera=true;
            }
        }
    return decimales;
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
    /**
     * @return fX
     */
    public double getfX() {
        return fX;
    }
    /**
     * @return terms
     */
    public double getTerms() {
        return terms;
    }
    /**
     * @return p
     */
    public double getP() {
        return p;
    }
    
}
