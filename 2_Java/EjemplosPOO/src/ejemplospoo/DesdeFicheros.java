package ejemplospoo;

import java.io.*;
import ejemplospoo.Geometria.*;

public class DesdeFicheros {
    
    
    public static void guardarRectangulos(){
        Rectangulo rec  = new Rectangulo(10, 5);
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try {
            fichero = new FileWriter("C:/Diego/Curso web/rectangulo.txt");
            pw = new PrintWriter(fichero);
            pw.print("Rectangulo: base = " + rec.getBase() + ", altura = " + rec.getAltura() + ", color = " + rec.getColor());
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                if(fichero != null){
                fichero.close();   
                }
            } catch(IOException e2){
                e2.printStackTrace();
            }
        }
    }
    
    public static String[] leerRectangulo(){
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] texto = new String[50];
        try {
            fichero = new File("C:/Diego/Curso web/rectangulo.txt");
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                texto[i]=linea;
                i++;
            }
            /*
            linea = br.readLine();
            if(linea != null){
                texto += linea;
                //System.out.println(linea);
            }*/
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                if(fr != null){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return texto;
    }
    
}

















