package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/add-binary/
 * @author user
 *
 */
public class AddBinary {

	@Test
	public void test1() {
		Assert.assertEquals("100", addBinary("11", "1"));
	}
	
	@Test
	public void test2() {
		// FIXME not working yet
		Assert.assertEquals("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000",
				addBinary(
						"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
						"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
	
	public String addBinary(String a, String b) {
		
		int length = a.length();
		
		StringBuilder reverseA = new StringBuilder(a).reverse();
		StringBuilder reverseB = new StringBuilder(b).reverse();
		
		if (a.length() > b.length()) {
			
			int diff = a.length() - b.length();
			for (int i = 0; i < diff; i++) {
				reverseB.append("0");
			}
			
		} else if (b.length() > a.length()) {
			
			length = b.length();
			
			int diff = b.length() - a.length();
			for (int i = 0; i < diff; i++) {
				reverseA.append("0");
			}
		}
		
		a = reverseA.toString();
		b = reverseB.toString();
		
		StringBuilder answer = new StringBuilder();
		int increment = 0;
		
		for (int i = 0; i < length; i++) {
			
			int valueA = a.charAt(i) == '1' ? 1 : 0;
			int valueB = b.charAt(i) == '1' ? 1 : 0;
			
			int sum = increment + valueA + valueB;
			
			answer.append(Integer.toString(sum % 2));
			increment = sum / 2;
		}
		
		while (increment > 0) {
			answer.append(increment % 2);
			increment = increment / 2;
		}
		
		return answer.reverse().toString();
    }
}
