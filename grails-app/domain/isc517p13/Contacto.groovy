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
    int last_user

    static belongsTo = [categoria: Categoria]
    static hasMany = [departamentos: Departamento]


    static constraints = {
        last_user( nullable: true )
        nombre (blank: false, minSize: 2)
        apellido (blank: false)
        email (email:true, unique: true)
        telefono (minSize: 10, maxSize: 14, unique: true)
        direccion (nullable: true)
        puesto_de_trabajo (nullable: true)
        celular (minSize: 10, maxSize: 14)
        last_user display:false
    }
}
