package ejemplospoo.Geometria;

public abstract class Figura implements Comparable<Figura>{
    protected String color;
    /*
    public Figura(String color){
        this.color = color;
    }*/
    
    
    public Figura(String textoDes) {
        String[] partesTexto = textoDes.split(":");
        if (partesTexto.length == 1) {
            this.color = textoDes;
        } 
        else if (partesTexto.length == 2) {
            String[] partesCampos = textoDes.split(":")[1].split(",");
            for (String parteCampo : partesCampos) {
                int posIgual = parteCampo.indexOf("=");
                String campo = parteCampo.substring(0, posIgual).trim().toLowerCase();
                String valor = parteCampo.substring(posIgual + 1).trim();
                switch (campo) {
                    case "color":
                        this.color = valor; // CAMBIAR color a PROTECTED
                        break;
                }
            }
        }
    }
    public String getColor(){
        return this.color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    
    public abstract double calcArea();
    public abstract double calcPerimetro();
    
    @Override
    public int compareTo(Figura fig){
        if(this.calcArea() == fig.calcArea()){
            return 0;
        }else if(this.calcArea() < fig.calcArea()){
            return -1;
        }
        return 1;
    }

    
    
}
