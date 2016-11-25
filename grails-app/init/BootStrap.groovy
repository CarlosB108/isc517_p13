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
            new Role(
                    authority: 'ROLE_ADMIN')
        }

        // (!adminUser.authorities.contains( adminRole ) ) {
            def ur = new UserRole( );
            ur.user = adminUser
            ur.role = adminRole

            ur.save( )
     //   }

    }
    def destroy = {
    }
}
