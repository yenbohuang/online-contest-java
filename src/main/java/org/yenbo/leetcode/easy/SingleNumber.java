package org.yenbo.leetcode.easy;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/single-number/
 * @author user
 *
 */
public class SingleNumber {

	@Test
	public void test1() {
		Assert.assertEquals(4, singleNumber(new int[] {1,2,2,1,3,4,3}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, singleNumber(new int[] {2,2,1}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(4, singleNumber(new int[] {4,1,2,1,2}));
	}
	
	public int singleNumber(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		HashSet<Integer> singleIntegers = new HashSet<Integer>();
		HashSet<Integer> multipleIntegers = new HashSet<Integer>();
		
		singleIntegers.add(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			
			if (singleIntegers.contains(nums[i])) {
				singleIntegers.remove(nums[i]);
				multipleIntegers.add(nums[i]);
			} else if (false == multipleIntegers.contains(nums[i])) {
				singleIntegers.add(nums[i]);
			}
		}
		
		return singleIntegers.isEmpty() ? 0 : singleIntegers.iterator().next().intValue();
	}
}
