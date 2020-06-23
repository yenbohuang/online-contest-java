package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * @author user
 *
 */
public class MaximumSubarray {

	@Test
	public void test1() {
		Assert.assertEquals(6, maxSubArray(new int[] {-2,2,-3,4,-1,2,1,-5,3}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(6, maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE;
		int length = nums.length;
		
		for (int i = 0; i < length; i++) {
			
			int sum = 0;
			
			for (int j = i; j < length; j++) {
				
				sum += nums[j];
				
				if (sum > max) {
					max = sum;
				}
			}
		}
		
		return max;
    }
}
