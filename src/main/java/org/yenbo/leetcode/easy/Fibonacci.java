package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/fibonacci-number/
 * @author user
 *
 */
public class Fibonacci {

	@Test
	public void test1() {
		Assert.assertEquals(1, fibonacci(1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, fibonacci(2));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(2, fibonacci(3));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(3, fibonacci(4));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(0, fibonacci(0));
	}
	
	public int fibonacci(int n) {
        
		if (n == 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		int[] array = new int[n+1];
		array[0] = 0;
		array[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		return array[n];
    }
}
