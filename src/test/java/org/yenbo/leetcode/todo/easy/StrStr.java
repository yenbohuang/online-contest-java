package org.yenbo.leetcode.todo.easy;

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
		// FIXME index out of bound
		Assert.assertEquals(-1, strStr("mississippi", "sippia"));
	}
	
	public int strStr(String haystack, String needle) {
        
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return -1;
		}
		
		if (needle.length() == 0) {
			return 0;
		}
		
		for (int i = 0; i < haystack.length(); i++) {
			
			if (haystack.charAt(i) == needle.charAt(0)) {
				
				if (haystack.length() - i + 1 < needle.length()) {
					return -1;
				}
				
				boolean exactMatch = true;
				
				for (int j = 1; j < needle.length(); j++) {
					
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						exactMatch = false;
						break;
					}
				}
				
				if (exactMatch) {
					return i;
				}
			}
		}
		
		return -1;
    }
}
