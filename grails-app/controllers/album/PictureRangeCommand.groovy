package album
@grails.validation.Validateable(nullable=true)

class PictureRangeCommand{
	@org.grails.databinding.BindingFormat('yyyy-MM-dd hh:mm:ss')
	Date startTime
	@org.grails.databinding.BindingFormat('yyyy-MM-dd hh:mm:ss')
	Date endTime

	static constraints = {
		startTime nullable: true,  validator: { val, obj -> 
			if(val!=null){
				if(obj.endTime){
					if(val >= obj.endTime)return ['startTimeAfterEndTime']
				}
			}
		}
		endTime nullable: true, validator: { val, obj ->
			if(val!=null){
				if(obj.startTime){
					if(val  <= obj.startTime)return ['endTimeBeforeStartTime']
				}
			}
		}
	}
}
