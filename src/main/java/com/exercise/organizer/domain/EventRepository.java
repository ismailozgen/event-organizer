package com.exercise.organizer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.organizer.domain.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
