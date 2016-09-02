package com.exercise.organizer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.organizer.domain.dto.EventDto;
import com.exercise.organizer.domain.model.LightningPresentationEvent;
import com.exercise.organizer.domain.model.PresentationEvent;
import com.exercise.organizer.service.EventService;
import com.exercise.organizer.validator.EventDtoDurationValidator;

@Controller
public class EventCreateController {

	
	private final EventService eventService;
	private final EventDtoDurationValidator durationValidator;
	
	@Autowired
    public EventCreateController(final EventService eventService, final EventDtoDurationValidator durationValidator) {
        this.eventService = eventService;
        this.durationValidator = durationValidator;
    }
	
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(durationValidator);
    }

	
	@RequestMapping(value = "/")
    public String welcome() {
		return "redirect:/save_event.html";    }
	
	@RequestMapping(value = "/save_event.html", method = RequestMethod.GET)
    public ModelAndView getSaveEventView() {
        //LOGGER.debug("Received request for user create view");
		System.out.println("geldi2");
        return new ModelAndView("createEvent", "form", new EventDto());
    }
	
	
	@RequestMapping(value = "/save_event.html", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("form") @Valid EventDto eventDto) {
		if (eventDto.getLightning()) {
			eventService.save(new LightningPresentationEvent(eventDto.getTopic()));
		} else {			
			eventService.save(new PresentationEvent(eventDto.getTopic(),eventDto.getDuration()));
		}
        return "redirect:/save_event.html";
	}
	
}
