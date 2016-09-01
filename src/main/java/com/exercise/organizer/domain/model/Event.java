package com.exercise.organizer.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Event {

	private Integer id;
	private String topic;
	private Integer duration;
    
	protected Event() {
		
	}
	
    public Event(final String topic, final Integer duration) {
        this.topic = topic;
        this.duration = duration;
    }

	@Id
	@Column(name = "id", nullable = false, updatable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
    @Column(name = "topic", nullable = false)
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
    @Column(name = "duration", nullable = false)
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	
}
