<%@include file="head.jsp" %>
<% ArrayList<Usuario> listaUsu = ServicioUsuarios.getInstancia().listar();%>

<html>
    <%= head()%>
    <body>
        <h1>Listado con JSP</h1>
        <% for (Usuario usu : listaUsu) {%>
        <form action="usuarios.do" method="post" name="form_<%= usu.getId()%>">
            <input id="id" name="id" type="text" size="20" readonly="true" value="<% usu.getId(); %>"/>
            <input id="email" name="email" type="text" size="4" value="<% usu.getEmail(); %>"/>
            <input id="nombre" name="nom" type="text" size="20" value="<% usu.getNombre(); %>"/>
            <input id="nombre" name="nom" type="text" size="10" value="<% usu.getPassword(); %>"/>
            
            
            <input class="metodo" id="accion" name="accion" readonly="true" value="PUT"/>
            <input type="submit" value="edit" onclick="Array.from(document.getElementByClassName('metodo'))
                        .forEach((thisInput) => {thisInput.value='PUT'; })"/>
         
        </form> 
        <% }%>
    </body>
</html>



