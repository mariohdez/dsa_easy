package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class CandyCrushSolution {
	private int rows;
	private int cols;
	private int[][] board;

	public int[][] candyCrush(int[][] board) {
		this.board = board;
		this.rows = board.length;
		this.cols = board[0].length;

		Set<Point> candiesToCrush = null;

		while (true) {
			candiesToCrush = getCandiesToCrush();

			if (candiesToCrush.size() == 0) break;

			for (Point p : candiesToCrush) {
				this.board[p.getRow()][p.getCol()] = 0;
			}

			performGravity();
		}

		return board;
	}

	public Set<Point> getCandiesToCrush() {
		Set<Point> crushedCandies = new HashSet<Point>();

		for (int r = 0; r < this.rows; ++r) {
			for (int c = 0; c < this.cols; ++c) {
				Point curPoint = new Point(r, c);
				if (crushedCandies.contains(curPoint))
					continue;

				int horizontalGroupLength = getHorizontalGroupLength(this.board[r][c], r, c);

				if (horizontalGroupLength >= 3) {
					for (int curCol = c; curCol < c + horizontalGroupLength; ++curCol) {
						crushedCandies.add(new Point(r, curCol));
					}
 				}

				int verticalGroupLength = getVerticalGroupLength(this.board[r][c], r, c);

				if (verticalGroupLength >= 3) {
					for (int curRow = r; curRow < r + verticalGroupLength; ++curRow) {
						crushedCandies.add(new Point(curRow, c));
					}
				}
			}
		}

		return crushedCandies;
	}

	public int getHorizontalGroupLength(int candyType, int curRow, int curCol) {
		if (candyType == 0) return 0;

		int forwardsCol = curCol;

		while (forwardsCol < this.cols && this.board[curRow][forwardsCol] == candyType) {
			++forwardsCol;
		}

		return forwardsCol - curCol;
	}

	public int getVerticalGroupLength(int candyType, int curRow, int curCol) {
		if (candyType == 0) return 0;

		int forwardsRow = curRow;

		while (forwardsRow < this.rows && this.board[forwardsRow][curCol] == candyType) {
			++forwardsRow;
		}

		return forwardsRow - curRow;
	}

	public void performGravity() {
		for (int c = 0; c < this.cols; ++c) {
			if (isEligableColumn(c)) {
				List<Integer> nonEmptyCandiesInColumn = new ArrayList<Integer>();

				for (int r = 0; r < this.rows; ++r) {
					if (this.board[r][c] != 0) {
						nonEmptyCandiesInColumn.add(this.board[r][c]);
					}
				}

				int rowInEligableColumn = this.rows - 1;
				int nonEmptyPointsInColumnPointer = nonEmptyCandiesInColumn.size() - 1;

				while (nonEmptyPointsInColumnPointer > -1) {
					this.board[rowInEligableColumn][c] = nonEmptyCandiesInColumn.get(nonEmptyPointsInColumnPointer);
					--nonEmptyPointsInColumnPointer;
					--rowInEligableColumn;
				}

				while (rowInEligableColumn > -1) {
					this.board[rowInEligableColumn][c] = 0;
					--rowInEligableColumn;
				}
			}
		}
	}

	public boolean isEligableColumn(int col) {
		for (int r = 1; r < this.rows; ++r) {
			if (this.board[r][col] == 0 && this.board[r - 1][col] != 0) {
				return true;
			}
		}
	}

	public class Point {
		private int row;
		private int col;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}

		public int getRow() { return this.row; }

		public int getCol() { return this.col; }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.row;
			result = prime * result + this.col;

			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (this.row != other.getRow())
				return false;
			if (this.col != other.getCol())
				return false;
			return true;
		}
	}
}
