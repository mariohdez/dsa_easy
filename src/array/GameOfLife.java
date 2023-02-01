package array;

public class GameOfLife {
/*
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
	public void gameOfLife(int[][] board) {
		int[][] tempBoard = new int[board.length][board[0].length];

		for (int r = 0; r < board.length; ++r) {
			for (int c = 0; c < board[0].length; ++c) {
				int liveNeighbors = getNumberOfLiveNeighbors(board, r, c);

				if (board[r][c] == 1) {
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						tempBoard[r][c] = 0;
					} else {
						tempBoard[r][c] = 1;
					}
				} else {
					if (liveNeighbors == 3) {
						tempBoard[r][c] = 1;
					}
				}
			}
		}

		for (int r = 0; r < board.length; ++r) {
			for (int c = 0; c < board[0].length; ++c) {
				board[r][c] = tempBoard[r][c];
			}
		}
	}

	public int getNumberOfLiveNeighbors(int[][] board, int row, int col) {
		int numberOfLiveNeighbors = 0;

		int[][] directions = new int[][] { new int[]{ -1, 0 },  new int[]{ 1, 0 },  new int[]{ 0, -1 }, new int[]{ 0, 1 },
						   new int[]{ -1, -1 }, new int[]{ -1, 1 }, new int[]{ 1, -1 }, new int[]{ 1, 1 }};

		for (int[] direction : directions) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];

			if (!isValidSpot(newRow, newCol, board.length, board[0].length)) {
				continue;
			}

			if (board[newRow][newCol] == 1) {
				numberOfLiveNeighbors++;
			}
			
		}

		return numberOfLiveNeighbors;
	}

	public boolean isValidSpot(int row, int col, int numberOfRows, int numberOfColumns) {
		return row >= 0 && row < numberOfRows && col >= 0 && col < numberOfColumns;
	}
}
