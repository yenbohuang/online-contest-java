package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class RotateString {

	@Test
	public void test1() {
		Assert.assertArrayEquals("abcdefg".toCharArray(), 
				rotateString("abcdefg".toCharArray(), 0));
	}
	
	@Test
	public void test2() {
		Assert.assertArrayEquals("gabcdef".toCharArray(), 
				rotateString("abcdefg".toCharArray(), 1));
	}
	
	@Test
	public void test3() {
		Assert.assertArrayEquals("fgabcde".toCharArray(), 
				rotateString("abcdefg".toCharArray(), 2));
	}
	
	@Test
	public void test4() {
		Assert.assertArrayEquals("efgabcd".toCharArray(), 
				rotateString("abcdefg".toCharArray(), 3));
	}
	
	public char[] rotateString(char[] A, int offset) {
        
		if (A == null || A.length == 1) {
			return A;
		}
		
		char[] answer = new char[A.length];
		
		for (int i = 0; i < A.length; i++) {
			
			answer[(i + offset) % A.length] = A[i];
		}
		
		return answer;
    }
}
