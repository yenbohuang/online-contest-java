package org.yenbo.leetcode.easy;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/remove-element/
 * @author user
 *
 */
public class RemoveElement {

	@Test
	public void test1() {
		Assert.assertEquals(4, removeElement(new int[] {0,4,4,0,0,2,4,4}, 4));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2, removeElement(new int[] {3,2,2,3}, 3));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(5, removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
	}
	
	public int removeElement(int[] nums, int val) {
        
		if (nums == null) {
			return 0;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int a: nums) {
			
			if (a != val) {
				list.add(a);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i).intValue();
		}
		
		return list.size();
    }
}
