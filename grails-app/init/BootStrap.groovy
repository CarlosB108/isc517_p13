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

     //   }

    }
    def destroy = {
    }
}
