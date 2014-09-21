import java.text.SimpleDateFormat;
import album.*
import grails.converters.JSON

class BootStrap {

	
	SimpleDateFormat JSON_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	
	def init = { servletContext ->

		JSON.registerObjectMarshaller(Date) { Date d ->
			return JSON_DATE_FORMAT.format(d)
		}
		JSON.registerObjectMarshaller(Picture){Picture p ->
			return [
				id: p.id,
				title: p.title,
				url: p.url,
				dateCreated: p.dateCreated,
				lastUpdated: p.lastUpdated,
				comments : p.comments
			]
		}
		JSON.registerObjectMarshaller(Comment){Comment c->
			return [
				id: c.id,
				text : c.text
			]
		}
		
		(0..10).each{
			def p = new Picture(title: "title ${it}").save(failOnError: true)
			(0..3).each {
				new Comment(text: "Comment ${it}", picture: p).save(failOnError: true)
			}
		}
	}
	def destroy = {
	}
}
