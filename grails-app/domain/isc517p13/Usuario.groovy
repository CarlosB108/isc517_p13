package isc517p13

class Usuario {

    String username
    String password
    boolean isAdmin

    Date dateCreated
    Date lastUpdated
    int last_user

    static belongsTo = [departamento: Departamento ]
    static hasMany = [ authorities: UserRole ]
    static constraints = {

        last_user( nullable: true )
        username (blank: false)
        password (blank: false)
        departamento (nullable: true)
        last_user ( display:false )

    }
}
