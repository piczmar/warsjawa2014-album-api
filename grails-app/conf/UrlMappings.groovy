class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		"/pictures/lucky" (controller: "picture", action: "lucky", method: "GET") // this mapping must be placed before others because it overrides
																				  // /pictures/:id endpoint
		"/pictures"(resources: "picture"){
			"/comments"(resources: "comment")
		}
		"/comments"(resources: "comment")
		
//		"/v1/stats"(namespace: "v1", controller: "stats")
//		"/v2/stats"(namespace: "v2", controller: "stats")
		
		"/stats"(namespace: "v1", controller: "stats", version: '1.0')
		"/stats"(namespace: "v2", controller: "stats", version: '2.0')
		
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
