<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>CalendarIO</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <asset:stylesheet src="bootstrap.min.css"/>
    <!-- Theme style -->
    <asset:stylesheet src="AdminLTE.min.css"/>
    <asset:stylesheet src="select2.min.css"/>
    <asset:stylesheet src="select2-bootstrap.min.css"/>
    <asset:stylesheet src="skins/skin-blue.min.css"/>
    <!-- iCheck -->
    <asset:stylesheet src="iCheck/square/blue.css"/>
    <asset:stylesheet src="grails-datatables.css"/>
    <asset:stylesheet src="grails-datatables-plain.css"/>
    <asset:javascript src="grails-datatables.js"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
    <asset:stylesheet src="skin-blue.min.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="index2.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>C</b>IO</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Calendar</b>IO</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">MENU</li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-circle-o"></i> <span>Departamentos</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/departamento">Listar</a></li>
                        <li><a href="/departamento/create">Crear</a></li>
                    </ul>
                </li>
                <!-- SOLO ADMINS -->
                <li class="treeview">
                    <a href="#"><i class="fa fa-circle-o"></i> <span>Contactos</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/contacto">Listar</a></li>
                        <li><a href="/contacto/create">Crear</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-circle-o"></i> <span>Categor&iacute;as</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/categoria">Listar</a></li>
                        <li><a href="/categoria/create">Crear</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-circle-o"></i> <span>Usuario</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/usuario">Listar</a></li>
                        <li><a href="/usuario/create">Crear</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <g:layoutTitle default=""/>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
        <g:layoutBody/>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        Creado por: <a href="http://www.inspira.com.do/">Carlos Batista & C&eacute;sar M&eacute;ndez</a>. 2012-1517/2013-0262.
    </footer>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<asset:javascript src="jquery-2.2.0.min.js"/>
<asset:javascript src="app.min.js"/>
<!-- Bootstrap 3.3.6 -->
<asset:javascript src="bootstrap/js/bootstrap.min.js"/>
<!-- iCheck -->
<asset:javascript src="plugins/iCheck/icheck.min.js"/>
<asset:stylesheet src="grails-datatables.css"/>
<asset:stylesheet src="grails-datatables-jqueryui.css"/>
<asset:javascript src="grails-datatables.js"/>
<asset:javascript src="grails-datatables-jqueryui.js"/>
<asset:javascript src="select2.min.js"/>
<asset:javascript src="general.js"/>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>