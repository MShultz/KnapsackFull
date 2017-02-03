package shultz.algorithms.knapsack;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Knapsack {
	private final int ITEM_LOCATION = 0;
	private final int WEIGHT_LOCATION = 1;
	private final int VALUE_LOCATION = 2;
	private Reader fileReader;
	private int maxWeight, maxCount;

	public Knapsack(String fileName) throws FileNotFoundException {
		fileReader = new Reader(fileName);
	}

	public void calculate() {
		ArrayList<Item> startingList = populateStartingValues();
		List<Item> bestSack = best(startingList, maxWeight);
		printList(bestSack);
	}

	private ArrayList<Item> populateStartingValues() {
		ArrayList<Item> startingList = new ArrayList<Item>();
		maxWeight = Integer.parseInt(fileReader.getNextLine());
		maxCount = Integer.parseInt(fileReader.getNextLine());
		int current = 0;
		String[] currentItem = fileReader.getNextItem();
		while (currentItem != null && current < maxCount) {
			startingList.add(new Item(currentItem[ITEM_LOCATION], Integer.parseInt(currentItem[WEIGHT_LOCATION]),
					Integer.parseInt(currentItem[VALUE_LOCATION])));
			currentItem = fileReader.getNextItem();
			++current;
		}
		return startingList;
	}

	private void printList(List<Item> sack) {
		Collections.sort(sack);
		for (Item i : sack) {
			System.out.println(i);
		}
		System.out.println("Total Weight: " + getTotalWeight(sack));
		System.out.println("Total Value: $" + getTotalValue(sack));
	}

	private List<Item> best(List<Item> currentItems, int weightLeft) {
		List<Item> duplicate = new ArrayList<Item>(currentItems);
		List<Item> items = new ArrayList<Item>();
		Item nextItem = currentItems.get(0);
		if (duplicate.size() == 1) {
			if (nextItem.getWeight() <= weightLeft)
				items.add(nextItem);
			return items;
		} else {
			duplicate.remove(0);
			List<Item> firstSack = null;
			List<Item> secondSack = best(duplicate, weightLeft);
			if (weightLeft - nextItem.getWeight() >= 0) {
				firstSack = best(duplicate, weightLeft - nextItem.getWeight());
				firstSack.add(nextItem);
			}
			if (firstSack == null)
				return secondSack;
			else
				return getTotalValue(firstSack) > getTotalValue(secondSack) ? firstSack : secondSack;
		}
	}
	public int getTotalValue(List<Item> itemsContained){
		int total = 0;
		for(Item i: itemsContained){
			total += i.getValue();
		}
		return total;
	}

	public int getTotalWeight(List<Item> itemsContained){
		int total = 0;
		for(Item i: itemsContained){
			total += i.getWeight();
		}
		return total;
	}
}