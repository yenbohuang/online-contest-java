package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class SearchA2dMatrix {

	@Test
	public void test() {
		
		int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
		
		Assert.assertTrue(searchMatrix(matrix, 3));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		
		for (int[] row: matrix) {
			
			if (row[0] == target) {
				return true;
			} else if (row[0] > target) {
				return false;
			} else if (row[0] < target) {
				
				for (int n: row) {
					if (n == target) {
						return true;
					}
				}
			}
		}
		
		return false;
    }
}
