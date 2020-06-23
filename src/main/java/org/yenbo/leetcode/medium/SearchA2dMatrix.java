package org.yenbo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * @author user
 *
 */
public class SearchA2dMatrix {

	@Test
	public void test1() {
		
		int[][] matrix = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
				};
		
		Assert.assertTrue(searchMatrix(matrix, 3));
	}
	
	@Test
	public void test2() {
		
		int[][] matrix = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
				};
		
		Assert.assertFalse(searchMatrix(matrix, 13));
	}
	
	@Test
	public void test3() {
		
		int[][] matrix = {{}};
		
		Assert.assertFalse(searchMatrix(matrix, 1));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		
		for (int[] row: matrix) {
			
			if (row == null || row.length == 0) {
				continue;
			} else if (row[0] == target) {
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
