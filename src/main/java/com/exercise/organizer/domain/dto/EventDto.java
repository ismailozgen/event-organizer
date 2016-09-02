package com.exercise.organizer.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Objects;

public class EventDto {

	private Integer id;
    
	@NotEmpty
	private String topic;
    
	private Integer duration;
	
    private Boolean lightning;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

    public Boolean getLightning() {
		return lightning;
	}
	public void setLightning(Boolean lightning) {
		this.lightning = lightning;
	}
	
	
	@Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("topic", topic)
                .add("duration", duration)
                .add("lightning", lightning)
                .toString();
    }
	

	
	
}
