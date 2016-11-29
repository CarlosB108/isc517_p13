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
        def Usuario = springSecurityService.currentUser
        params.max = Math.min(max ?: 10, 100)
        respond Departamento.list(params), model:[departamentoCount: Departamento.count()]
    }

    def show(Departamento departamento) {
        respond departamento
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

        departamento.last_user = session.Usuario.id
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

        departmento.last_user = session.Usuario.id
        departmento.contactos = [ ]

        def contactos = params.contactos;
        if( contactos == null ) contactos = [ ]

        for ( Integer id : contactos ){
            departmento.contactos.add( Contacto.findById( id ) );
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
}
