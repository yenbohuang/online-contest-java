package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingContinuousSubsequence {

	@Test
	public void test1() {
		Assert.assertEquals(4, longestIncreasingContinuousSubsequence(
				new int[] {5, 4, 2, 1, 3}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(4, longestIncreasingContinuousSubsequence(
				new int[] {5, 1, 2, 3, 4}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(0, longestIncreasingContinuousSubsequence(
				new int[] {}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(1, longestIncreasingContinuousSubsequence(
				new int[] {1}));
	}
	
	public int longestIncreasingContinuousSubsequence(int[] A) {
        
		int answer = 0;
		int size = A.length;
		
		if (size < 2) {
			answer = size;
		} else {
			
			int increasing = 1;
			int decreasing = 1;
			
			for (int i = 1; i < size; i++) {
				
				if (A[i] >= A[i - 1]) {
					
					increasing++;
					
					if (answer < increasing) {
						answer = increasing;
					}
				} else {
					increasing = 1;
				}
				
				if (A[i] <= A[i - 1]) {
					
					decreasing++;
					
					if (answer < decreasing) {
						answer = decreasing;
					}
					
				} else {
					decreasing = 1;
				}
			}
		}
		
		return answer;
    }
}
