<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'departamento.label', default: 'Departamento')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
    <div class="panel">
        <table class="table table-stripped">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>&Uacute;ltima actualizaci&oacute;n</th>
                <th>Creado</th>
                <th>N&uacute;mero de contactos</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${this.departamento.titulo}</td>
                <td>${this.departamento.lastUpdated}</td>
                <td>${this.departamento.dateCreated}</td>
                <td>${this.departamento.contactos.count}</td>
            </tr>
            </tbody>
        </table>
    </div>


    <div class="panel">
        <div class="panel-heading">
            Contactos
        </div>
        <div class="panel-body">
            <table class="table table-stripped">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Tel&eacute;fono</th>
                    <th>Correo</th>
                    <th>Direcci&oacute;n</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${this.departamento.contactos}" var="contacto">
                <tr>
                    <td>${contacto.nombre}</td>
                    <td>${contacto.apellido}</td>
                    <td>${contacto.telefono}</td>
                    <td>${contacto.email}</td>
                    <td>${contacto.direccion}</td>
                </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>

        <g:form resource="${this.departamento}" method="DELETE">
            <fieldset class="buttons">
                <g:link class="edit btn btn-primary" action="edit" resource="${this.departamento}"><g:message code="default.button.editar.label" default="Editar" /></g:link>
            </fieldset>
        </g:form>
    </body>
</html>
