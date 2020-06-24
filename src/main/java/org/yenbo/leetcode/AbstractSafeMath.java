package org.yenbo.leetcode;

public abstract class AbstractSafeMath {

	/**
	 * Copied from:
	 * https://www.securecoding.cert.org/confluence/display/java/NUM00-J.+Detect+or+prevent+integer+overflow
	 * 
	 * @param left
	 * @param right
	 * @return
	 * @throws ArithmeticException
	 */
	protected int safeAdd(int left, int right) throws ArithmeticException {
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
	protected int safeMultiply(int left, int right)
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
	
	protected int safePower(int value, int n) {
		
		int result = 1;
		
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				result = safeMultiply(result, value);
			}
		}
		
		return result;
	}
}
