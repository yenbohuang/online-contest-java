package org.yenbo.leetcode.todo.missing;

import org.junit.Assert;
import org.junit.Test;

public class MatrixZigzagTraversal {
	
	@Test
	public void test1() {
		
		int[][] matrix = new int[][] {
		  {1, 2, 3, 4}, {5, 6, 7, 8}, {9,10, 11, 12}};
		
		Assert.assertArrayEquals(new int[] {1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12},
				printZMatrix(matrix));
	}
	
	@Test
	public void test2() {
		
		int[][] matrix = new int[][]{{1},{2},{3},{4},{5},{6},{9},{8},{7}};
		
		Assert.assertArrayEquals(new int[] {1,2,3,4,5,6,9,8,7},
				printZMatrix(matrix));
	}
	
	public int[] printZMatrix(int[][] matrix) {
        
		if (matrix == null || matrix.length == 0) {
			return null;
		}
		
		final int EAST = 0;
		final int SOUTH_WEST = 1;
		final int SOUTH = 2;
		final int NORTH_EAST = 3;
		
		int width =  matrix[0].length;
		int height = matrix.length;
		int size = width * height;
		
		int[] answer = new int[size];
		
		if (width == 1) {
			
			for (int i = 0; i < height; i++) {
				answer[i] = matrix[i][0];
			}
			
			return answer;
			
		} else if (height == 1) {
			
			for (int i = 0; i < width; i++) {
				answer[i] = matrix[0][i];
			}
			
			return answer;
		}
		
		int xMove = 0;
		int yMove = 0;
		int direction = EAST;
		
		for (int i = 0; i < size; i++) {
			
			answer[i] = matrix[yMove][xMove];
			
			switch(direction) {
			case EAST:
				xMove++;
				
				if (xMove - 1 >= 0 && yMove + 1 < height) {
					direction = SOUTH_WEST;
				} else if (xMove + 1 < width && yMove - 1 >= 0) {
					direction = NORTH_EAST;
				}
				
				break;
			case SOUTH_WEST:
				yMove++;
				xMove--;
				
				if (xMove - 1 >= 0 && yMove + 1 < height) {
					direction = SOUTH_WEST;
				} else if (yMove + 1 < height) {
					direction = SOUTH;
				} else if (xMove + 1 < width) {
					direction = EAST;
				}
				
				break;
			case SOUTH:
				yMove++;
				
				if (xMove + 1 < width && yMove - 1 >= 0) {
					direction = NORTH_EAST;
				} else if (xMove - 1 >= 0 && yMove + 1 < height) {
					direction = SOUTH_WEST;
				}
				
				break;
			case NORTH_EAST:
				yMove--;
				xMove++;
				
				if (xMove + 1 < width && yMove - 1 >= 0) {
					direction = NORTH_EAST;
				} else if (xMove + 1 < width) {
					direction = EAST;
				} else if (yMove + 1 < height) {
					direction = SOUTH;
				}
				
				break;
			}
		}
		
		return answer;
    }
}
