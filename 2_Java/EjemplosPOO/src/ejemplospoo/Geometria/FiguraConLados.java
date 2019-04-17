package ejemplospoo.Geometria;

import ejemplospoo.*;

public class FiguraConLados extends Figura{
    protected double base;
    protected double altura;
    
    public FiguraConLados(String textoDeserializar) {
        super("");
        String[] partesCampos = textoDeserializar.split(":")[1].split(",");
        for (String parteCampo : partesCampos) {
            int posIgual = parteCampo.indexOf("=");
            String campo = parteCampo.substring(0, posIgual).trim().toLowerCase();
            String valor = parteCampo.substring(posIgual + 1).trim();
            switch (campo) {
                case "base":
                    this.base = Float.parseFloat(valor);
                    break;
                case "altura":
                    this.altura = Float.parseFloat(valor);
                    break;
                case "color":
                    this.color = valor; // CAMBIAR color a PROTECTED
                    break;
            }
        }
    }
    
    public FiguraConLados(double base, double altura, String color){
        super(color);
        this.base = base;
        this.altura = altura;
    }
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
   
    
    @Override
    public String toString(){
        return "FiguraConLados: base = " + this.getBase() 
                + ", altura = " + this.getAltura() 
                + ", color = " + this.getColor();
    }

    @Override
    public double calcArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public double calcPerimetro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
