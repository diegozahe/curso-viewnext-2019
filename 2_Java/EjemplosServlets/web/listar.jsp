<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="com.modelo.ServicioUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
        <h1>Listado con JSP</h1>
        <table>
            <%
            ArrayList<Usuario> listaUsu = ServicioUsuarios.getInstancia().listar();
            %>
            <thead>
                <th>Nombre</th>
                <th>Email</th>
            </thead>
            <tbody>
                <% 
                for(Usuario usu : listaUsu) {
                %>
                <tr>
                    <td><% out.println(usu.getNombre()); %></td>
                    <td> <%= usu.getEmail()%> </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
    </body>
</html>
