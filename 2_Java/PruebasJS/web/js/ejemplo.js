var pruebasjava = {
    
};

const MI_PI = 3.1416;
function dameDoble(numero){
    return numero*2;
}


class PruebasJava {
    
    main(args) {
        let contador = 0;
        while (contador < 10) {
            console.log("Contador vale: " + contador);
            contador++;
        }
        
        if (contador === "10") {
            alert("Son iguales");
        }else{
            alert("No son iguales");
        }
        
        if (contador < 10) {
            console.log("Menor que 10");
        } else if (contador === 10) {
            console.log("Igual a 10");
        } else if (contador < 20) {
            console.log("Menor que 20");
        } else {
            console.log("Mayor que 20");
        }

        let letra = "B".toLowerCase();
        switch (letra) {
            case "a":
                console.log("Letra A");
                break;
            case "b":
                console.log("Letra B");
                break;
            case "c":
                console.log("Letra C");
                break;
            default:
                console.log("Ni A, ni B, ni C");
                break;
        }
       
        this.losMismosEjemplos(); 
    }

    losMismosEjemplos() { // No devuelve nada
        for(var i = 5; i > 0; i--){
            console.log("El cuadrado de " + i + " es " + i*i);
        }  
        console.log("IVA 10 " + this.calcularIva(10, 21));
        console.log("IVA 20 " + this.calcularIva(20, 21));
        console.log("IVA 30 " + this.calcularIva(30, 21));
        
        for(i = 0; i < 5; i++){
            console.log(">> " + this.valorAleatorio());
        }
        
        console.log("PI = "+ Math.PI);
        console.log("PI = "+ MI_PI);
        console.log("El doble de 7 es " + dameDoble(7));
        
    }
    
    calcularIva(precio, iva){
        var resultado = precio + iva / 100 *precio;
        return resultado;
    }
    
    valorAleatorio(){
        return Math.random();
    }
    
}


var miPrueba = new PruebasJava();
miPrueba.main();