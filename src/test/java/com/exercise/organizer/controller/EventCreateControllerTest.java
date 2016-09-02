package com.exercise.organizer.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.organizer.controller.EventCreateController;
import com.exercise.organizer.domain.dto.EventDto;
import com.exercise.organizer.service.EventService;
import com.exercise.organizer.validator.EventDtoDurationValidator;

@RunWith(MockitoJUnitRunner.class)
public class EventCreateControllerTest {

	@Mock
	private EventService eventService;
	
	@Mock
	private EventDtoDurationValidator eventDtoDurationValidator;
	
	private EventCreateController eventController;
	
	@Before
	public void setUp() {
		eventController = new EventCreateController(eventService,eventDtoDurationValidator);
	}
	
	@Test
	public void getSaveEvetViewTest() {
		ModelAndView modelAndView = eventController.getSaveEventView();
		String viewName = modelAndView.getViewName();
		assertEquals("invalid view name","createEvent",viewName);
		Object modelObj = modelAndView.getModel().get("form");
		assertTrue("invalid model type", modelObj instanceof EventDto);

	}
	
	
}
