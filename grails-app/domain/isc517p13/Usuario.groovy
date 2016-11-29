package isc517p13

class Usuario implements Serializable {

    String username
    String password
    boolean enabled = true

    Date dateCreated
    Date lastUpdated
    int last_user


    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    transient springSecurityService

    static belongsTo = [departamento: Departamento ]
    static hasMany = [ authorities: UserRole ]

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ?
                springSecurityService.encodePassword(password) :
                password
    }

    static transients = ['springSecurityService']

    static constraints = {
        password blank: false, password: true
        username blank: false, unique: true
        last_user( nullable: true )
        departamento (nullable: true)
        last_user ( display:false )
    }

    static mapping = {
        password column: '`password`'
    }

}
