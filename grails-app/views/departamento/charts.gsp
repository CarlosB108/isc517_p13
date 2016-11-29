<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'departamento.label', default: 'Departamento')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>

</head>
<body>
        <gvisualization:apiImport/>
        <gvisualization:pieCoreChart elementId="contacts" title="Contactos por departamento" width="${500}" height="${500}"
                                     columns="${col_con}" data="${data_con}" />
        <div id="contacts"></div>

        <gvisualization:pieCoreChart elementId="categories" title="Contactos por cat." width="${500}" height="${500}"
                                     columns="${col_cat}" data="${data_cat}" />
        <div id="categories"></div>

    </content>
</body>
</html>
