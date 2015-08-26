package org.yenbo.lintcode.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class CompareStrings {

	@Test
	public void test1() {
		Assert.assertTrue(compareStrings("ABCD", "ACD"));
	}
	
	@Test
	public void test2() {
		Assert.assertFalse(compareStrings("ABCD", "AABC"));
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(compareStrings("ABCDEFG", "ACC"));
	}
	
	@Test
	public void test4() {
		Assert.assertTrue(compareStrings("ABCDE", "DB"));
	}
	
	public boolean compareStrings(String A, String B) {
        
		if (B.length() > A.length()) {
			return false;
		}
		
		char[] arrayA = A.toCharArray();
		char[] arrayB = B.toCharArray();
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		
		int matchedPos = 0;
		
		for (int i = 0; i < B.length(); i++) {
			
			boolean matched = false;
			
			for (int j = matchedPos; j < A.length(); j++) {
				
				if (arrayA[j] == arrayB[i]) {
					matched = true;
					matchedPos = j + 1;
					break;
				}
			}
			
			if (matched == false) {
				return false;
			}
		}
		
		return true;
    }
}
