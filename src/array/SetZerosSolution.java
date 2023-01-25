package array;

public class SetZerosSolution {

	private int rows = 0;
	private int columns = 0;

	public void setZeroes(int[][] matrix) {
		this.rows = matrix.length;
		this.columns = matrix[0].length;
		boolean shouldZerothRowBeZero = false;

		for (int row = 0; row < this.rows; ++row) {
			for (int column = 0; column < this.columns; ++column) {
				if (matrix[row][column] == 0) {
					if (row == 0) {
						shouldZerothRowBeZero = true;
					} else {
						matrix[row][0] = 0;
					}

					matrix[0][column] = 0;
				}
			}
		}

		for (int row = 1; row < this.rows; ++row) {
			if (matrix[row][0] == 0) {
				setRowToZero(matrix, row);
			}
		}

		for (int column = 0; column < this.columns; ++column) {
			if (matrix[0][column] == 0) {
				setColumnToZero(matrix, column);
			}
		}

		if (shouldZerothRowBeZero) {
			setRowToZero(matrix, 0);
		}
	}

	public void setRowToZero(int[][] matrix, int row) {
		for (int column = 0; column < this.columns; ++column) {
			matrix[row][column] = 0;
		}
	}

	public void setColumnToZero(int[][] matrix, int column) {
		for (int row = 0; row < this.rows; ++row) {
			matrix[row][column] = 0;
		}
	}
}

