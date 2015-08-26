package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class CoinsInALine {

	@Test
	public void test1() {
		Assert.assertTrue(firstWillWin(1));
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(firstWillWin(2));
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(firstWillWin(3));
	}
	
	@Test
	public void test4() {
		Assert.assertTrue(firstWillWin(4));
	}
	
	@Test
	public void test5() {
		Assert.assertTrue(firstWillWin(5));
	}
	
	public boolean firstWillWin(int n) {
        
		int tmp = n;
		int count = 0;
		
		// start from 1
		while (tmp > 0) {
			
			tmp -= (count % 2 == 0) ? 1 : 2;
			count++;
			
			// win by "start from 2"
			if (tmp < 0) return true;
		}
		
		return (count % 2 == 1);
    }
}
