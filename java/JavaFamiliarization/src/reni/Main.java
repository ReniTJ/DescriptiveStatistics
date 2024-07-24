package reni;

import java.io.*;
import java.util.*;

public class Main {

	//Main Method
	public static void main(String[] args) {
		
		String inputfilename = "/Users/reni/eclipse-workspace/JavaFamiliarization/data/InputFile.csv";		//Declaring String variable for the file
		String outputfilename = "/Users/reni/eclipse-workspace/JavaFamiliarization/data/OutputFile.csv";
		
		System.out.print("Input File: ");
		System.out.println(inputfilename);
		System.out.print("Output File: ");
		System.out.println(outputfilename);
		
		List<int[]> allData = new ArrayList<>(); //Create a List of Int
		String[] headers = null;
		
		BufferedReader inputfile = null;	//Buffering characters provide for the efficient reading of characters
		String line = "";	//Read each line of file
		
		FileWriter fileWriter = null;
        PrintWriter writer = null;
		
		try {
			inputfile = new BufferedReader(new FileReader(inputfilename));
			fileWriter = new FileWriter("output.csv");
            writer = new PrintWriter(fileWriter);
			
			if ((line = inputfile.readLine()) != null) {	//Read the header
				headers = line.split(",");
			}
			
			while ((line = inputfile.readLine()) != null) {
				String[] stringNumbers = line.split(",");
				int[] intNumbers = new int[stringNumbers.length];
				
				for (int i = 0; i < stringNumbers.length; i++) {
					intNumbers[i] = Integer.parseInt(stringNumbers[i].trim()); //Turning the String to int
				}
				
				allData.add(intNumbers);
			}
			
			// Print all the data
			//PrintList(allData);
            
            // Transposing the List<int[]>
            List<int[]> transposedData = transposeList(allData);
            
            // Print the transposed data 
            //PrintList(transposedData);
            
            //Output Header
            writer.println(" ,Mean,Max,Min,StdDev,Skewness,Kurtosis");
            System.out.println("\n    ,Mean,Max,Min,StdDev,Skewness,Kurtosis");
            
            int i = 0;
            for (int[] row : transposedData) {
            	
            	// Calculate Mean
            	double m = Calc.mean(row);
            	
            	//Calculate Max
            	int mx = Calc.max(row);
            	
            	//Calculate Min
            	int mn = Calc.min(row);
            	
            	//Calculate Standard Deviation
            	double varfin = Calc.standdev(row);
            	
            	//Calculate Skewness
            	double skewness = Calc.skew(row); 
            	
            	//Calculate Standard Deviation
            	double kurt = Calc.kurt(row); 
            	
            	//All Results in One String
            	String rowout = String.format("%s,%f,%d,%d,%f,%f,%f",headers[i],m, mx, mn, varfin, skewness, kurt);
            	
            	// Write output file
                writer.println(rowout);
                
                // Print the combined array
                System.out.println(rowout);
                
                i++;
            	
            } 
            
 
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputfile != null) {
                    inputfile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if (writer != null) {
                writer.close();
            }
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	// Transpose Method
	public static List<int[]> transposeList(List<int[]> data) {

        int rows = data.size();
        int columns = data.get(0).length;

        int[][] matrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            int[] row = data.get(i);
            for (int j = 0; j < columns; j++) {
                matrix[j][i] = row[j];
            }
        }

        List<int[]> transposedData = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            int[] transposedRow = new int[rows];
            for (int j = 0; j < rows; j++) {
                transposedRow[j] = matrix[i][j];
            }
            transposedData.add(transposedRow);
        }

        return transposedData;
    }
	
	//Print List Method
	public static void PrintList(List<int[]> data) {
		for (int[] row : data) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
	}
	
}
		
		