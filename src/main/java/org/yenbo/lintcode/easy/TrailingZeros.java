package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class TrailingZeros {

	@Test
	public void test1() {
		Assert.assertEquals(2, trailingZeros(11));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(250292920, trailingZeros(1001171717));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(1388887499996L, trailingZeros(5555550000000L));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(72979977499999994L, trailingZeros(291919910000000000L));
	}
	
	public long trailingZeros(long n) {
		
		// https://en.wikipedia.org/wiki/Trailing_zero
		long answer = 0;
		long k = 1;
		
		for (k = 1; Math.pow(5, k) < n; k++) {
			// find k
		}
		
		for (long i = 1; i < k; i++) {
			// cast to long, or it will be handled as int
			answer += (long)Math.floor(n / Math.pow(5, i));
		}
		
		return answer;
	}
	
	public long trailingZerosSlowVersion(long n) {
        
		// TODO Time Limit Exceeded
		int numOfFives = 0;
		
		for (long i = 0; i <= n; i += 5) {
			
			long tmp5 = i;
			while (tmp5 % 5 == 0 && tmp5 != 0) {
				numOfFives++;
				tmp5 /= 5;
			}
		}

		return numOfFives;
    }	
}
