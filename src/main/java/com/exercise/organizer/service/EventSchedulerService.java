package com.exercise.organizer.service;

import java.util.List;

import com.exercise.organizer.domain.dto.EventTrackDto;
import com.exercise.organizer.domain.model.Event;

public interface EventSchedulerService {

	static final int LEAST_TRACK_DURATION = 360;
	static final int LEAST_SESSION_DURATION = 180;
	static final int EXTENSION_DURATION = 60;

	
	List<EventTrackDto> getEventOrganizationList(List<Event> eventList);
	
}
