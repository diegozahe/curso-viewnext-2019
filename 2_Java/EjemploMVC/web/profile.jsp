<%@include file="head.jsp" %>
<% ArrayList<Usuario> listaUsu = ServicioUsuarios.getInstancia().listar();%>
<% Usuario userLogged = ServicioUsuarios.getInstancia().getUserLogged();%>
<html>
    <%= head()%>
    <body>
        <h1>Perfil usuario</h1>
        <div>
            <label style="font-weight: bolder">Correo electronico</label><br>
            <label><% out.println(userLogged.getEmail()); %></label><br><br>
            <label style="font-weight: bolder">Nombre</label><br>
            <label><% out.println(userLogged.getNombre()); %></label><br><br>
            <label style="font-weight: bolder">Edad</label><br>
            <label><% out.println(userLogged.getEdad()); %></label><br><br>
        </div>
        <div>
            <a href="">Modificar</a>
        </div>
    </body>
</html>
