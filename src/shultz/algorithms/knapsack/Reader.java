package shultz.algorithms.knapsack;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
	private BufferedReader file = null;	

	public Reader(String fileName) throws FileNotFoundException{
		initializeReader(fileName);
	}

	private void initializeReader(String fileName) throws FileNotFoundException {
			FileInputStream inputStream = new FileInputStream(fileName);
			file = new BufferedReader(new InputStreamReader(inputStream));
	}

	public String getNextLine() {
		String currentLine = null;
		try {
			if (file.ready()) {
				currentLine = file.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return currentLine;
	}
	public String[] getNextItem(){
		return splitString(getNextLine());
	}
	private String[] splitString(String currentLine){
		String[] output;
		try{
			output = currentLine.split(",");
		}catch (NullPointerException ex){
			output = null;
		}
		return output;
	}
	
	public void closeReader(){
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("Error: Unable to propperly close input file.");
		}
	}
}
