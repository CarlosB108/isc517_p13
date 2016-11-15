import isc517p13.Usuario

class BootStrap {

    def init = { servletContext ->
        //para el login
        new Usuario(nombre:"Carlos",contrasena: "123").save()
    }
    def destroy = {
    }
}
