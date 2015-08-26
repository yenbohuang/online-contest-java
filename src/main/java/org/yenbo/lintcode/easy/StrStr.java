package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

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
	
	public int strStr(String source, String target) {
        
		if (source == null || target == null || 
				source.length() < target.length()) {
			return -1;
		}
		
		if (target.length() == 0) {
			return 0;
		}
		
		for (int i = 0; i < source.length(); i++) {
			
			if (source.charAt(i) == target.charAt(0)) {
				
				if (source.length() - i + 1 < target.length()) {
					return -1;
				}
				
				boolean exactMatch = true;
				
				for (int j = 1; j < target.length(); j++) {
					
					if (source.charAt(i + j) != target.charAt(j)) {
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
