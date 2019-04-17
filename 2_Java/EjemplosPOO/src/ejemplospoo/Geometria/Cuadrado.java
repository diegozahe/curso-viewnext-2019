package ejemplospoo.Geometria;

public class Cuadrado extends Rectangulo implements IImprimible, IMostrable{  
    
    public Cuadrado(double lado) {
        super(lado, lado, "Blanco");
    }
    
    public Cuadrado(double lado, String color) {
        super(lado, lado, color);
    }

    @Override
    public void imprimir() {
        System.out.println("Cuadrado.imprimir(): " + this.toString());
    }

    @Override
    public void mostrar() {
        System.out.println("Cuadrado.mostrar(): " + this.toString());
    }
    
    @Override
    public String toString(){
        return "Cuadrado: base = " + this.getBase() 
                + ", altura = " + this.getAltura() 
                + ", color = " + this.getColor();
    }
    
}
