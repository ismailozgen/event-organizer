package com.exercise.organizer.domain.dto;

import java.util.List;

import com.google.common.base.Objects;

public class EventTrackDto {

	private String trackNumber;
	private List<EventScheduleDto> morningSchedule;
	private List<EventScheduleDto> afternoonSchedule;

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}


	public List<EventScheduleDto> getMorningSchedule() {
		return morningSchedule;
	}

	public void setMorningSchedule(List<EventScheduleDto> morningSchedule) {
		this.morningSchedule = morningSchedule;
	}

	public List<EventScheduleDto> getAfternoonSchedule() {
		return afternoonSchedule;
	}

	public void setAfternoonSchedule(List<EventScheduleDto> afternoonSchedule) {
		this.afternoonSchedule = afternoonSchedule;
	}
	
	@Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("trackNumber", trackNumber)
                .add("morningSchedule", morningSchedule)
                .add("afternoonSchedule", afternoonSchedule)
                .toString();
    }
	
}
