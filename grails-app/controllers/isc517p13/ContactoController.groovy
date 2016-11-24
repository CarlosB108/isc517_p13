package isc517p13

import grails.converters.JSON
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class ContactoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Contacto.list(params), model:[contactoCount: Contacto.count()]
    }
//Para el login
    def beforeInterceptor = [action:this.&checkUser,except:
            ['index','list','show']]
    def checkUser() {
        if(!session.user) {
// i.e. user not logged in
            redirect(controller:'usuario',action:'login')
            return false
        }
    }

    def search( String q ){
        def lista = Contacto.findByEmailOrNombre( q, q )
        if ( lista == null ) lista = []
        render lista as JSON
    }

    def show(Contacto contacto) {
        respond contacto
    }

    def create() {
        respond new Contacto(params)
    }

    @Transactional
    def save(Contacto contacto) {
        if (contacto == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (contacto.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contacto.errors, view:'create'
            return
        }

        contacto.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contacto.label', default: 'Contacto'), contacto.id])
                redirect contacto
            }
            '*' { respond contacto, [status: CREATED] }
        }
    }

    def edit(Contacto contacto) {
        respond contacto
    }

    @Transactional
    def update(Contacto contacto) {
        if (contacto == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (contacto.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contacto.errors, view:'edit'
            return
        }

        contacto.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'contacto.label', default: 'Contacto'), contacto.id])
                redirect contacto
            }
            '*'{ respond contacto, [status: OK] }
        }
    }

    @Transactional
    def delete(Contacto contacto) {

        if (contacto == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        contacto.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'contacto.label', default: 'Contacto'), contacto.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contacto.label', default: 'Contacto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
