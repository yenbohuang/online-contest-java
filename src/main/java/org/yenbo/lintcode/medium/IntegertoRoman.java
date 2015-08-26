package org.yenbo.lintcode.medium;

import org.junit.Assert;
import org.junit.Test;

public class IntegertoRoman {

	@Test
	public void test1() {
		Assert.assertEquals("IV", intToRoman(4));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("XXI", intToRoman(21));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("XCIX", intToRoman(99));
	}
	
	public String intToRoman(int n) {
		
		String answer = "";
		
		while ((n / 1000) > 0) {
			answer += "M";
			n -= 1000;
		}
		
		while ((n / 900) > 0) {
			answer += "CM";
			n -= 900;
		}
		
		while ((n / 500) > 0) {
			answer += "D";
			n -= 500;
		}
		
		while ((n / 400) > 0) {
			answer += "CD";
			n -= 400;
		}
		
		while ((n / 100) > 0) {
			answer += "C";
			n -= 100;
		}
		
		while ((n / 90) > 0) {
			answer += "XC";
			n -= 90;
		}
		
		while ((n / 50) > 0) {
			answer += "L";
			n -= 50;
		}
		
		while ((n / 40) > 0) {
			answer += "XL";
			n -= 40;
		}
		
		while ((n / 10) > 0) {
			answer += "X";
			n -= 10;
		}
		
		while ((n / 9) > 0) {
			answer += "IX";
			n -= 9;
		}
		
		while ((n / 5) > 0) {
			answer += "V";
			n -= 5;
		}
		
		while ((n / 4) > 0) {
			answer += "IV";
			n -= 4;
		}
		
		while (n > 0) {
			answer += "I";
			n -= 1;
		}
		
		return answer;
    }
}
