/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

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
public class ParamServlet extends HttpServlet {

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
            if (request.getMethod().equals("GET")) {
                out.println("<title>Formulario ParamServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Introduzca sus datos </h1>");
                out.println("<form name='form1' method='post' action='/EjemplosServlets/param' >");
                out.println("<table border='1'>");
                out.println("<tr><td>Nombre:</td><td>");
                out.println("<input type='text' name='nom' id='nom' size='25' valiue=''/></td></tr>");
                out.println("<tr><td>Edad:</td><td>");
                out.println("<input type='number' name='eda' id='eda' size='25' valiue=''/></td></tr>");
                out.println("<tr><td>Email:</td><td>");
                out.println("<input type='email' name='email' id='email' size='25' valiue=''/></td></tr>");
                out.println("</table>");
                out.println("<input type='submit' value='Enviar'/>");
            } else if (request.getMethod().equals("POST")) {
                out.println("<title>Leyendo parámetros ParamServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Devolviendo sus datos</h1>");
                out.println("<p>Peticion URL: " + request.getContextPath() + "</p>");
                String nombre = request.getParameter("nom");
                String edad = request.getParameter("eda");
                String email = request.getParameter("email");
                out.println("<p>Te llamas " + nombre + "</p>");
                out.println("<p>Tienes " + edad + " años</p>");
                out.println("<p>Tu correo electronico es " + email + "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

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
