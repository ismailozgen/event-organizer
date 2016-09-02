package com.exercise.organizer.service.scheduler;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.stereotype.Component;

import com.exercise.organizer.domain.dto.EventScheduleDto;
import com.exercise.organizer.domain.dto.EventScheduleLatestTimedDto;
import com.exercise.organizer.domain.model.Event;


@Component("afternoonScheduler")
public class AfternoonScheduler implements BaseScheduler{

	private static String NETWORKING_EVENT_STR = "Networking Event";
	
	private static String FINISH_STR = "Finish";

	public EventScheduleLatestTimedDto generateSchedule(List<Event> eventList,DateTime currentTime) {
		
		EventScheduleLatestTimedDto eventScheduleLatestTimedDto = BaseScheduler.super.generateSchedule(eventList, currentTime);
		
		List<EventScheduleDto> eventScheduleList = eventScheduleLatestTimedDto.getEventScheduleList();

		currentTime = eventScheduleLatestTimedDto.getLatestTime();
		
		DateTime timeLimit = new DateTime().withTime(17, 0, 0, 0);
		
		int remainingMinutes = Minutes.minutesBetween(currentTime, timeLimit).getMinutes();
		
		boolean isNetworkingAvaliable = (60 >= remainingMinutes) && (remainingMinutes > 0);
		
		if (isNetworkingAvaliable) {
			eventScheduleList.add(new EventScheduleDto(DTF.print(currentTime), NETWORKING_EVENT_STR,""));
		} 
		
		if (isNetworkingAvaliable || remainingMinutes == 0) {
			eventScheduleList.add(new EventScheduleDto(DTF.print(timeLimit), FINISH_STR,""));
		}
		return eventScheduleLatestTimedDto;
	}
}
