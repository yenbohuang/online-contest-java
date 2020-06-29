package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/two-sum/
 * @author user
 *
 */
public class TwoSum {

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[] {0,1}, twoSum(new int[] {2, 7, 11, 15}, 9));
	}
	
	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[] {1,2}, twoSum(new int[] {2,5,5,11}, 10));
	}
	
	public int[] twoSum(int[] nums, int target) {

		int size = nums.length;
		
		for (int i = 0; i < size; i++) {
			
			for (int j = i + 1; j < size; j++) {
				
				if (target == nums[i] + nums[j]) {
					return new int[] {i, j};
				}
			}
		}
		
		return null;
    }
}
