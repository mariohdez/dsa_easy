package dsa_easy;

import array.CompareVersionsSolution;

public class Program {
	public static void main(String[] args) {
		/*
		 * 
"1.01"
"1.001"
		 * 
		 * */
		String v1 = "1.01";
		String v2 = "1";

		var test = new CompareVersionsSolution();

		var hi = test.compareVersion(v1,v2);
		
		System.out.println("roman: " + hi);
		return; // LVIII
	}
}
