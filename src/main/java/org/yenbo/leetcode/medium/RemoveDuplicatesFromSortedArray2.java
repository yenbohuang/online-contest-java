package org.yenbo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author user
 *
 */
public class RemoveDuplicatesFromSortedArray2 {

	@Test
	public void test1() {
		Assert.assertEquals(5, removeDuplicates(new int[] {1,1,1,2,2,3}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(7, removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
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
			int duplicated = 0;
			
			for (int i = 0; i < n - 1; i++) {
				
				if (nums[i] == nums[i + 1]) {
					
					duplicated++;
					
					if (duplicated > 1) {
						
						for (int j = i; j < n - 1; j++) {
							nums[j] = nums[j+1];
						}
						
						n--;
						updated = true;
						break;
					}
				} else {
					duplicated = 0;
				}
			}
		}
		
		return n;
    }
}
