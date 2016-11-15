package isc517p13

class Categoria {


    String titulo

    Date FechaCreada
    Date UltimaModificacion


    static constraints = {
        titulo (blank: false, minSize: 3, maxSize: 30)
    }
}
