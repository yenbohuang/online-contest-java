package org.yenbo.leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * @author user
 *
 */
public class UniquePaths2 {

	@Test
	public void test1() {
		Assert.assertEquals(2, uniquePathsWithObstacles(new int[][] {
			{0,0,0},
			{0,1,0},
			{0,0,0}
			}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(3, uniquePathsWithObstacles(new int[][] {
			{0,0},
			{0,0},
			{0,0},
			{1,0},
			{0,0}
			}));
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
		// https://en.wikipedia.org/wiki/Dynamic_programming
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] array = new int[m][n];
		
		if (obstacleGrid[0][0] == 0) {
			array[0][0] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			
			if (obstacleGrid[i-1][0] == 1) {
				// re-label impossible moves
				obstacleGrid[i][0] = 1;
			}
			
			if (obstacleGrid[i][0] == 0) {
				array[i][0] = 1;
			}
		}
		
		for (int i = 1; i < n; i++) {
			
			if (obstacleGrid[0][i-1] == 1) {
				// re-label impossible moves
				obstacleGrid[0][i] = 1;
			}
			
			if (obstacleGrid[0][i] == 0) {
				array[0][i] = 1;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				
				if (obstacleGrid[i][j] == 0) {
					array[i][j] = array[i-1][j] + array[i][j-1];
				} else {
					array[i][j] = 0;
				}
			}
		}
		
		return array[m-1][n-1];
    }
}
