<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'departamento.label', default: 'Departamento')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <form action="/departamento/update/${departamento.id}" method="post"><input type="hidden" name="_method" value="PUT" id="_method">
                <input type="hidden" name="version" value="0" id="version">
                <div class="form-group">
                    <label for="titulo">Titulo
                        <span class="required-indicator">*</span>
                    </label>
                    <input class="form-control" type="text" name="titulo" value="${departamento.titulo}" required="" maxlength="30" id="titulo">
                </div>
                <div class="form-group">
                    <label for="titulo">Contactos</label>
                    <select id="contacts_list" name="contactos[]" class="form-control" multiple>
                    <g:each in="${this.departamento.contactos}" var="contacto">
                        <option value="${contacto.id}" selected>${contacto.nombre} - ${contacto.email}</option>
                    </g:each>
                    </select>
                </div>
                <input class="save btn btn-primary" type="submit" value="Actualizar">

            </form>
    </body>
</html>
