package com.exercise.organizer.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.exercise.organizer.domain.dto.EventScheduleDto;
import com.exercise.organizer.domain.dto.EventTrackDto;
import com.exercise.organizer.domain.model.Event;
import com.exercise.organizer.service.scheduler.BaseScheduler;
import com.exercise.organizer.util.EventDurationFinder;

@Service
public class EventSchedulerServiceImpl implements EventSchedulerService{

	@Resource(name = "morningScheduler")
	BaseScheduler morningScheduler;

	@Resource(name = "afternoonScheduler")
	BaseScheduler afternoonScheduler;
	

	@Override
	public List<EventTrackDto> getEventOrganizationList(List<Event> eventList) {

		List<EventTrackDto> eventTrackDtoList = new ArrayList<EventTrackDto>();
		
		// get all durations
		List<Integer> durationList = new ArrayList<Integer>();
		
		int totalDuration = 0;
		
		for (Event event : eventList) {
			int eventDuration = event.getDuration();
			durationList.add(eventDuration);
			totalDuration += eventDuration;
		}

		// find number of tracks
		int numOfTracks = totalDuration / LEAST_TRACK_DURATION ;
		
		if (totalDuration % LEAST_TRACK_DURATION > LEAST_SESSION_DURATION) {
			numOfTracks++;
		}
		
		for (int i = 1 ; i <= numOfTracks ; i++) {
			
			EventTrackDto eventTrackDto = new EventTrackDto();
			
			eventTrackDto.setTrackNumber("Track "+i);
						
			List<EventScheduleDto> morningSchedule = generateMorningSchedule(eventList, durationList);
			
			eventTrackDto.setMorningSchedule(morningSchedule);
						
			List<EventScheduleDto> afternoonSchedule = generateAfternoonSchedule(eventList, durationList);

			eventTrackDto.setAfternoonSchedule(afternoonSchedule);
			
			eventTrackDtoList.add(eventTrackDto);
		}
		
		return eventTrackDtoList;
	}

	private List<EventScheduleDto> generateAfternoonSchedule(List<Event> eventList, List<Integer> durationList) {
		
		List<Integer> afternoonSessionEventDurationList = new EventDurationFinder().findDurations(durationList, LEAST_SESSION_DURATION,true);

		List<Event> afternoonEventList = getEventList(eventList, durationList, afternoonSessionEventDurationList);
		
		DateTime afternoonTime = new DateTime().withTime(13, 0, 0, 0);
		
		List<EventScheduleDto> afternoonSchedule = afternoonScheduler.generateSchedule(afternoonEventList, afternoonTime).getEventScheduleList();
		return afternoonSchedule;
	}

	private List<EventScheduleDto> generateMorningSchedule(List<Event> eventList, List<Integer> durationList) {
		
		List<Integer> morningSessionEventDurationList = new EventDurationFinder().findDurations(durationList, LEAST_SESSION_DURATION,false);

		List<Event> morningEventList = getEventList(eventList, durationList, morningSessionEventDurationList);

		DateTime morningTime = new DateTime().withTime(9, 0, 0, 0);
		
		List<EventScheduleDto> morningSchedule = morningScheduler.generateSchedule(morningEventList, morningTime).getEventScheduleList();
		
		return morningSchedule;
	}

	private List<Event> getEventList(List<Event> eventList, List<Integer> durationList,
			List<Integer> morningSessionEventDurationList) {
		
		List<Event> morningEventList = new ArrayList<Event>();
		
		for (Integer currDuration : morningSessionEventDurationList) {

			Event selectedEvent = getEventWithDurationAndUpdateEventList(eventList,currDuration);

			morningEventList.add(selectedEvent);
			
			durationList.remove(currDuration);
		}
		
		return morningEventList;
	}
	

	private Event getEventWithDurationAndUpdateEventList(List<Event> eventList, Integer duration) {

		for (Event event : eventList) {
			if (event.getDuration() == duration){
				eventList.remove(event);
				return event;
			}
		}

		return null;

	}


}
