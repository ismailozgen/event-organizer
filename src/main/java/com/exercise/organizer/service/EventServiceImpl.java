package com.exercise.organizer.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.organizer.domain.EventRepository;
import com.exercise.organizer.domain.dto.EventTrackDto;
import com.exercise.organizer.domain.model.Event;
import com.exercise.organizer.util.EventFileDataOperations;

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


	@Override
	public void insertBatchDataFromFile() {
		
		List<Event> eventList = EventFileDataOperations.readEventListFromFile();
		
		eventRepository.save(eventList);
	}


	@Override
	public void clearDatabase() {
		eventRepository.deleteAll();		
	}


	

	
	
}
