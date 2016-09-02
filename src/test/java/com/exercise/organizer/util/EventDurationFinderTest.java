package com.exercise.organizer.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class EventDurationFinderTest {

	@Test
	public void testDurationFinderForMorning() {
		
		int targetDuration = 180;
		
		List<Integer> sourceDurationList = Arrays.asList(45,15,60,90,15,90,60,90,30,5,5,15,45);
		
		List<Integer> targetDurationList = new EventDurationFinder().findDurations(sourceDurationList, 180, false);
		
		int sum = 0;
		for (Integer i : targetDurationList) {
			sum += i;
		}
		
		assertEquals("invalid sum of duration (morning)",sum,targetDuration);
		
	}
	
	@Test
	public void testDurationFinderForAfternoon() {
		
		int targetDurationFloor = 180;
		int targetDurationCeiling = 240;

		
		List<Integer> sourceDurationList = Arrays.asList(45,15,60,90,15,90,60,90,30,5,5,15,45);
		
		List<Integer> targetDurationList = new EventDurationFinder().findDurations(sourceDurationList, 180, true);
		
		int sum = 0;
		for (Integer i : targetDurationList) {
			sum += i;
		}
		
		assertTrue("invalid sum of duration in the afternoon", sum >= targetDurationFloor && sum <= targetDurationCeiling);
		
		
	}
	
}
