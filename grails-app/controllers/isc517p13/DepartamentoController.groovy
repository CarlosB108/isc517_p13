package isc517p13

import grails.converters.JSON
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

@Secured(["ROLE_USER"])
@Transactional(readOnly = true)
class DepartamentoController {

    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def uactual = springSecurityService.currentUser
        params.max = Math.min(max ?: 10, 100)
        respond Departamento.list(params), model:[departamentoCount: Departamento.count(), uactual:uactual]
    }

    def show(Departamento departamento) {

        def uactual = springSecurityService.currentUser
        respond departamento, model:[ uactual:uactual]

    }

    @Secured(["ROLE_ADMIN"])
    def create() {
        respond new Departamento(params)
    }

    @Secured(["ROLE_ADMIN"])
    @Transactional
    def save(Departamento departamento) {
        if (departamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (departamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond departamento.errors, view:'create'
            return
        }

        departamento.last_user = springSecurityService.currentUser.id
        departamento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'departamento.label', default: 'Departamento'), departamento.id])
                redirect departamento
            }
            '*' { respond departamento, [status: CREATED] }
        }
    }

    @Secured(["ROLE_ADMIN"])
    def edit(Departamento departamento) {
        respond departamento
    }

    @Secured(["ROLE_ADMIN"])
    @Transactional
    def update(Departamento departamento) {

        if (departamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }



        if (departamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond departamento.errors, view:'edit'
            return
        }

        departamento.last_user = springSecurityService.currentUser.id

        departamento.contactos.collect().each {
            departamento.removeFromContactos( it )
        }

        def contactos = params.list( 'contactos[]' );

        if( contactos == null ) contactos = [ ]

        for ( String id : contactos ){
            System.out.println( id )
            System.out.println( Contacto.findById( id ) );
            departamento.addToContactos ( Contacto.findById( id ) );
        }

        departamento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'departamento.label', default: 'Departamento'), departamento.id])
                redirect departamento
            }
            '*'{ respond departamento, [status: OK] }
        }
    }

    @Transactional
    def delete(Departamento departamento) {

        if (departamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        departamento.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'departamento.label', default: 'Departamento'), departamento.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def charts( ){
        List columna_con = [['string', 'Departamento'], ['number', 'Cantidad de Contactos']]
        List data_con = []
        def departamentos = Departamento.findAll( )

        for( Departamento d in departamentos ){
            data_con << [ d.titulo, d.contactos.size( ) ]
        }


        def categorias = Categoria.findAll( )
        List columna_cat = [['string', 'Categoria'], ['number', 'Cantidad de Contactos']]
        List data_cat = []

        for( Categoria c in categorias ){
            data_cat << [ c.titulo, c.contactos.size() ]
        }

        render(view: "charts", model: ["col_con" : columna_con, "data_con" : data_con, "data_cat": data_cat, 'col_cat': columna_cat ] )
    }
}
