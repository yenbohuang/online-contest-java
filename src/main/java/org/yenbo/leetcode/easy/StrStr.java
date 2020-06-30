package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/implement-strstr/
 * @author user
 *
 */
public class StrStr {

	@Test
	public void test1() {
		Assert.assertEquals(-1, strStr("source", "target"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, strStr("abcdabcdefg", "bcd"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(0, strStr("", ""));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(0, strStr("a", ""));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(2, strStr("hello", "ll"));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(-1, strStr("aaaaa", "bba"));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(-1, strStr("mississippi", "sippia"));
	}
	
	@Test
	public void test8() {
		Assert.assertEquals(0, strStr("a", "a"));
	}
	
	@Test
	public void test9() {
		Assert.assertEquals(9, strStr("mississippi", "pi"));
	}
	
	public int strStr(String haystack, String needle) {
        
		if (haystack == null || needle == null) {
			return -1;
		}
		
		int haystackLength = haystack.length();
		int needleLength = needle.length();
		
		if (haystackLength < needleLength) {
			return -1;
		}
		
		if (needleLength == 0) {
			return 0;
		}
		
		char firstChar = needle.charAt(0);
		
		for (int i = 0; i < haystackLength; i++) {
			
			if (haystack.charAt(i) == firstChar) {
				
				boolean exactMatch = true;
				
				for (int j = 0; j < needleLength; j++) {
					
					if (needle.charAt(j) != haystack.charAt(i + j)) {
						exactMatch = false;
						break;
					}
				}
				
				if (exactMatch) {
					return i;
				}
			}
			
			if (haystackLength - i - 1 < needleLength) {
				break;
			}
		}
		
		return -1;
    }
}
