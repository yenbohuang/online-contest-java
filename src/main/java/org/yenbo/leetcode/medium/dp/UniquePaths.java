package org.yenbo.leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/unique-paths/
 * @author user
 *
 */
public class UniquePaths {

	@Test
	public void test1() {
		Assert.assertEquals(3, uniquePaths(3, 2));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(28, uniquePaths(7, 3));
	}
	
	public int uniquePaths(int m, int n) {
        
		// https://en.wikipedia.org/wiki/Dynamic_programming
		int[][] array = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			array[i][0] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			array[0][i] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				array[i][j] = array[i-1][j] + array[i][j-1];
			}
		}
		
		return array[m-1][n-1];
    }
}
