package ejemplospoo;

import ejemplospoo.Geometria.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //LectorFiguras.cargarFichero("");
        //LectorFiguras lf = new LectorFiguras();
        //lf.coleccionesFiguras();
        //ejemplospoo_profesor.LectorFiguras.cargarFichero("");

        //DesdeFicheros.guardarRectangulos();
        //ObjetosSueltos.calculosSueltos();
        /*String[] texto = DesdeFicheros.leerRectangulo();

        for (int j = 0; j < 10000000; j++) {
            crearFigura(texto);
        }*/
        
        crearFiguraOptima();

        long finish2Time = System.currentTimeMillis();

        System.out.println(finish2Time - startTime);

    }

    public static void crearFigura(String[] texto) {

        //String[] texto = DesdeFicheros.leerRectangulo();
        String[] valoresClave = {"base", "altura", "color", "radio"};
        String[] valor;

        String color = "";
        double base = 0;
        double altura = 0;
        double radio = 0;

        String value, value0;

        int posIgual;

        for (String linea : texto) {
            if (linea == null) {
                break;
            }

            String figura = linea.substring(0, linea.indexOf(":")).toLowerCase();
            linea = linea.substring(linea.indexOf(":"), linea.length());
            switch (figura) {
                case "rectangulo":
                    color = "";
                    base = 0;
                    altura = 0;

                    valor = linea.split(",");
                    for (String val : valor) {
                        posIgual = val.indexOf("=");
                        value = val.substring(posIgual + 2, val.length());

                        for (String clave : valoresClave) {
                            if (val.contains(clave)) {
                                switch (clave) {
                                    case "base":
                                        base = Double.parseDouble(value);
                                        break;
                                    case "altura":
                                        altura = Double.parseDouble(value);
                                        break;
                                    case "color":
                                        color = value;
                                        break;
                                }
                                break;
                            }
                        }
                    }
                    Rectangulo rec = new Rectangulo(base, altura, color);
                    //System.out.println("El rectangulo tiene un area de " + rec.calcArea());

                    break;
                case "circulo":
                    color = "";
                    radio = 0;

                    valor = linea.split(",");
                    for (String val : valor) {

                        posIgual = val.indexOf("=");
                        value = val.substring(posIgual + 2, val.length());

                        for (String clave : valoresClave) {
                            if (val.contains(clave)) {
                                switch (clave) {
                                    case "radio":
                                        radio = Double.parseDouble(value);
                                        break;
                                    case "color":
                                        color = value;
                                        break;
                                }
                                break;
                            }
                        }
                    }
                    Circulo cir = new Circulo(radio, color);
                    //System.out.println("El circulo tiene un area de " + cir.calcArea());
                    break;
                case "triangulo":
                    color = "";
                    base = 0;
                    altura = 0;
                    valor = linea.split(",");
                    for (String val : valor) {
                        posIgual = val.indexOf("=");
                        //value0 = val.substring(0, posIgual).replaceAll(" ", ""); // cogemos la primera parte que es 
                        value0 = val.substring(0, posIgual).trim();
                        value = val.substring(posIgual + 2, val.length());

                        switch (value0) {
                            case "base":
                                base = Double.parseDouble(value);
                                break;
                            case "altura":
                                altura = Double.parseDouble(value);
                                break;
                            case "color":
                                color = value;
                                break;
                        }

                    }
                    Triangulo tri = new Triangulo(base, altura, null, color);
                    //System.out.println("El triangulo tiene un area de " + tri.calcArea());
                    break;
            }
        }
    }

    public static void crearFiguraOptima() {
        String[] texto = DesdeFicheros.leerRectangulo();
        Map<Integer, Figura> treeMap = new TreeMap();
        
        String color, valor, nombre;
        double base, altura, radio;
        int i = 0;
        for (String linea : texto) {
            if (linea == null || linea.isEmpty()) {
                break;
            }
            String figura = linea.split(":")[0].toLowerCase();
            String[] claveValor = linea.split(":")[1].toLowerCase().split(",");

            color = "";
            base = altura = radio = 0;

            for (String val : claveValor) {
                nombre = val.split("=")[0].trim();
                valor = val.split("=")[1].trim();
                switch (nombre) {
                    case "base":
                        base = Double.parseDouble(valor);
                        break;
                    case "altura":
                        altura = Double.parseDouble(valor);
                        break;
                    case "color":
                        color = valor;
                        break;
                    case "radio":
                        radio = Double.parseDouble(valor);
                        break;
                }
            }
            switch (figura) {
                case "rectangulo":
                    treeMap.put(i, new Rectangulo(base, altura, color));
                    //System.out.println(rec.calcArea());
                    break;
                case "circulo":
                    treeMap.put(i, new Circulo(radio, color));
                    //System.out.println(cir.calcArea());
                    break;
                case "triangulo":
                    treeMap.put(i, new Triangulo(base, altura, null, color));
                    //System.out.println(tri.calcArea());
                    break;
            }
            i++;
        }
        treeMap.forEach((k,v) -> System.out.println("Key -> " + k + "\nValue: " + v));
        
    }
}
