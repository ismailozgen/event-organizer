package com.exercise.organizer.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.organizer.domain.EventRepository;
import com.exercise.organizer.domain.dto.EventDto;
import com.exercise.organizer.domain.dto.EventScheduleDto;
import com.exercise.organizer.domain.dto.EventTrackDto;
import com.exercise.organizer.domain.model.Event;

@Service
public class EventServiceImpl implements EventService {

	private final EventRepository eventRepository;
	private final EventSchedulerService eventSchedulerService;

	
    @Autowired
    public EventServiceImpl(final EventRepository eventRepository,final EventSchedulerService eventSchedulerService) {
        this.eventRepository = eventRepository;
        this.eventSchedulerService = eventSchedulerService;
    }

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Event save(Event event) {
		return eventRepository.save(event);
	}


	@Override
	public List<EventTrackDto> getEventOrganizationList() {
		List<Event> eventList = eventRepository.findAll();
		Collections.shuffle(eventList);
		return eventSchedulerService.getEventOrganizationList(eventList);
	}

	
	
}
