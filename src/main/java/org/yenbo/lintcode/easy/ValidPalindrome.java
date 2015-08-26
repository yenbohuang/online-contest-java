package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindrome {

	@Test
	public void test1() {
		Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	@Test
	public void test2() {
		Assert.assertFalse(isPalindrome("race a car"));
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(isPalindrome("1a2"));
	}
	
	@Test
	public void test4() {
		
		System.out.println(Character.getNumericValue('a'));
		System.out.println(Character.getNumericValue('z'));
		System.out.println(Character.getNumericValue('0'));
		System.out.println(Character.getNumericValue('9'));
		System.out.println(Character.getNumericValue(' '));
	}
	
	public boolean isPalindrome(String s) {
        
		if (s == null || s.isEmpty()) {
			return true;
		}
		
		int i = 0;
		int j = s.length() - 1;
		s = s.toLowerCase();
		
		while (j > i) {
			
			char ci = s.charAt(i);
			char cj = s.charAt(j);
			
			if (false == isAlphaNumeric(ci)) {
				i++;
			} else if (false == isAlphaNumeric(cj)) {
				j--;
			} else {
				if (ci != cj) {
					return false;
				}
				
				i++;
				j--;
			}
		}
		
		return true;
    }
	
	private boolean isAlphaNumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}
}
