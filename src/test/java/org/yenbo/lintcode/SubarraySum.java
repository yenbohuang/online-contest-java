package org.yenbo.lintcode;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class SubarraySum {

	@Test
	public void test1() {
		Assert.assertArrayEquals(new Integer[] {0, 2}, subarraySum(
				new int[] {-3, 1, 2, -3, 4}).toArray(new Integer[0]));
	}
	
	@Test
	public void test2() {
		Assert.assertArrayEquals(new Integer[] {5, 5}, subarraySum(
				new int[] {4,10,13,4,-1,0,3,3,5}).toArray(new Integer[0]));
	}
	
	public ArrayList<Integer> subarraySum(int[] nums) {
        
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		if (nums == null || nums.length == 0) {
			return answer;
		}
		
		if (nums.length == 1) {
			
			if (nums[0] == 0) {
				answer.add(0);
				answer.add(0);
			}
			
			return answer;
		}
		
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] == 0) {
				answer.add(i);
				answer.add(i);
				return answer;
			}
			
			int sum = nums[i];
			
			for (int j = i + 1; j < nums.length; j++) {
				
				sum += nums[j];
				
				if (sum == 0) {
					answer.add(i);
					answer.add(j);
					return answer;
				}
			}
			
		}
		
		return answer;
    }
}
