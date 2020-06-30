package org.yenbo.leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * @author user
 *
 */
public class MinimumPathSum {

//	private int minValue = Integer.MAX_VALUE;
//	private int skip = 0;
	
	@Test
	public void test1() {
		Assert.assertEquals(0, minPathSum(null));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(3, minPathSum(new int[][] {
			{1,2},
			{1,1}
			}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(7, minPathSum(new int[][] {
			{1,3,1},
			{1,5,1},
			{4,2,1}
			}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(47, minPathSum(new int[][] {
			{1,4,8,6,2,2,1,7},
			{4,7,3,1,4,5,5,1},
			{8,8,2,1,1,8,0,1},
			{8,9,2,9,8,0,8,9},
			{5,7,5,7,1,8,5,5},
			{7,0,9,4,5,6,5,6},
			{4,9,9,7,9,1,9,0}
			}));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(855, minPathSum(new int[][] {
			{0,3,8,5,5,1,5,3,3,6,7,5,9,4,6,5,6,8,2,4,2,5,5,3,7,4,8,5,0,2,5,2,5,5,7,2,6,3,5,1,9,4,8,8,9,5,6,7,5,0,3,9,6,9,2,5,5,2,0,8,4,7,0,2,2,0,4,1,3,2,2,4,6,1,5,7,8,1,7,3,1,0,4,9,1,6,4,9,8,6,7,2,3,9,6,8,9,3,9,4,7,3,9,3,6,4,3,4,5,2,9,8,2,3,8,4,9,4,3,9,1,2,4,4,1,0,4,3,5,5,7,2,9,6,8,5,0,1,2,7,3,1,8,7,5,8,1,6,2,6,8,3,8,4,0,2,6,4,5,2,0,2,4,9,1,2,6,3,5,8,3,0,2,1,8,9,9,1,5,1,8,5,5,8,9,5,0,6,1,7,8,1,2,4,2,3,7,9,8,2},
			{9,1,3,1,4,1,0,3,4,8,7,2,3,4,1,5,1,3,3,2,1,3,6,3,7,8,8,4,9,6,9,9,0,2,0,4,5,1,0,9,9,7,4,4,1,7,1,4,0,4,8,3,7,4,6,5,3,4,1,4,3,0,3,3,4,4,7,1,7,7,1,8,6,7,2,9,4,4,3,4,0,2,0,8,8,6,5,1,3,6,6,8,9,1,1,3,5,0,5,4,0,8,2,8,5,7,8,1,3,3,7,3,7,7,3,6,4,8,9,9,7,5,7,6,9,0,9,6,2,6,1,4,6,3,3,1,2,3,2,5,8,2,1,6,9,4,2,5,3,1,4,0,9,3,8,8,5,7,4,8,6,5,4,2,1,9,6,5,4,0,1,3,2,2,9,2,6,1,7,1,4,4,3,3,9,1,3,5,1,8,5,7,5,9,9,8,9,5,4,3},
			{0,3,8,5,5,1,5,3,3,6,7,5,9,4,6,5,6,8,2,4,2,5,5,3,7,4,8,5,0,2,5,2,5,5,7,2,6,3,5,1,9,4,8,8,9,5,6,7,5,0,3,9,6,9,2,5,5,2,0,8,4,7,0,2,2,0,4,1,3,2,2,4,6,1,5,7,8,1,7,3,1,0,4,9,1,6,4,9,8,6,7,2,3,9,6,8,9,3,9,4,7,3,9,3,6,4,3,4,5,2,9,8,2,3,8,4,9,4,3,9,1,2,4,4,1,0,4,3,5,5,7,2,9,6,8,5,0,1,2,7,3,1,8,7,5,8,1,6,2,6,8,3,8,4,0,2,6,4,5,2,0,2,4,9,1,2,6,3,5,8,3,0,2,1,8,9,9,1,5,1,8,5,5,8,9,5,0,6,1,7,8,1,2,4,2,3,7,9,8,2},
			{0,3,8,5,5,1,5,3,3,6,7,5,9,4,6,5,6,8,2,4,2,5,5,3,7,4,8,5,0,2,5,2,5,5,7,2,6,3,5,1,9,4,8,8,9,5,6,7,5,0,3,9,6,9,2,5,5,2,0,8,4,7,0,2,2,0,4,1,3,2,2,4,6,1,5,7,8,1,7,3,1,0,4,9,1,6,4,9,8,6,7,2,3,9,6,8,9,3,9,4,7,3,9,3,6,4,3,4,5,2,9,8,2,3,8,4,9,4,3,9,1,2,4,4,1,0,4,3,5,5,7,2,9,6,8,5,0,1,2,7,3,1,8,7,5,8,1,6,2,6,8,3,8,4,0,2,6,4,5,2,0,2,4,9,1,2,6,3,5,8,3,0,2,1,8,9,9,1,5,1,8,5,5,8,9,5,0,6,1,7,8,1,2,4,2,3,7,9,8,2},
			{0,3,8,5,5,1,5,3,3,6,7,5,9,4,6,5,6,8,2,4,2,5,5,3,7,4,8,5,0,2,5,2,5,5,7,2,6,3,5,1,9,4,8,8,9,5,6,7,5,0,3,9,6,9,2,5,5,2,0,8,4,7,0,2,2,0,4,1,3,2,2,4,6,1,5,7,8,1,7,3,1,0,4,9,1,6,4,9,8,6,7,2,3,9,6,8,9,3,9,4,7,3,9,3,6,4,3,4,5,2,9,8,2,3,8,4,9,4,3,9,1,2,4,4,1,0,4,3,5,5,7,2,9,6,8,5,0,1,2,7,3,1,8,7,5,8,1,6,2,6,8,3,8,4,0,2,6,4,5,2,0,2,4,9,1,2,6,3,5,8,3,0,2,1,8,9,9,1,5,1,8,5,5,8,9,5,0,6,1,7,8,1,2,4,2,3,7,9,8,2}
			}));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(7, minPathSum(new int[][] {
			{1,3,1},
			{1,5,1},
			{4,2,1}
		}));
	}
	
	public int minPathSum(int[][] grid) {
		
		// https://en.wikipedia.org/wiki/Dynamic_programming
		
	    if (grid == null || grid.length == 0) {
	        return 0;
	    }
	 
	    int width = grid[0].length;
	    int height = grid.length;
	 
	    int[][] dynamicProgramming = new int[height][width];
	    dynamicProgramming[0][0] = grid[0][0];    
	 
	    // initialize top row
	    for (int i = 1; i < width; i++) {
	        dynamicProgramming[0][i] = dynamicProgramming[0][i - 1] + grid[0][i];
	    }
	 
	    // initialize left column
	    for (int j = 1; j < height; j++) {
	        dynamicProgramming[j][0] = dynamicProgramming[j - 1][0] + grid[j][0];
	    }
	 
	    // fill up the dynamic programming table
	    for (int i = 1; i < height; i++) {
	    	
	        for (int j = 1; j < width; j++) {
	        	
	            if(dynamicProgramming[i-1][j] > dynamicProgramming[i][j-1]){
	                dynamicProgramming[i][j] = dynamicProgramming[i][j-1] + grid[i][j];
	            } else {
	                dynamicProgramming[i][j] = dynamicProgramming[i-1][j] + grid[i][j];
	            }
	        }
	    }
	 
	    return dynamicProgramming[height-1][width-1];
	}
	
//	public int minPathSumSlowVersion(int[][] grid) {
//        
//		// TODO fail on Time Limit Exceeded
//		
//		if (grid == null) {
//			return 0;
//		}
//		
//		findPath(grid, 0, 0, 0, grid[0].length, grid.length);
//		
//		System.out.println("skip: " + skip);
//		return minValue;
//    }
//	
//	private void findPath(int[][] grid, int i, int j, int sum, int width, int height) {
//		
//		int value = grid[i][j] + sum;
//		
//		if (value > minValue) {
//			skip++;
//			return;
//			
//		} else if (i == height - 1 && j == width - 1) {
//			
//			if (value < minValue) {
//				minValue = value;
//			}
//			
//		} else {
//		
//			if (i + 1 < height) {
//				findPath(grid, i + 1, j, value, width, height);
//			}
//			
//			if (j + 1 < width) {
//				findPath(grid, i, j + 1, value, width, height);
//			}
//		}
//	}
}
