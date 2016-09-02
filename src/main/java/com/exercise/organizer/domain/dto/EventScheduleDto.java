package com.exercise.organizer.domain.dto;

import com.google.common.base.Objects;

public class EventScheduleDto {

	private String timeString;
	private String topic;
	private String duration;
	
	public EventScheduleDto(String timeString, String topic, String duration) {
		this.timeString = timeString;
		this.topic = topic;
		this.duration = duration;
	}
	
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	
    public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	@Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("timeString", timeString)
                .add("topic", topic)
                .toString();
    }

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	

	
	
}
