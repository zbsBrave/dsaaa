package letcode.day;

/*
 * ����ת
 * ��վ��https://leetcode-cn.com/problems/rotate-matrix-lcci/
 */
public class Day07 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		//���Ƚ��������·�ת
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][j];
				matrix[n-i-1][j] = temp;
			}
		}
		//���Ž������ضԽ��߷�ת
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
