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
		
		"/v1/stats"(namespace: "v1", controller: "stats")
		"/v2/stats"(namespace: "v2", controller: "stats")
		
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
