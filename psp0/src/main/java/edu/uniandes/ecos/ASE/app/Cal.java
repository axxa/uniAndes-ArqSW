/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author asan123456
 */
public class Cal {
    
    List<Double> list;
    
    public Cal(String opt){
        list = new LinkedList<Double>();
        if(opt.equals("1"))
            llenarLista();
        else 
            llenarLista2();    
    }
    
    private void llenarLista(){
        list.add(160.0);
        list.add(591.0);
        list.add(114.0);
        list.add(229.0);
        list.add(230.0);
        list.add(270.0);
        list.add(128.0);
        list.add(1657.0);
        list.add(624.0);
        list.add(1503.0);
    }
    private void llenarLista2(){
        list.add(15.0);
        list.add(69.9);
        list.add(6.5);
        list.add(22.4);
        list.add(28.4);
        list.add(65.9);
        list.add(19.4);
        list.add(198.7);
        list.add(38.8);
        list.add(138.2);
       

    }
    public double meanCalc(){
        double sum = 0;
        for (int i =0 ; i< list.size();i++){
            //System.out.print("\nsumatoria: "+sum +"+"+ list.get(i)+"\n");
            sum += list.get(i);
            //System.out.print("\nvan: "+sum +"\n");
        }
        //System.out.print("\nsumatoria: "+sum +"\n");
        return sum/list.size();
    }
    
    public double stdDev(){
        double average = meanCalc();
        List<Double> listOfDifferences = new ArrayList<Double>();
        for (double number: list){
            double difference = number - average;
            listOfDifferences.add(difference);
        }
        List<Double> squares = new ArrayList<Double>();
        for (double difference: listOfDifferences){
            double square= difference*difference;
            squares.add(square);
            
        }
        double sum = 0;
        for (double number: squares){
            sum = sum+number;
        }
        double result= sum / (list.size()-1);
        return  Math.sqrt(result);
       
    }
}