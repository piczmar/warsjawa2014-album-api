import album.*

class BootStrap {

    def init = { servletContext ->

		(0..10).each{
			new Picture(title: "title ${it}").save(failOnError: true)
		}
    }
    def destroy = {
    }
}
