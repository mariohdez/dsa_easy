package array;

public class CandyCrushSolution {

	public int[][] candyCrush(int[][] board) {
		int numberOfRows = board.length;
		int numberOfCols = board[0].length;
		boolean todo = false;

		// Crush.

		// Crush horizontally.
		for (int row = 0; row < numberOfRows; ++row) {
			for (int col = 0; col + 2 < numberOfCols; ++col) {
				int candy = Math.abs(board[row][col]);

				if (candy != 0 && candy == Math.abs(board[row][col + 1]) && candy == Math.abs(board[row][col + 2])) {
					board[row][col] = board[row][col + 1] = board[row][col + 2] = -candy;
					todo = true;
				}
			}
		}

		// Crush vertically.
		for (int row = 0; row + 2 < numberOfRows; ++row) {
			for (int col = 0; col < numberOfCols; ++col) {
				int candy = Math.abs(board[row][col]);

				if (candy != 0 && candy == Math.abs(board[row + 1][col]) && candy == Math.abs(board[row + 2][col])) {
					board[row][col] = board[row + 1][col] = board[row + 2][col] = -candy;
					todo = true;
				}
			}
		}

		// Gravity.
		for (int col = 0; col < numberOfCols; ++col) {
			int readPtr = numberOfRows - 1;
			int writePtr = numberOfRows - 1;
			
			while (readPtr > -1) {
				if (board[readPtr][col] > 0) {
					board[writePtr][col] = board[readPtr][col];
					writePtr--;
				}
				readPtr--;
			}
			
			while (writePtr > -1) {
				board[writePtr][col] = 0;
				writePtr--;
			}
		}

		return todo ? candyCrush(board) : board;
	}
}
