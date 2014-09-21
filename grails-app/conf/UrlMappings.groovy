class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/pictures"(resources: "picture")


        "/"(view:"/index")
        "500"(view:'/error')
	}
}
