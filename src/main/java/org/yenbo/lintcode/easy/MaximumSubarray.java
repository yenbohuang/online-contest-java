package org.yenbo.lintcode.easy;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarray {

	@Test
	public void test() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-2);
		list.add(2);
		list.add(-3);
		list.add(4);
		list.add(-1);
		list.add(2);
		list.add(1);
		list.add(-5);
		list.add(3);

		Assert.assertEquals(6, maxSubArray(list));
	}
	
	public int maxSubArray(ArrayList<Integer> nums) {

		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.size(); i++) {
			
			int sum = 0;
			
			for (int j = i; j < nums.size(); j++) {
				
				sum += nums.get(j);
				
				if (sum > max) {
					max = sum;
				}
			}
		}
		
		return max;
    }
}
