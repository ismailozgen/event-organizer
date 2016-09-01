package com.exercise.organizer.service.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.exercise.organizer.domain.dto.EventScheduleDto;
import com.exercise.organizer.domain.dto.EventScheduleLatestTimedDto;
import com.exercise.organizer.domain.model.Event;

public interface BaseScheduler {

	static final DateTimeFormatter DTF = DateTimeFormat.forPattern("hh:mm a");

	default EventScheduleLatestTimedDto generateSchedule(List<Event> eventList, DateTime currentTime) {
		
		EventScheduleLatestTimedDto eventScheduleLatestTimedDto = new EventScheduleLatestTimedDto();
		
		List<EventScheduleDto> eventScheduleList = new ArrayList<EventScheduleDto>();
		
		for (Event currEvent : eventList) {

			EventScheduleDto eventScheduleDto = new EventScheduleDto(DTF.print(currentTime),currEvent.getTopic());

			eventScheduleList.add(eventScheduleDto);

			currentTime = currentTime.plusMinutes(currEvent.getDuration());

		}
		
		eventScheduleLatestTimedDto.setEventScheduleList(eventScheduleList);
		eventScheduleLatestTimedDto.setLatestTime(currentTime);
		
		return eventScheduleLatestTimedDto;
	}
	
}
