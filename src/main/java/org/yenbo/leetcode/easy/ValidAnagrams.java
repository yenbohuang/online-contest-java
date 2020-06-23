package org.yenbo.leetcode.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/valid-anagram/
 * @author user
 *
 */
public class ValidAnagrams {

	@Test
	public void test1() {
		Assert.assertTrue(isAnagram("abcd", "dcab"));;
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(isAnagram("anagram", "nagaram"));;
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(isAnagram("rat", "car"));;
	}
	
	public boolean isAnagram(String s, String t) {
        
		// handle simple cases
		if (s == null && t== null) {
			return true;
		} else if (s.length() == 0 && t.length() == 0) {
			return true;
		} else if (s.length() != t.length()) {
			return false;
		}
		
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i] != tArray[i]) {
				return false;
			}
		}
		
		return true;
    }
}
