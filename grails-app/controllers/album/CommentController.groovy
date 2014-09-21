package album
import grails.rest.RestfulController

class CommentController extends RestfulController<Comment>{
	static responseFormats = ['json', 'xml']

	CommentController(){
		super(Comment)
	}
	
	@Override
	def index() {
		def pictureId = params.pictureId
		if(pictureId){
			respond Comment.where {
				picture.id == pictureId
			}.list()
		}else{
			params.max =  Math.min(params.max as Integer ?: 10, 100)
			respond Comment.list(params)
		}
	}
	
}





