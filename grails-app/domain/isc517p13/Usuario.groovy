package isc517p13

class Usuario {

    String nombre
    String contrasena
    boolean isAdmin




    static belongsTo = [departmento: Departamento]

    static constraints = {

        nombre (blank: false)
        contrasena (blank: false)
        departmento (nullable: true)

    }
}
