package isc517p13

class Contacto {


    String nombre
    String apellido
    String email
    String telefono
    String direccion
    String puesto_de_trabajo
    String celular
    Date dateCreated
    Date lastUpdated

    static hasMany = [deparmentos: Departamento]
    static belongsTo = [depart: Departamento]

    static constraints = {

        nombre (blank: false)
        apellido (blank: false)
        email (email:true, unique: true)
        telefono (minSize: 10, maxSize: 14, unique: true)
        direccion (nullable: true)
        puesto_de_trabajo (nullable: true)
        celular (minSize: 10, maxSize: 14)


    }
}
