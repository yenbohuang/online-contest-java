package org.yenbo.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SafeMath {

	@Test
	public void testSafeAdd() {
		Assert.assertEquals(99 + 23, safeAdd(99, 23));
	}
	
	@Test
	public void testSafeMultiply() {
		Assert.assertEquals(9 * 23, safeMultiply(9, 23));
	}
	
	@Test
	public void testSafePower() {
		Assert.assertEquals(Math.pow(33, 5), safePower(33, 5), 0.1);
	}
	
	/**
	 * Copied from:
	 * https://www.securecoding.cert.org/confluence/display/java/NUM00-J.+Detect+or+prevent+integer+overflow
	 * 
	 * @param left
	 * @param right
	 * @return
	 * @throws ArithmeticException
	 */
	public static final int safeAdd(int left, int right) throws ArithmeticException {
		if (right > 0 ? left > Integer.MAX_VALUE - right
				: left < Integer.MIN_VALUE - right) {
			throw new ArithmeticException("Integer overflow");
		}
		return left + right;
	}

	/**
	 * Copied from:
	 * https://www.securecoding.cert.org/confluence/display/java/NUM00-J.+Detect+or+prevent+integer+overflow
	 * 
	 * @param left
	 * @param right
	 * @return
	 * @throws ArithmeticException
	 */
	public static final int safeMultiply(int left, int right)
			throws ArithmeticException {
		if (right > 0 ? left > Integer.MAX_VALUE / right
				|| left < Integer.MIN_VALUE / right
				: (right < -1 ? left > Integer.MIN_VALUE / right
						|| left < Integer.MAX_VALUE / right : right == -1
						&& left == Integer.MIN_VALUE)) {
			throw new ArithmeticException("Integer overflow");
		}
		return left * right;
	}
	
	public static final int safePower(int value, int n) {
		
		int result = 1;
		
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				result = safeMultiply(result, value);
			}
		}
		
		return result;
	}
}
