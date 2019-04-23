package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaServlet extends HttpServlet{
    
    // Recibir metodo HTTP:
    @Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException{
        respuesta.setContentType("text/html;charset=UTF-8");
        // Hay dos formas, creando el objeto en el try sin necesidad de hacer .close en los objetos que creamos, o creando el objeto en el try
        try(PrintWriter salida = respuesta.getWriter()){
           salida.println("<html>"); 
           salida.println("<head>");
           salida.println("<title>Hola desde el Servlet</title>"); 
           salida.println("</head>"); 
           salida.println("<body>"); 
           salida.println("<h1>Hola desde el Servlet</h1>");
           salida.println("<h2>Ruta del Servlet: " + peticion.getContextPath() + "</h2>");
           salida.println("<h2>Metodo de la peticion: " + peticion.getMethod() + "</h2>");
           salida.println("<ul>");
           for(int i=0; i < 10;i++){
               salida.println("<li>N&uacute;mero: " + i + "</li>");
           }
           salida.println("");
           salida.println("</ul>");
           salida.println(""); 
           salida.println("</body>"); 
           salida.println("</html>"); 
        }
        /*catch(){
            
        }*/
        
    }
    
}
