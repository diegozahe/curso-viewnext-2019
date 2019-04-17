package ejemplospoo.Geometria;

public class Circulo extends Figura implements IImprimible{    
    private double radio;
    
    public Circulo(double radio) {
        super("Blanco");
        this.radio = radio;
    }
    
    public Circulo(double radio, String color) {
        super(color);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcArea() {
        return (Math.PI*(Math.pow(this.radio, 2)));
    }

    @Override
    public double calcPerimetro() {
        return (2*Math.PI*this.radio);
    }

    @Override
    public void imprimir() {
        System.out.println("Circulo.imprimir(): " + this.toString());
    }
    
    public String toString(){
        return "";
    }

}
