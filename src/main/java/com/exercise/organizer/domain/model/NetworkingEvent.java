package com.exercise.organizer.domain.model;

public class NetworkingEvent extends Event{

	private static final String NETWORKING_TOPIC = "Networking Event";

	
	public NetworkingEvent() {
		super();
	}
	
	public NetworkingEvent(Integer duration) {
		super(NETWORKING_TOPIC, duration);
	}

	
	@Override
	public String getTopic() {
		return NETWORKING_TOPIC;
	}

	
}
