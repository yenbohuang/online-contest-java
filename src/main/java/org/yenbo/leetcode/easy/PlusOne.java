package org.yenbo.leetcode.easy;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/plus-one/
 * @author user
 *
 */
public class PlusOne {

	@Test
	public void test1() {
		
		int[] digits = new int[] {1, 2, 3};
		Assert.assertArrayEquals(new int[] {1, 2, 4}, plusOne(digits));
	}
	
	@Test
	public void test2() {
		
		int[] digits = new int[] {9};
		Assert.assertArrayEquals(new int[] {1, 0}, plusOne(digits));
	}
	
	@Test
	public void test3() {
		
		int[] digits = new int[] {4,3,2,1};
		Assert.assertArrayEquals(new int[] {4,3,2,2}, plusOne(digits));
	}
	
	public int[] plusOne(int[] digits) {

		if (digits == null) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < digits.length; i++) {
			list.add(digits[i]);
		}
		
		list.set(list.size() - 1, list.get(list.size() - 1) + 1);
		
		for (int i = list.size() - 1; i > 0; i--) {
			
			if (list.get(i) > 9) {
				list.set(i, list.get(i) - 10);
				list.set(i - 1, list.get(i - 1) + 1);
			}
		}
		
		if (list.get(0) > 9) {
			list.set(0, list.get(0) - 10);
			list.add(0, 1);
		}
		
		int[] answer = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i); 
		}
		
		return answer;
    }
}
