package org.yenbo.leetcode.todo.missing;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSubarray {

	@Test
	public void test1() {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(-1);
		nums.add(-2);
		nums.add(1);
		
		Assert.assertEquals(-3, minSubArray(nums));
	}
	
	@Test
	public void test2() {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(1);
		
		Assert.assertEquals(1, minSubArray(nums));
	}
	
	@Test
	public void test3() {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(5);
		nums.add(-4);
		
		Assert.assertEquals(-4, minSubArray(nums));
	}
	
	public int minSubArray(ArrayList<Integer> nums) {
        
		int size = nums.size();
		int min = nums.get(0);
		
		for (int i = 0; i < size; i++) {
			
			int prev = nums.get(i);
			
			if (min > prev) {
				min = prev;
			}
			
			for (int j = i + 1; j < size; j++) {
				
				if (prev + nums.get(j) < min ) {
					prev += nums.get(j);
					min = prev;
				} else {
					prev += nums.get(j);
				}
			}
		}
		
		return min;
    }
}
