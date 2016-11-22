package isc517p13

class Categoria {


    String titulo

    Date dateCreated
    Date lastUpdated


    static constraints = {
        titulo (blank: false, minSize: 3, maxSize: 30)
    }
}
