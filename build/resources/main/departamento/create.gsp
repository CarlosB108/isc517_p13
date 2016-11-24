<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'departamento.label', default: 'Departamento')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:form action="save">
        <div class="row">
            <div class="col-md-12">
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" name="titulo" class="form-control" />
                </div>
            </div>
            <div class="col-md-12">
                <button class="btn btn-primary">Crear</button>
            </div>
        </div>
        </g:form>
    </body>
</html>