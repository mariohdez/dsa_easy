package array;

import java.util.List;
import java.util.ArrayList;

public class SpiralOrderSolution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiralOrder = new ArrayList<Integer>();
		int left = 0;
		int right = matrix[0].length;
		int top = 0;
		int bottom = matrix.length;

		while (left < right && top < bottom) {
			// left to right.
			for (int c = left; c < right; ++c) {
				spiralOrder.add(matrix[top][c]);
			}

			top++;

			// top to bottom
			for (int r = top; r < bottom; ++r) {
				spiralOrder.add(matrix[r][right - 1]);
			}

			right--;

			if (!(left < right && top < bottom)) {
				break;
			}

			// right to left
			for (int c = right - 1; c >= left; --c) {
				spiralOrder.add(matrix[bottom - 1][c]);
			}

			bottom--;

			// bottom to top
			for (int r = bottom - 1; r >= top; --r) {
				spiralOrder.add(matrix[r][left]);
			}

			left++;

		}

		return spiralOrder;
	}
}
