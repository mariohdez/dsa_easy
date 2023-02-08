package dsa_easy;

import array.MatrixMultiplicationSolution;

public class Program {
	public static void main(String[] args) {		
		int[][] mat1 = new int[][] { new int[] {1, 0, 0}, new int[] {-1,0,3} };
		int[][] mat2 = new int[][] { new int[] {7, 0, 0}, new int[] {0, 0, 0}, new int[] {0, 0, 1} };

		var test = new MatrixMultiplicationSolution();

		var hi = test.multiply(mat1, mat2);

		for (int i = 0; i < hi.length; ++i) {
			for (int j = 0; j < hi[0].length; ++j) {
				System.out.print(hi[i][j]);
				if (j + 1 != hi[0].length) {
					 System.out.print(", ");
				}
			}
			System.out.println();
		}

		return;
	}
}
