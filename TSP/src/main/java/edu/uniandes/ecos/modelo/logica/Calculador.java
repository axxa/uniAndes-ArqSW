/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo.logica;

/**
 * Clase encargada de llevar a cabo las operaciones necesarias para
 * los anàlisis de complejidad y databinding de un programa.
 * @author Umbrella.
 */
public class Calculador {
    
    /**
     * Calcula la complejidad ciclomatica de McCabe.
     * @param arcos Numero de conectores entre sentencias del programa.
     * @param nodos Número de sentencias.
     * @return Valor entero correspondiente a la complejidad McCabe.
     */
    public static int calcularMcCabe(Integer arcos, Integer nodos){
        return arcos - nodos + 2;
    }
}
