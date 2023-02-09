package dsa_easy;

import array.PositionOfLargeGroupsSolution;

public class Program {
	public static void main(String[] args) {		
		String s = "xyzzz";

		var test = new PositionOfLargeGroupsSolution();

		var hi = test.largeGroupPositions(s);
		
		for (int i = 0; i < hi.size(); ++i) {
			System.out.println("l: " + hi.get(i).get(0) + " , r: " + hi.get(i).get(1));
		}

		return;
	}
}
