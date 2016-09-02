package com.exercise.organizer.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exercise.organizer.domain.model.Event;
import com.exercise.organizer.domain.model.LightningPresentationEvent;
import com.exercise.organizer.domain.model.PresentationEvent;

public class EventFileDataOperations {

	
	public static List<Event> readEventListFromFile() {

		List<Event> eventList = new ArrayList<Event>();
		
		ClassLoader classLoader = EventFileDataOperations.class.getClassLoader();
		
		File dataFile = new File(classLoader.getResource("testdata.txt").getFile());

		try (Scanner scanner = new Scanner(dataFile)) {

			while (scanner.hasNext()){
				
				Event event ;
				
				String line = scanner.nextLine();

				String[] lineAsArr = line.split(",");

				String eventName = lineAsArr[0].trim();
				String durationStr = lineAsArr[1].trim();
				
				if (durationStr.equalsIgnoreCase("lightning")) {
					event = new LightningPresentationEvent(eventName);
				} else {
					event = new PresentationEvent(eventName,Integer.parseInt(durationStr));
				}
				
				eventList.add(event);
				
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return eventList;
	}
}
