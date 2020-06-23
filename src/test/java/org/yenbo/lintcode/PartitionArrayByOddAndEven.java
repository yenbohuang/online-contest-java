package org.yenbo.lintcode;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PartitionArrayByOddAndEven {

	@Test
	public void test() {
		
		int[] nums = new int[] {1, 2, 3, 4};
		partitionArray(nums);
		Assert.assertArrayEquals(new int[] {1, 3, 2, 4}, nums);
	}
	
	public void partitionArray(int[] nums) {
        
		if (nums == null || nums.length == 1) {
			return;
		}
		
		ArrayList<Integer> odds = new ArrayList<Integer>();
		ArrayList<Integer> evens = new ArrayList<Integer>();
		
		for (int n: nums) {
			
			if (n % 2 == 0) {
				evens.add(n);
			} else {
				odds.add(n);
			}
		}
		
		odds.addAll(evens);
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = odds.get(i); 
		}
    }
}
