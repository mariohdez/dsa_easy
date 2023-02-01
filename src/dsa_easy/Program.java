package dsa_easy;

import array.GameOfLife;

public class Program {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			new int[] {0,1,0},
			new int[] {0,0,1},
			new int[] {1,1,1},
			new int[] {0,0,0},
		};

		var test = new GameOfLife();

		test.gameOfLife(matrix);
		
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}
	}
}
