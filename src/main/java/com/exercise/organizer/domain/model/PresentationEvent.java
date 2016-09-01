package com.exercise.organizer.domain.model;

import javax.persistence.Entity;

@Entity
public class PresentationEvent extends Event{

	public PresentationEvent() {
		super();
	}
	
	public PresentationEvent(String topic, Integer duration) {
		super(topic, duration);
	}
	
}
