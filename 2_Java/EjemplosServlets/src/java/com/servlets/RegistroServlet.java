/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.modelo.DerbyDBUsuario;
import com.modelo.ServicioUsuarios;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Default
 */
public class RegistroServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Leyendo parámetros ParamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Devolviendo sus datos del registro</h1>");
            out.println("<p>Peticion URL: " + request.getContextPath() + "</p>");
            String nombre = request.getParameter("nom");
            String passwd = request.getParameter("pass");
            String edad = request.getParameter("eda");
            String email = request.getParameter("email");
            int iEdad = 0;
            boolean camposOk = true;
            
            if(nombre.equals("")){
                out.println("<p style='background-color:red'>Rellene el nombre</p>");
                camposOk = false;
            }else{
                out.println("<p>Te llamas " + nombre + "</p>");
            }
            if(passwd.equals("")){
                camposOk = false;
                out.println("<p style='background-color:red'>Rellene la contraseña</p>");
            }else{
                out.println("<p>Contraseña: " + passwd + "</p>");
            }
            if(edad.equals("")){
                camposOk = false;
                out.println("<p style='background-color:red'>Rellene la edad</p>");
            }else{
                iEdad = Integer.parseInt(edad);
                if(iEdad < 18){
                    camposOk = false;
                    out.println("<p style='background-color:red'>Tienes menos de 18 años</p>");
                }else{
                    out.println("<p>Tienes " + edad + " años</p>");
                }
            }
            if(email.equals("")){
                camposOk = false;
                out.println("<p style='background-color:red'>Rellene el email</p>");
            }else{
                out.println("<p>Tu correo electronico es " + email + "</p>");
            }
            
            if(camposOk)
            {
                ServicioUsuarios su = ServicioUsuarios.getInstancia();
                su.addUsuario(nombre, Integer.parseInt(edad), email, passwd);
                out.println("<h2>Usuario añadido. Total = " + su.cantidadUsuarios() + "</h2>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
