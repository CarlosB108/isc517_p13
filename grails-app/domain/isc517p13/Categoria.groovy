package isc517p13

class Categoria {
    String titulo
    Date dateCreated
    Date lastUpdated
    int last_user
    static hasMany = [contactos: Contacto]

    static constraints = {
        last_user( nullable: true )
        titulo (blank: false, minSize: 3, maxSize: 30)
        last_user display:false
    }
}
