package edu.uniandes.ecos.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Caso 1 o 2: ");
        Cal c = new Cal(br.readLine());
        
        System.out.print("Mean: " + c.meanCalc());
        System.out.print("\nStd Dev: " + c.stdDev() + "\n");
    }
}
