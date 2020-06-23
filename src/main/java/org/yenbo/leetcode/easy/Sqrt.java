package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/sqrtx/
 * @author user
 *
 */
public class Sqrt {

	@Test
	public void test1() {
		Assert.assertEquals(1, sqrt(3));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2, sqrt(4));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(2, sqrt(5));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(3, sqrt(10));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(46340, sqrt(2147483647));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(11, sqrt(121));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(2, sqrt(8));
	}
	
	public int sqrt(int x) {
		
		// https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
		int res = 0;
	    int bit = 1 << 30; // The second-to-top bit is set: 1 << 30 for 32 bits
	 
	    // "bit" starts at the highest power of four <= the argument.
	    while (bit > x) {
	        bit >>= 2;
	    }
	 
	    while (bit != 0) {
	        if (x >= res + bit) {
	            x -= res + bit;
	            res = (res >> 1) + bit;
	        }
	        else
	            res >>= 1;
	        bit >>= 2;
	    }
	    return res;
	}

	
//	public int sqrtSlowVersion(int x) {
//        
//		// TODO Time Limit Exceeded
//		int answer = 1;
//		
//		while (answer * answer < x) {
//			answer++;
//		}
//		
//		if (answer * answer > x) {
//			return answer - 1;
//		} else {
//			return answer;
//		}
//    }
}
