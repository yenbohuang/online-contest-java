package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/rotate-string/
 * @author user
 *
 */
public class RotateString {

	@Test
	public void test1() {
		Assert.assertTrue(rotateString("abcde", "cdeab"));
	}
	
	@Test
	public void test2() {
		Assert.assertFalse(rotateString("abcde", "abced"));
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(rotateString("", ""));
	}
	
	public boolean rotateString(String A, String B) {

		if (A.contentEquals(B)) {
			return true;
		} else if (A.length() == B.length()) {
		
			int length = A.length();
			
			for (int i = 0; i < length; i++) {
				
				char target = A.charAt(i);
				
				int index = B.indexOf(target);
				
				while (index != -1) {
					String newBString = B.substring(index) + B.substring(0, index);
					
					if (A.contentEquals(newBString)) {
						return true;
					}
					
					if (index + 1 < length) {
						index = B.indexOf(target, index + 1);
					} else {
						break;
					}
				}
				
			}
		}
		
		return false;
	}
}
