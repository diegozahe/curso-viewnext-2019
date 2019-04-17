package ejemplospoo.Geometria;


public class Rectangulo extends FiguraConLados{
    
    public Rectangulo(double base, double altura) {
        super(base, altura, "Blanco");
    }
    
    public Rectangulo(double base, double altura, String color) {
        super(base, altura, color);
    }
    
    @Override
    public double calcArea() {
        return this.base*this.altura;
    }

    @Override
    public double calcPerimetro() {
        return ((2*this.base)+(2*this.altura));
    }
    
    @Override
    public String toString(){
        return "Rectangulo: base = " + this.getBase() 
                + ", altura = " + this.getAltura() 
                + ", color = " + this.getColor();
    }
    
}
