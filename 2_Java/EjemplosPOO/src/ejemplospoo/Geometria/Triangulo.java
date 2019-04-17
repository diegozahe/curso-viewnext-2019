package ejemplospoo.Geometria;


public class Triangulo extends FiguraConLados implements IMostrable{
    private double[] lados;
    
    public Triangulo(double base, double altura, double[] lados) {
        super(base, altura, "Blanco");
        this.lados = lados;
    }
    
    public Triangulo(double base, double altura, double[] lados, String color) {
        super(base, altura, color);
        this.lados = lados;
    }

    public Triangulo(String textoDeserializar) {
        super(textoDeserializar);
    }
    
    public double[] getLados() {
        return lados;
    }

    public void setLados(double[] lados) {
        this.lados = lados;
    }
    
    @Override
    public double calcArea() {
        return this.base*(this.altura/2);
    }
    
    @Override
    public double calcPerimetro() {
        return lados[0]+ lados[1]+lados[2];    
    }

    @Override
    public void mostrar() {
        System.out.println("Triangulo.mostrar(): " + this.toString());
    }

    @Override
    public String toString(){
        return "Triangulo: base = " + this.getBase() 
                + ", altura = " + this.getAltura() 
                + ", color = " + this.getColor();
    }
    
}
