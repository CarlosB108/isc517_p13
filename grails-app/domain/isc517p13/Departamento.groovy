package isc517p13

class Departamento {

    String titulo

    Date dateCreated
    Date lastUpdated

    static hasMany = [contactos: Contacto]
    static mappedBy = [contactos: 'depart'];

    static constraints = {
        titulo (blank: false, minSize: 3,maxSize: 30)
    }
}
