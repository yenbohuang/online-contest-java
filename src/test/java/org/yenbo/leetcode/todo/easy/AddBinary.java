package org.yenbo.leetcode.todo.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/add-binary/
 * @author user
 *
 */
public class AddBinary {

	@Test
	public void test() {
		Assert.assertEquals("100", addBinary("11", "1"));
	}
	
	@Test
	public void longString() {
		// FIXME not working yet
		Assert.assertEquals("100",
				addBinary(
						"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
						"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
	
	public String addBinary(String a, String b) {
		
		return Long.toBinaryString(
				Long.parseLong(a, 2) + Long.parseLong(b, 2));
    }	
}
