package shultz.algorithms.knapsack;

public class Item implements Comparable<Item>{
	private String itemName;
	private int weight, value;


	public Item(String itemName, int weight, int value) {
		this.setItemName(itemName);
		this.setWeight(weight);
		this.setValue(value);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return itemName + ":\tWeight = " + weight + "\tValue = $" + value;
	}

	@Override
	public int compareTo(Item o) {
		return this.itemName.compareTo(o.getItemName());
	}

	

}
