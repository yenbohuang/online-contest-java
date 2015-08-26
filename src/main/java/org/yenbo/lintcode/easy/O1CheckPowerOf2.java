package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class O1CheckPowerOf2 {

	@Test
	public void test1() {
		Assert.assertTrue(checkPowerOf2(4));
	}
	
	@Test
	public void test2() {
		Assert.assertFalse(checkPowerOf2(5));
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(checkPowerOf2(1024));
	}
	
	@Test
	public void test4() {
		Assert.assertFalse(checkPowerOf2(-1));
	}
	
	public boolean checkPowerOf2(int n) {

		while (n > 0) {
			
			if (n == 1) {
				return true;
			}
			
			if (n % 2 != 0) {
				return false;
			} else {
				n /= 2;	
			}
		}
		
		return false;
    }
}
