package org.yenbo.lintcode.medium;

import org.junit.Assert;
import org.junit.Test;

public class RomanToInteger {

	@Test
	public void test1() {
		Assert.assertEquals(4, romanToInt("IV"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(21, romanToInt("XXI"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(99, romanToInt("XCIX"));
	}
	
	public int romanToInt(String s) {
		
        if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Invalid s: " + s);
		}
		
		String tmp = s;
		int answer = 0;
		
		while (tmp.length() > 0) {
			
			if (tmp.startsWith("IV")) {
				answer += 4;
				tmp = tmp.substring(2);
			} else if (tmp.startsWith("IX")) {
				answer += 9;
				tmp = tmp.substring(2);
			} else if (tmp.startsWith("XL")) {
				answer += 40;
				tmp = tmp.substring(2);
			} else if (tmp.startsWith("XC")) {
				answer += 90;
				tmp = tmp.substring(2);
			} else if (tmp.startsWith("CD")) {
				answer += 400;
				tmp = tmp.substring(2);
			} else if (tmp.startsWith("CM")) {
				answer += 900;
				tmp = tmp.substring(2);
			} else if (tmp.startsWith("I")) {
				answer += 1;
				tmp = tmp.substring(1);
			} else if (tmp.startsWith("V")) {
				answer += 5;
				tmp = tmp.substring(1);
			} else if (tmp.startsWith("X")) {
				answer += 10;
				tmp = tmp.substring(1);
			} else if (tmp.startsWith("L")) {
				answer += 50;
				tmp = tmp.substring(1);
			} else if (tmp.startsWith("C")) {
				answer += 100;
				tmp = tmp.substring(1);
			} else if (tmp.startsWith("D")) {
				answer += 500;
				tmp = tmp.substring(1);
			} else if (tmp.startsWith("M")) {
				answer += 1000;
				tmp = tmp.substring(1);
			}
		}
		
		return answer;
    }
}
