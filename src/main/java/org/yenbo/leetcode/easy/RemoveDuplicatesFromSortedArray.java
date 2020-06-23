package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author user
 *
 */
public class RemoveDuplicatesFromSortedArray {

	@Test
	public void test() {
		Assert.assertEquals(2, removeDuplicates(new int[] {1,1,2}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(3, removeDuplicates(new int[] {1,1,2,2,3,3}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(38, removeDuplicates(new int[] {-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(5, removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
	
	public int removeDuplicates(int[] nums) {
        
		if (nums == null) {
			return 0;
		} else if (nums.length == 1) {
			return 1;
		}
		
		int n = nums.length;
		boolean updated = true;
		
		while (updated) {
			
			updated = false;
			
			for (int i = 0; i < n - 1; i++) {
				
				if (nums[i] == nums[i + 1]) {
					
					for (int j = i; j < n - 1; j++) {
						nums[j] = nums[j+1];
					}
					
					n--;
					updated = true;
				}
			}
		}
		
		return n;
    }
}
