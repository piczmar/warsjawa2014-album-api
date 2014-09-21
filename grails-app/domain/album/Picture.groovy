package album
import grails.rest.*

@Resource(uri="/pictures",  formats=['json', 'xml'])
class Picture {
	Long id
	String url = "http://some.dummy.url"
	String title
	Date dateCreated
	Date lastUpdated

	//User createdBy
	static hasMany = [comments: Comment]

    static constraints = {
		title nullable: true
		url nullable: true
    }
	static mapping = {
		autoTimestamp true
	}

	String filename(){
		Picture.filename(id)
	}
	static String filename(long id) {
        "${id}.jpeg"
    }

	// This way we make 'url' field readonly
	String getUrl(){
		url
	}
}
