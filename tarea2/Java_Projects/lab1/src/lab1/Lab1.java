/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import edu.uniandes.ecos.ASE.app.Cal;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author asan123456
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("Enter String: ");
        //String s = br.readLine();
        boolean b= true;
        System.out.print("Enter Integer: ");
        //try{
            do{
                  String s = br.readLine();
                  if(isNumeric(s)){
                      int i = Integer.parseInt(br.readLine());
                  }
                  else{
                   b = false;
                  }
            }while(b);
                System.out.print("Aca salio");    
        //}catch(NumberFormatException nfe){
          //  System.err.println("Invalid Format!");
        //}
        
    }*/
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Caso 1 o 2: ");
        Cal c = new Cal(br.readLine());
        
        System.out.print("Mean: " + c.meanCalc());
        System.out.print("\nStd Dev: " + c.stdDev() + "\n");
    }
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
}
