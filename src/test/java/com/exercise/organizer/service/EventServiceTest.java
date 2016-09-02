package com.exercise.organizer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.exercise.organizer.domain.model.Event;
import com.exercise.organizer.util.EventFileDataOperations;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Mock
    private EventService eventService;
	
	@Test
	public void testIfFileExists() {
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		File f = new File(classLoader.getResource("testdata.txt").getFile());
		
		assertTrue(f.exists());
		
	}
	
	@Test
	public void testGetDataForBatchInsert() {
		
		List<Event> eventList = EventFileDataOperations.readEventListFromFile();
		
		assertEquals(eventList.size(), 19);
	}
	
}
