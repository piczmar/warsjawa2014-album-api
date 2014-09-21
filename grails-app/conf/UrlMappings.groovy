class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		"/pictures/lucky" (controller: "picture", action: "lucky", method: "GET")
		"/pictures"(resources: "picture"){
			"/comments"(resources: "comment")
		}
		"/comments"(resources: "comment")
		

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
