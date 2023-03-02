package dsa_easy;

import array.WordPatternSolution;

public class Program {
	public static void main(String[] args) {
		WordPatternSolution wps = new WordPatternSolution();
		boolean test = wps.wordPattern("abba", "dog dog dog dog");

		System.out.println("match up?: " + (test ? "YES!" : "NO!"));
		// a=>dog
		// b=>cat
		// b=>cat
		// 
		return;
	}
}
