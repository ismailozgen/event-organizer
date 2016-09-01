package com.exercise.organizer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.organizer.service.EventSchedulerService;
import com.exercise.organizer.service.EventService;

@Controller
public class EventListController {

	private final EventService eventService;
	
	@Autowired
	public EventListController(final EventService eventService) {
		this.eventService = eventService;
	}
	
	@RequestMapping("/list_events.html")
    public ModelAndView getListEventsView() {
        //LOGGER.debug("Received request to get user list view");
        ModelMap model = new ModelMap();
        model.addAttribute("tracks", eventService.getEventOrganizationList());
        return new ModelAndView("listEvents", model);
    }
	
}
