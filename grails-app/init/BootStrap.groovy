package isc517p13

class BootStrap {

    def init = { servletContext ->

        def adminUser = Usuario.findByUsername('Carlos')

        if( adminUser == null ) {
            adminUser = new Usuario(username: 'Carlos',
                    password: '123').save()
        }

        def adminRole = Role.findByAuthority('ROLE_ADMIN');

        if( adminRole == null ){
            adminRole = new Role(
                    authority: 'ROLE_ADMIN')
            def userRole = new Role(
                    authority: 'ROLE_USER')

            System.out.println( adminUser.getUsername( ) )
            System.out.println( adminRole.getAuthority() )

            UserRole.create adminUser, adminRole
            UserRole.create adminUser, userRole
        }


        //SAMPLE DATA
        def d1 = new Departamento( )
        d1.titulo = "Tesorería"
        d1.save()

        def d2 = new Departamento( )
        d2.titulo = "Recursos Humanos"
        d2.save()

        def c1 = new Categoria()
        c1.titulo = "Cat 1"
        c1.save()

        def c2 = new Categoria()
        c2.titulo = "Cat 2"
        c2.save()

        //   }

    }
    def destroy = {
    }
}
