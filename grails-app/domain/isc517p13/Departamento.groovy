package isc517p13

class Departamento {

    String titulo

    Date dateCreated
    Date lastUpdated
    int last_user

    static hasMany = [contactos: Contacto, usuario: Usuario ]
    static belongsTo = [ Contacto, Usuario ]

    static constraints = {
        last_user( nullable: true )
        titulo (blank: false, minSize: 3,maxSize: 30)
        last_user display:false
    }
}
