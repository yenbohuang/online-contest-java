package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class Fibonacci {

	@Test
	public void test1() {
		Assert.assertEquals(0, fibonacci(1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, fibonacci(2));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(34, fibonacci(10));
	}
	
	public int fibonacci(int n) {
        
		if (n == 1) {
			return 0;
		}
		
		if (n == 2) {
			return 1;
		}
		
		int[] array = new int[n];
		array[0] = 0;
		array[1] = 1;
		
		for (int i = 2; i < n; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		return array[n-1];
    }
}
