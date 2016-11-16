package isc517p13

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/login")
        "/index"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
