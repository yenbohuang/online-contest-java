package org.yenbo.lintcode.medium;

import org.junit.Assert;
import org.junit.Test;

public class TwoSum {

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] {1,2}, twoSum(new int[] {2, 7, 11, 15}, 9));
	}
	
	public int[] twoSum(int[] numbers, int target) {

		int size = numbers.length;
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 1; j < size; j++) {
				
				if (target == numbers[i] + numbers[j]) {
					return new int[] {i+1,j+1};
				}
			}
		}
		
		return null;
    }
}
