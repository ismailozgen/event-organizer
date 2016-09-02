package com.exercise.organizer.util;

import java.util.ArrayList;
import java.util.List;

import com.exercise.organizer.service.EventSchedulerService;

public class EventDurationFinder {

	private List<Integer> listOfDurations = new ArrayList<Integer>();
	
	private List<Integer> inputDurationsList;

	private boolean isAfternoon;
	private boolean flag = false;

	private int[] selectedDurations;
	private int targetDuration;
	private int inputDurationCount;

	public List<Integer> findDurations(List<Integer> inputDurationsList, int targetDuration, boolean isAfternoon) {
		
		this.isAfternoon = isAfternoon;
		this.inputDurationsList = inputDurationsList;
		this.inputDurationCount = inputDurationsList.size();
		this.targetDuration = targetDuration;

		selectedDurations = new int[inputDurationCount];

		int totalDuration = 0;
		
		for(int element : inputDurationsList){
			totalDuration += element;
		}
		
		findDurations(0, 0, totalDuration);
		
		return listOfDurations;
		
	}

	private void findDurations(int currentSum, int index, int remainingSum) {
		
		if (flag) {
			return;
		}
		
		selectedDurations[index] = 1; 
		
		int currentTotal = inputDurationsList.get(index) + currentSum;
		
		if (!isAfternoon) {
			if (targetDuration == currentTotal) {
				getDurations();
				return;
			}
		} else {
			if (targetDuration + EventSchedulerService.EXTENSION_DURATION >= currentTotal && currentTotal >= targetDuration) {
				getDurations();
				return;
			}
		}
		
		if (isAfternoon){
			
			if ((index + 1 < inputDurationCount) && (currentSum + inputDurationsList.get(index) + inputDurationsList.get(index+1) <= targetDuration + EventSchedulerService.EXTENSION_DURATION)) {
				findDurations(currentSum + inputDurationsList.get(index), index + 1, remainingSum - inputDurationsList.get(index));
			}
	
			selectedDurations[index] = 0;
	
			if ((index + 1 < inputDurationCount) && (currentSum + inputDurationsList.get(index+1) <= targetDuration + EventSchedulerService.EXTENSION_DURATION)
					&& (currentSum + remainingSum - inputDurationsList.get(index) >= targetDuration + EventSchedulerService.EXTENSION_DURATION )) {
				findDurations(currentSum, index + 1, remainingSum - inputDurationsList.get(index));
			}
			
			
		} else {
		

			if ((index + 1 < inputDurationCount) && (currentSum + inputDurationsList.get(index) + inputDurationsList.get(index+1) <= targetDuration)) {
				findDurations(currentSum + inputDurationsList.get(index), index + 1, remainingSum - inputDurationsList.get(index));
			}
	
			selectedDurations[index] = 0;
	
			if ((index + 1 < inputDurationCount) && (currentSum + inputDurationsList.get(index+1) <= targetDuration)
					&& (currentSum + remainingSum - inputDurationsList.get(index) >= targetDuration)) {
				findDurations(currentSum, index + 1, remainingSum - inputDurationsList.get(index));
			}
		
		}
	}

	private void getDurations() {
		flag = true;
		for (int i = 0; i < inputDurationCount; i++) {
			if (selectedDurations[i] == 1) {
				listOfDurations.add(inputDurationsList.get(i));
			}
		}
	}

	
}
