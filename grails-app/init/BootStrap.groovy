import isc517p13.Usuario

class BootStrap {

    def init = { servletContext ->
        //para el login
        def usuario = Usuario.findWhere(nombre:'Carlos',
                contrasena:'123')
        if (!usuario)
            new Usuario(nombre:"Carlos",contrasena: "123").save()
    }
    def destroy = {
    }
}
