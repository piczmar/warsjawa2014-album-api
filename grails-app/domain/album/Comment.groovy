package album
import grails.rest.*

@Resource(uri="/comments", formats=['json', 'xml'])
class Comment {

	String text
	Date dateCreated
	Date lastUpdated
	//Picture picture
	static belongsTo = [picture: Picture]
    static constraints = {
		text maxSize: 200
    }
	static mapping = {
		autoTimestamp true
	}
}
