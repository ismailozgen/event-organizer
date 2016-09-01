package com.exercise.organizer.service;

import java.util.List;

import com.exercise.organizer.domain.dto.EventScheduleDto;
import com.exercise.organizer.domain.dto.EventTrackDto;
import com.exercise.organizer.domain.model.Event;

public interface EventService {

	Event save(Event event);
	
	List<EventTrackDto> getEventOrganizationList();
}
