package dsa_easy;

import array.SpiralOrderSolution;

public class Program {
	public static void main(String[] args) {
		// [[2,5,8],[4,0,-1]]
		int[][] matrix = new int[][] {
			new int[] {2,5,8},
			new int[] {4,0,-1},
		};
		var test = new SpiralOrderSolution();
		
		test.spiralOrder(matrix);
		
		// [ [1,2,3],
		//   [4,5,6],
		//   [7,8,9]
		// ]
	}
}
