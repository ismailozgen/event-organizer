package com.exercise.organizer.domain.dto;

import java.util.List;

import org.joda.time.DateTime;

public class EventScheduleLatestTimedDto {

	private DateTime latestTime;
	private List<EventScheduleDto> eventScheduleList;
	
	public DateTime getLatestTime() {
		return latestTime;
	}
	public void setLatestTime(DateTime latestTime) {
		this.latestTime = latestTime;
	}
	public List<EventScheduleDto> getEventScheduleList() {
		return eventScheduleList;
	}
	public void setEventScheduleList(List<EventScheduleDto> eventScheduleList) {
		this.eventScheduleList = eventScheduleList;
	}

}
