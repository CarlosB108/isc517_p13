package isc517p13

class Departamento {

    String titulo

    Date FechaCreada
    Date UltimaModificacion

    static hasMany = [contactos: Contacto]


    static constraints = {

        titulo (blank: false, minSize: 3,maxSize: 30)
    }
}
