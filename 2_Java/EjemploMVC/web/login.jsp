<%@include file="head.jsp" %>
<html>
    <%= head()%>
    <body>
        <h1>Login</h1>
        <form name="form1" method="post" action="./usuarios.do">
            <table border="1">
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="email" name="email" id="email" size="25" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td>
                        <input type="password" name="pass" id="pass" size="25" required="required"/>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="accion" id="accion" value="login">
            <input style="margin-top: 10px; " type="submit" value="Enviar"/>
        </form>
        
        
        
        
    </body>
</html>
