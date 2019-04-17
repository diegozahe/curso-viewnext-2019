/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplospoo;

import ejemplospoo.Geometria.*;
/**
 *
 * @author Default
 */
public class ObjetosSueltos {
    
    public static void calculosSueltos(){
        double base = 10;
        double altura = 11;
    
        Rectangulo rec = new Rectangulo(base, altura, "Rojo");
        System.out.println(rec.getColor());
    }
    
}
