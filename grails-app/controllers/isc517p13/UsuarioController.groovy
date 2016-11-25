package isc517p13

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class UsuarioController {
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login = {
    }
    def logout() {
        session.Usuario = null
        redirect uri: "/"
    }

    //Para el login
    def doLogin = {
        def usuario = Usuario.findWhere(nombre:params['nombre'],
                contrasena:params['contrasena'])
        session.Usuario = usuario
        reauthenticate
        if (usuario)
            redirect(controller:'departamento',action:'index')
        else
            redirect(controller:'index',action:'index')
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Usuario.list(params), model:[usuarioCount: Usuario.count()]
    }

    def show(Usuario usuario) {
        respond usuario
    }

    def create() {
        respond new Usuario(params)
    }

    @Secured(["ROLE_ADMIN"])
    @Transactional
    def save(Usuario usuario) {
        if (usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond usuario.errors, view:'create'
            return
        }

        //usuario.last_user = session.Usuario.id
        usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect usuario
            }
            '*' { respond usuario, [status: CREATED] }
        }
    }

    @Secured(["ROLE_ADMIN"])
    def edit(Usuario usuario) {
        respond usuario
    }

    @Secured(["ROLE_ADMIN"])
    @Transactional
    def update(Usuario usuario) {
        if (usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (usuario.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond usuario.errors, view:'edit'
            return
        }

        usuario.last_user = session.Usuario.id
        usuario.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect usuario
            }
            '*'{ respond usuario, [status: OK] }
        }
    }

    @Secured(["ROLE_ADMIN"])
    @Transactional
    def delete(Usuario usuario) {

        if (usuario == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        usuario.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuario.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
