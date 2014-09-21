package v2

import grails.converters.JSON

class StatsController {

	static namespace ="v2"

	def index(){
		Runtime runtime = Runtime.getRuntime()
		def totalMemory = runtime.totalMemory()
		def freeMemory = runtime.freeMemory()
		
		def result = [totalMem: totalMemory, freeMem: freeMemory ]
		
		render text: result as JSON, contentType: 'application/json', status: 200
		
	}
}
