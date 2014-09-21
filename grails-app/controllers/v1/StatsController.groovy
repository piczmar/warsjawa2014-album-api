package v1
import grails.converters.JSON
class StatsController{
	static namespace ="v1"

	def index(){
		Runtime runtime = Runtime.getRuntime()
		def totalMemory = runtime.totalMemory()
		def freeMemory = runtime.freeMemory()
		
		def result = [memory: [total: totalMemory, free: freeMemory] ]
		
		render text: result as JSON, contentType: 'application/json', status: 200
	}
}