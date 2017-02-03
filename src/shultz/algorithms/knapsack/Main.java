package shultz.algorithms.knapsack;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		try{
		Knapsack sack = new Knapsack(args[0]);
		sack.calculate();
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Unknown Error: exiting program");
		} catch (FileNotFoundException e) {
			System.out.print("Error: Unable to find file; exiting program");
		}
	}

}
