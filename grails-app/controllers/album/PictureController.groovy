package album
import album.*
import grails.rest.RestfulController

class PictureController extends RestfulController<Picture>{
	static responseFormats = ['json', 'xml']

	PictureController(){
		super(Picture)
	}

	@Override
	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		def query = {}
		if(params.startTime || params.endTime){
			PictureRangeCommand cmd = new PictureRangeCommand()
			bindData(cmd, params)
			cmd.validate()
			if(cmd.hasErrors()){
				respond cmd.errors
				return
			}

			query = {
				and{
					if(cmd.startTime){
						ge('dateCreated',cmd.startTime)
					}
					if(cmd.endTime){
						le('dateCreated', cmd.endTime)
					}
				}
			}
			println "s: ${cmd.startTime}, e: ${cmd.endTime}"
		}

		respond Picture.createCriteria().list( params,query)
	}
}





