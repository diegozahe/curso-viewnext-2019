/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplospoo_profesor;

/**
 *
 * @author German
 */
public class LectorFiguras {
    public static void cargarFichero(String nomFich){
        Figura fig = new Rectangulo(5,5);
        
        Rectangulo rec = (Rectangulo) fig;
        Figura fig2 = new Figura("blanco");
        System.out.println(rec.toString() + "\nArea: " + rec.calcArea());
        
        Rectangulo rec2 = (Rectangulo) fig2;
        System.out.println(rec2.toString() + "\nArea: " + rec2.calcArea());
    }
    
    
    
}
