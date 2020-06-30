package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/power-of-two/
 * @author user
 *
 */
public class PowerOfTwo {

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
	
	@Test
	public void test5() {
		Assert.assertTrue(checkPowerOf2(1));
	}
	
	@Test
	public void test6() {
		Assert.assertTrue(checkPowerOf2(16));
	}
	
	@Test
	public void test7() {
		Assert.assertFalse(checkPowerOf2(218));
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
