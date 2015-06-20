package org.yenbo.onlinecontest.sourceb;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibrium {

	@Test
	public void test1() {
		Assert.assertEquals(1, new Solution().solution(new int[] {3,1,2,4,3}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2000, new Solution().solution(new int[] {-1000,1000}));
	}
	
	class Solution {
		
	    public int solution(int[] A) {
	        
	    	if (A == null || A.length <= 1) {
	    		return 0;
	    	}
	    	
	    	int size = A.length;
	    	BigInteger sum = BigInteger.valueOf(0);
	    	
	    	for (int i = 0; i < size; i++) {
	    		sum = sum.add(BigInteger.valueOf(A[i]));
	    	}
	    	
	    	BigInteger leftSum = BigInteger.valueOf(A[0]);
	    	BigInteger min = leftSum.subtract(sum.subtract(leftSum)).abs();
	    	
	    	for (int i = 1; i < size; i++) {
	    		
	    		BigInteger rightSum = sum.subtract(leftSum);
	    		
	    		BigInteger tmp = leftSum.subtract(rightSum).abs();
	    		if (tmp.compareTo(min) == -1) {
	    			min = tmp;
	    		}
	    		
	    		leftSum = leftSum.add(BigInteger.valueOf(A[i]));
	    	}
	    	
	    	return min.intValue();
	    }
	}
}
