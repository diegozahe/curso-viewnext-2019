<%@include file="head.jsp" %>
<% ArrayList<Usuario> listaUsu = ServicioUsuarios.getInstancia().listar(); %>

<html>
    <%= head() %>
    <body>
        <h1>Listado con JSP</h1>
        <table>
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
