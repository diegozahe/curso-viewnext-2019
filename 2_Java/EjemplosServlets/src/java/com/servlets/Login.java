/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

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
public class Login extends HttpServlet {

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
            ServicioUsuarios su = ServicioUsuarios.getInstancia();
            String pass = request.getParameter("pass");
            String email = request.getParameter("email");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Leyendo parámetros ParamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (su.validacionPasswd(email, pass)) {
                String valor = (su.setUserLogged(email)) ? "Login correcto" : "Login fallido :-/";
                out.println(valor);
                /*
                out.println("<form name=\"form1\" method=\"post\" action=\"/EjemplosServlets/RegistroServlet\">\n"
                        + "            <table border=\"1\">\n"
                        + "                <tr>\n"
                        + "                    <td>Nombre:</td>\n"
                        + "                    <td>\n"
                        + "                        <input type=\"text\" name=\"nom\" id=\"nom\" size=\"25\" value='" + su.getUserLogged().getNombre() + "' required=\"required\"/>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                    <td>Contraseña</td>\n"
                        + "                    <td>\n"
                        + "                        <input type=\"password\" name=\"pass\" id=\"pass\" size=\"25\" value=" + su.getUserLogged().getPassword() + " required=\"required\"/>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                    <td>Edad:</td>\n"
                        + "                    <td>\n"
                        + "                        <input type=\"number\" name=\"eda\" id=\"eda\" size=\"25\" placeholder=" + su.getUserLogged().getEdad() + ">\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                    <td>Email:</td>\n"
                        + "                    <td>\n"
                        + "                        <input type=\"email\" name=\"email\" id=\"email\" size=\"25\" value=" + su.getUserLogged().getEmail() + " required=\"required\"/>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "            </table>\n"
                        + "                <input type=\"submit\" value=\"Actualizar\"/>\n"
                        + "        </form>");

                // Cargamos una tabla invisible con los datos para poder eliminar
                out.println("<div>"
                        + "         <form name=\"form2\" method=\"post\" action=\"/EjemplosServlets/RegistroServlet\">\n"
                        + "            <table style='display:none;' border=\"1\">\n"
                        + "                <tr>\n"
                        + "                    <td>Contraseña</td>\n"
                        + "                    <td>\n"
                        + "                        <input type=\"password\" name=\"pass\" id=\"pass\" size=\"25\" value=" + su.getUserLogged().getPassword() + " required=\"required\"/>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                    <td>Email:</td>\n"
                        + "                    <td>\n"
                        + "                        <input type=\"email\" name=\"email\" id=\"email\" size=\"25\" value=" + su.getUserLogged().getEmail() + " required=\"required\"/>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "            </table>\n"
                        + "                <input style='' type=\"submit\" value=\"Eliminar\"/>\n"
                        + "        </form>"
                        + "</div>");*/

            } else {
                out.println("El correo y la contraseña no coinciden con ningun usuario registrado");
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
