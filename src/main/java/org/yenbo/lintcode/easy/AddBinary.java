package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class AddBinary {

	@Test
	public void test() {
		Assert.assertEquals("100", addBinary("11", "1"));
	}
	
	public String addBinary(String a, String b) {
		
		return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }	
}
