package ejemplospoo;

import ejemplospoo.Geometria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LectorFiguras {

    public static void cargarFichero(String nomFich){
        Figura fig = new Rectangulo(5,5);
        
        Rectangulo rec = (Rectangulo) fig;
        System.out.println(rec.toString() + "\nArea: " + rec.calcArea());
        
        Figura fig2 = new Circulo(5, "Blanco");
        
        Rectangulo rec2 = (Rectangulo) fig2;
        System.out.println(rec2.toString() + "\nArea: " + rec2.calcArea());
    
    }
    
    
    public void coleccionesFiguras(){
        Figura[] figuras = {
            new Rectangulo(5,5),
            new Circulo(5, "Blanco"),
            new Triangulo("Triangulo: base = 5.0, altura = 2, color = azul")
        };
        
        for (Figura fig : figuras) {
            System.out.println(fig.toString());
            System.out.println(" - Area: "+fig.calcArea());
        }
        
        /**
         * Ejemplo de un arrayList sin tipo (entra cualquier cosa) 
         */
        
        /*
        ArrayList array = new ArrayList();
        array.add(new Rectangulo(4, 3, "verde"));
        array.add(new Circulo(5, "verde"));
        array.add("Texto cualquiera");
        array.add(200);
        
        for (Object obj : array){
            System.out.println(obj.toString());
        }
        */
        
        /**
         * Ejemplo de un arrayList CON tipo 
         */
        
        ArrayList<Figura> arrayList = new ArrayList<>();
        arrayList.add(new Rectangulo(4, 3, "verde"));
        arrayList.add(new Circulo(5, "verde"));
        
        for (Figura fig : arrayList){
            System.out.println(fig.toString());
            System.out.println(" - Area: " + fig.calcArea());
            
        }
        
        
        
        
        IImprimible[] objImp = {
            new Circulo(5),
            new Cuadrado(6),
            //new Triangulo(20, 5, null) //No puede añadirlo ya que no implementa IImprimible!!
        };
        
        for (IImprimible imprimible : objImp){
            imprimible.imprimir();
        }
        
        IMostrable[] objMost = {
            //new Circulo(5), //No puede añadirlo ya que no implementa IMostrable!!
            new Cuadrado(6),
            new Triangulo(20, 5, null) 
        };
        
        for (IMostrable mostrable : objMost){
            mostrable.mostrar();
        }
        
        Cuadrado cuadrado = new Cuadrado(5, "negro");
        
        // Cuadrado puede ser de todos estos tipos ya que implementa o extiende de todos estos
        Rectangulo cuadR = cuadrado;
        FiguraConLados fcl = cuadrado;
        
        Figura cuadF = cuadrado;
        cuadF.setColor("gris");
        IImprimible cuadI = cuadrado;
        cuadI.imprimir();
        
        IMostrable cuadM = cuadrado;
        cuadM.mostrar();
        
        arrayList.add(cuadrado);
        arrayList.add(cuadrado);
        
        Set<Figura> setFig = new HashSet<>();
        setFig.add(new Triangulo(3, 5, null));
        setFig.addAll(arrayList);
        
        
        
        
        System.out.println(">> ARRAY LIST: ");
        for (Figura fig : arrayList){
            System.out.println(fig.toString());
        }
        
        
        System.out.println(">> SET: ");
        for (Figura fig : setFig){
            System.out.println(fig.toString());
        }
        
        System.out.println("\nValores del mapa SIN TIPAR\n");
        Map mapa = new HashMap();
        mapa.put(1, "primer mapa");
        mapa.put("hola", "primer mapa");
        mapa.put(true, "primer mapa");
        mapa.put(2, new Cuadrado(5,"Azul"));
       
        mapa.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
        
        
        System.out.println("\nValores del mapa CON TIPADO\n");
        Map<Integer, Figura> mapa2 = new HashMap();
        mapa2.put(2, new Cuadrado(1,"Azul"));
        mapa2.put(1, new Triangulo(4,3, null, "Rojo"));        
        mapa2.put(3, new Rectangulo(5,4,"Azul"));
        mapa2.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
        
        System.out.println("\nValores del treeMap\n");
        Map<Integer, Figura> treeMap = new TreeMap();
        treeMap.put(2, new Cuadrado(1,"Azul"));
        treeMap.put(1, new Triangulo(4,3, null, "Rojo"));        
        treeMap.put(3, new Rectangulo(5,4,"Azul"));
        treeMap.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
        
        System.out.println("\nValores del treeMap INVERSO\n");
        Map<Figura, String> treeMap2;
        treeMap2 = new TreeMap();
        treeMap2.put(new Cuadrado(2,"Azul"), "Diego");
        treeMap2.put(new Cuadrado(1,"Azul"), "hola");
        treeMap2.forEach((k,v) -> System.out.println("Key -> " + k + "\nValue: " + v + "\nArea: " + k.calcArea()));
        
       
        
        
    }

}
