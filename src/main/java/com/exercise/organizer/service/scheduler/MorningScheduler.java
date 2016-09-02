package com.exercise.organizer.service.scheduler;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.exercise.organizer.domain.dto.EventScheduleDto;
import com.exercise.organizer.domain.dto.EventScheduleLatestTimedDto;
import com.exercise.organizer.domain.model.Event;

@Component("morningScheduler")
public class MorningScheduler implements BaseScheduler{

	private static final String LUNCH_STR = "Lunch";
	
	
	public EventScheduleLatestTimedDto generateSchedule(List<Event> eventList,DateTime currentTime) {
		
		EventScheduleLatestTimedDto eventScheduleLatestTimedDto = BaseScheduler.super.generateSchedule(eventList, currentTime);
		
		List<EventScheduleDto> eventScheduleList = eventScheduleLatestTimedDto.getEventScheduleList();
		
		currentTime = eventScheduleLatestTimedDto.getLatestTime();
		
		eventScheduleList.add(new EventScheduleDto(DTF.print(currentTime),LUNCH_STR,""));

		return eventScheduleLatestTimedDto;
	}

	
}
