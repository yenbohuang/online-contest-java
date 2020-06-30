package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * @author user
 *
 */
public class LongestIncreasingContinuousSubsequence {

	@Test
	public void test1() {
		Assert.assertEquals(0, findLengthOfLCIS(
				new int[] {}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, findLengthOfLCIS(
				new int[] {1}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(3, findLengthOfLCIS(
				new int[] {1,3,5,4,7}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(1, findLengthOfLCIS(
				new int[] {2,2,2,2,2}));
	}
	
	public int findLengthOfLCIS(int[] nums) {
        
		int answer = 1;
		int size = nums.length;
		
		if (size < 2) {
			answer = size;
		} else {
			
			int tmp = 1;
			
			for (int i = 0; i < size - 1; i++) {
				
				if (nums[i + 1] > nums[i]) {
					tmp ++;
				} else {
					tmp = 1;
				}
				
				if (tmp > answer) {
					answer = tmp;
				}
			}
		}
		
		return answer;
    }
}
