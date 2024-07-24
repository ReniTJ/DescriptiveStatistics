package reni;

import java.util.*;

public class Calc {
	
	
	//Mean Calculation
	public static double mean(int[] data) {
		double m = 0;
		int sum = 0;
		for (int value : data) {
			sum += value;	//Adds each value in the row
		}
		
		m=(sum/data.length);
				
	return m;
			
	}
			
	
	//Max Calculation
	public static int max(int[] data) {
		int mx = 0;
		int maxnum = data[0];
		for (int value : data) {
			if (maxnum < value) {
				maxnum = value;	
			}
		}
			
		mx = maxnum;
			
	return mx;
			
	}
	
	//Min Calculation
	public static int min(int[] data) {
		int mn = 0;
		int minnum = data[0];
		for (int value : data) {
			if (minnum > value) {
				minnum = value;
			}
		}
		
		mn = minnum;
				
	return mn;
		
	}
	
	//Standard Deviation Calculation
	public static double standdev(int[] data) {
		double m = Calc.mean(data);
		double variance = 0;
		double var = 0;
		int variance_s = 0; 	//Variance Sum
		for (int value : data) {
			variance_s += Math.pow((value-m),2);
		
		}
		variance = Math.pow((variance_s/data.length),0.5);
		
	return variance;
	
	}
	
	
	//Skewness Calculation
	public static double skew(int[] data) {
		double m = Calc.mean(data);
		double sd = Calc.standdev(data);
		double sk = 0;
		double sk_s = 0;
		for (int value : data) {
			sk_s += Math.pow(((value-m)/sd),3);
		
		}
		sk = sk_s/data.length;
		
	return sk;
	
	}
	
	//Kurtosis Calculation
	public static double kurt(int[] data) {
		double m = Calc.mean(data);
		double sd = Calc.standdev(data);
		double kt = 0;
		double kt_s = 0;
		for (int value : data) {
			kt_s += Math.pow(((value-m)/sd),4);
		
		}
		kt = (kt_s/data.length)-3;
		
	return kt;
	}
	
}