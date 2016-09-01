package com.exercise.organizer.util;

import java.util.ArrayList;
import java.util.List;

public class EventDurationFinder {

	private List<Integer> listOfDurations = new ArrayList<Integer>();
	
	private boolean flag = false;
	private boolean isAfternoon;
	private List<Integer> inputDurationsList;
	private int[] selectedElements;
	private int targetSum;
	private int numOfElements;

	public List<Integer> findDurationsForSum(List<Integer> inputDurationsList, int targetSum, boolean isAfternoon) {
		
		this.inputDurationsList = inputDurationsList;
		this.numOfElements = inputDurationsList.size();
		this.targetSum = targetSum;
		this.isAfternoon = isAfternoon;
		selectedElements = new int[numOfElements];

		int sumOfAllElements = 0;
		for(int element : inputDurationsList){
			sumOfAllElements += element;
		}
		findDurationsForSum(0, 0, sumOfAllElements);
		
		return listOfDurations;
		
	}

	private void findDurationsForSum(int sumTillNow, int index, int sumOfRemaining) {
		
		if (flag) {
			return;
		}
		
		selectedElements[index] = 1; 
		
		int currentSum = inputDurationsList.get(index) + sumTillNow;
		
		if (!isAfternoon) {
			if (targetSum == currentSum) {
				getDurations();
				return;
			}
		} else {
			if (targetSum + 60 >= currentSum && currentSum >= targetSum) {
				getDurations();
				return;
			}
		}

		if ((index + 1 < numOfElements) && (sumTillNow + inputDurationsList.get(index) + inputDurationsList.get(index+1) <= targetSum)) {
			findDurationsForSum(sumTillNow + inputDurationsList.get(index), index + 1, sumOfRemaining - inputDurationsList.get(index));
		}

		selectedElements[index] = 0;

		if ((index + 1 < numOfElements) && (sumTillNow + inputDurationsList.get(index+1) <= targetSum)
				&& (sumTillNow + sumOfRemaining - inputDurationsList.get(index) >= targetSum)) {
			findDurationsForSum(sumTillNow, index + 1, sumOfRemaining - inputDurationsList.get(index));
		}
	}

	private void getDurations() {
		flag = true;
		for (int i = 0; i < numOfElements; i++) {
			if (selectedElements[i] == 1) {
				listOfDurations.add(inputDurationsList.get(i));
			}
		}
	}

	
}
