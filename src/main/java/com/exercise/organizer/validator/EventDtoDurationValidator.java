package com.exercise.organizer.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.exercise.organizer.domain.dto.EventDto;

@Component
public class EventDtoDurationValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return EventDto.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		EventDto dto = (EventDto)arg0;
		if (dto.getLightning() == false && (dto.getDuration() == null || dto.getDuration() == 0)) {
			arg1.rejectValue("duration", "event.error.duration.is_empty");
		}
	}

}
