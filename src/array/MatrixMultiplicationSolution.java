package array;

import java.util.List;
import java.util.ArrayList;

public class MatrixMultiplicationSolution {
	public int[][] multiply(int[][] mat1, int[][] mat2) {
		int m = mat1.length;
		int n = mat2[0].length;

		int[][] result = new int[m][n];

		List<List<IndexValuePair>> compressedMat1 = compressMatrix(mat1);
		List<List<IndexValuePair>> compressedMat2 = compressMatrix(mat2);


		for (int mat1Row = 0; mat1Row < m; ++mat1Row) {
			for (IndexValuePair idxValPair : compressedMat1.get(mat1Row)) {
				int mat1Col = idxValPair.getIndex();
				int element1 = idxValPair.getValue();

				for (IndexValuePair mat2Element : compressedMat2.get(mat1Col)) {
					int element2 = mat2Element.getValue();
					int mat2Col = mat2Element.getIndex();

					result[mat1Row][mat2Col] = result[mat1Row][mat2Col] + element1 * element2;
				}

			}
		}

		return result;
	}

	public List<List<IndexValuePair>> compressMatrix(int[][] matrix) {
		List<List<IndexValuePair>> compressedMatrix = new ArrayList<List<IndexValuePair>>();
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; ++i) {
			compressedMatrix.add(new ArrayList<IndexValuePair>());

			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] != 0) {
					compressedMatrix.get(i).add(new IndexValuePair(j, matrix[i][j]));
				}
			}
		}

		return compressedMatrix;
	}

	public class IndexValuePair {
		private int index;
		private int value;

		public IndexValuePair(int idx, int val) {
			this.index = idx;
			this.value = val;
		}

		public int getIndex() { return this.index; }

		public int getValue() { return this.value; }
	}
}
