package org.yenbo.lintcode.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Median {

	@Test
	public void test1() {
		Assert.assertEquals(3, median(new int[] {4, 5, 1, 2, 3}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(5, median(new int[] {7, 9, 4, 5}));
	}
	
	public int median(int[] nums) {
        
		Arrays.sort(nums);
		
		if (nums.length % 2 == 0) {
			return nums[nums.length / 2 - 1];
		} else {
			return nums[nums.length / 2];
		}
    }
}
