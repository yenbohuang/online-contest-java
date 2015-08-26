package org.yenbo.lintcode.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TwoStringsAreAnagrams {

	@Test
	public void test() {
		Assert.assertTrue(anagram("abcd", "dcab"));;
	}
	
	public boolean anagram(String s, String t) {
        
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
