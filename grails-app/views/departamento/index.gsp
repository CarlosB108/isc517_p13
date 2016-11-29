<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'departamento.label', default: 'Departamento')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-12">
            <table class="table table-stripped" style="background-color: #FFF;">
                    <thead>
                    <tr>
                        <th>Nombre</th>
                    </tr>
                    </thead>
                    <g:each in="${departamentoList}" var="department">
                        <g:if test="${ uactual.isAdmin() || uactual.departamento.id == department.id }">
                        <tr>
                            <th><a href="/departamento/show/${department.id}">${department.titulo}</a></th>
                        </tr>
                        </g:if>
                    </g:each>
                    </tbody>
                 </table>
            </div>
        </div>
    </body>
</html>