package com.exercise.organizer.domain.model;

import javax.persistence.Entity;

@Entity
public class LightningPresentationEvent extends Event{

	private static final Integer LIGHTNING_DURATION = 5;

	public LightningPresentationEvent() {
		super();
	}
	
	public LightningPresentationEvent(String topic) {
		super(topic, LIGHTNING_DURATION);
	}
	
	@Override
	public Integer getDuration() {
		return LIGHTNING_DURATION;
	}
}
