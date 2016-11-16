<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>User Login</title>
</head>
<body>
<div class="body">
<g:form action="doLogin" method="post" controller="Usuario">
        <div class="dialog">
            <p>Login</p>
            <table class="userForm">
                <tr class='prop'>
                    <td valign='top' style='text-align:left;' width='20%'>
                        <label for='email'>Nombre:</label>
                    </td>
                    <td valign='top' style='text-align:left;' width='80%'>
                        <input id="email" type='text' name='nombre' value='' />
                    </td>
                </tr>
                <tr class='prop'>
                    <td valign='top' style='text-align:left;' width='20%'>
                        <label for='password'>Contraseña:</label>
                    </td>
                    <td valign='top' style='text-align:left;' width='80%'>
                        <input id="password" type='password' name='contrasena'
                               value='' />
                    </td>
                </tr>

            </table>
        </div>
        <div class="buttons">
            <span class="formButton">
                <input type="submit" value="Login"></input>
            </span>
        </div>
</g:form>
</div>
</body>
</html>

