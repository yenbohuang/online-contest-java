package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class FlipBits {

	@Test
	public void test1() {
		Assert.assertEquals(2, bitSwapRequired(31, 14));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(31, bitSwapRequired(1, -1));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(4, bitSwapRequired(67, 31));
	}
	
	public static int bitSwapRequired(int a, int b) {
        
		int answer = 0;
		
		String strA = Integer.toBinaryString(a);
		String strB = Integer.toBinaryString(b);
		
		int size = (strA.length() > strB.length()) ? strA.length() : strB.length();
		
		for (int i = 0; i < size; i++) {
			
			char charA = (i <= strA.length() - 1) ? strA.charAt(strA.length() - 1 - i) : '0';
			char charB = (i <= strB.length() - 1) ? strB.charAt(strB.length() - 1 - i) : '0';
			
			if (charA != charB) answer++;
		}
		
		return answer;
    }
}
