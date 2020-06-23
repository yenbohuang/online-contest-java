package org.yenbo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * @author user
 *
 */
public class ProductOfArrayExcludeItself {

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[] {6, 3, 2}, productExcludeItself(new int[] {1,2,3}));
	}
	
	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[] {24,12,8,6}, productExcludeItself(new int[] {1,2,3,4}));
	}
	
	public int[] productExcludeItself(int[] nums) {
        
		int length = nums.length;
		int[] answer = new int[length];
		
		for (int i = 0; i < length; i++) {
			
			int tmp = 1;
			
			for (int j = 0; j < length; j++) {
				
				if (j != i) {
					tmp *= nums[j];
				}
			}
			
			answer[i] = tmp;
		}
		
		return answer;
    }
}
