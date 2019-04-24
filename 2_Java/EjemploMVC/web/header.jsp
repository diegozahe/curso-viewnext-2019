<%@page import="com.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Pagina principal Aplicacion Servlets</h1>
</header>
<nav>
    <a href="index.jsp">Inicio</a>
    <c:catch var="excepcion">
        <%-- <% Usuario usuario = (Usuario) session.getAttribute(("usuairo"));  %> Forma de hacerlo con jsp--%>

        <%-- Forma de hacerlo con jspl. Capturamos los valores de entrada--%>
        <jsp:useBean id="usuario" type="com.modelo.Usuario" scope="session">
            <jsp:getProperty property="*" name="usuario"/>
            <jsp:getProperty property="id" name="usuario"/>
            <jsp:getProperty property="email" name="usuario"/>
        </jsp:useBean>
        <a href="listar.jsp">Listado</a>
    </c:catch>
    <c:if test="${not empty excepcion}">
        <a href="login.jsp">Login</a>
        <a href="registro.jsp">Registro</a>
        
    </c:if>    
  
</nav>

<c:if test="${sesionScope.msj_error != null}">
    <h3 style ="color:orange">${sessionScope.msj_error}</h3>
    <c:remove var="msj_error" scope="session"/>
</c:if>