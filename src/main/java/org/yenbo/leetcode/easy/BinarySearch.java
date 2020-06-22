package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

	@Test
	public void test1() {
		Assert.assertEquals(0, binarySearch(new int[] {3}, 3));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(-1, binarySearch(new int[] {1, 2, 3, 3, 4, 5, 10}, 6));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(2, binarySearch(new int[] {1, 2, 3, 3, 4, 5, 10}, 3));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(1, binarySearch(new int[] {2,5}, 5));
	}
	
	public int binarySearch(int[] nums, int target) {
        
		int answer = -1;
		
		if (nums.length == 1) {
			if (nums[0] == target) {
				answer = 0;
			}
		} else if (nums[0] == target) {
			return 0;
		} else if (nums[nums.length - 1] == target) {
			return nums.length - 1;
		} else {
			
			int start = 0;
			int end = nums.length - 1;
			int prevStart = -1;
			int prevEnd = -1;
			
			while (start != end) {
				
				if (prevStart == start && prevEnd == end) {
					break;
				}
				
				prevStart = start;
				prevEnd = end;
				
				int mid = (start + end) / 2;
				
				if (nums[mid] == target) {
					
					if (mid == 0 || nums[mid - 1] < target) {
						answer = mid;
						break;
					} else {
						end = mid;
					}
					
				} else if (nums[mid] < target) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}
		
		return answer;
    }
}
