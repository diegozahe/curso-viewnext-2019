<%@include file="head.jsp" %>
<html>
    <%= head() %>
    <body>
        <%@include file="header.jsp" %>
        <h2>Registro</h2>
        <form name="form1" method="post" action="./usuarios.do">
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="nom" id="nom" size="25" value="Diego Prueba" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td>
                        <input type="password" name="pass" id="pass" size="25" value="1234" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td>
                        <input type="number" name="eda" id="eda" size="25" value="36"/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="email" name="email" id="email" size="25" value="correo@gmail.com" required="required"/>
                    </td>
                </tr>
            </table>
                <input type="submit" value="Actualizar"/>
        </form>
        <h1>Hello World!</h1>
    </body>
</html>
