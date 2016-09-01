package com.exercise.organizer.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.exercise.organizer.service.EventService;
import com.exercise.organizer.web.EventCreateController;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {

	@Mock
	private EventService eventService;
	
	private EventCreateController eventController;
	
	@Before
	public void setUp() {
		
	}
	
}
