/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplospoo.Geometria;

import ejemplospoo.*;


public class Main {
    
    public static void main (String [] args){
        double base = 10;
        double altura = 11;
        
        double[] lados = {1,2,3};
        
        double radio = 2.5;
        
        
        
        Rectangulo rec = new Rectangulo(base, altura, "Rojo");
        System.out.println(rec.calcArea());
        System.out.println(rec.calcPerimetro());
        
        Circulo cir = new Circulo(radio, "Azul");
        System.out.println(cir.calcArea() + " " + cir.getColor());
        
        Triangulo tri = new Triangulo(base, altura, lados, "rojo");
        System.out.println(tri.calcArea());
        
        
    }
    
    
    
    
}
