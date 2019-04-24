/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewnext.controladores;

import com.modelo.ServicioUsuarios;
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
public class UsuariosController extends HttpServlet {

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
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String edad = request.getParameter("eda");
            String passwd = request.getParameter("pass");
            String accion = request.getParameter("accion");
            boolean realizado;
            switch (accion) {
                case "registro":
                    realizado = ServicioUsuarios.getInstancia().addUsuario(nom, edad, email, passwd);
                    if (realizado) {
                        out.println("<h3>Registrado correctamente</h3>");
                    } else {
                        out.println("<h3>No se ha Registrado</h3>");
                    }
                    break;
                case "login":
                    realizado = ServicioUsuarios.getInstancia().setUserLogged(email, passwd);
                    if (realizado) {
                        out.println("<h3>Logueado correctamente</h3>");
                        out.println("<a href='profile.jsp'>Ir a mi perfil</a>");
                    } else {
                        out.println("<h3>No se ha podido loguear</h3>");
                        out.println("<a href='index.jsp'>Volver a intentar</a>");
                    }
                    break;
                case "delete":
                    break;
                case "update":
                    break;
                    
            }

        }catch(Exception ex){
            System.out.println(" >>>>> Error Usuario.do" + ex.getMessage());
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
