package com.exercise.organizer.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.exercise.organizer.service.EventService;


public class EventListControllerTest {

    @Mock
    private EventService eventService;

    private EventListController eventListController;

    
    @Before
    public void setUp() throws Exception {
    	eventListController = new EventListController(eventService);
    }

	@Test
	public void getListEventAgendaTest() {
		
		eventService.getEventOrganizationList();
	}
}
