package org.yenbo.onlinecontest.sourceb;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibrium {

	@Test
	public void test1() {
		Assert.assertEquals(1, new Solution().solution(new int[] {3,1,2,4,3}));
	}
	
	class Solution {
		
	    public int solution(int[] A) {
	        
	    	if (A == null || A.length <= 1) {
	    		return 0;
	    	}
	    	
	    	int size = A.length;
	    	BigInteger min = BigInteger.valueOf(0);
	    	
	    	for (int i = 0; i < size; i++) {
	    		min = min.add(BigInteger.valueOf(A[i]));
	    	}
	    	
	    	min = BigInteger.valueOf(0).subtract(min).abs();
	    	
	    	for (int i = 1; i < size; i++) {
	    		
	    		BigInteger leftSum = BigInteger.valueOf(0);
	    		
	    		for (int j = 0; j < i; j++) {
	    			leftSum = leftSum.add(BigInteger.valueOf(A[j]));
	    		}
	    		
	    		BigInteger rightSum = BigInteger.valueOf(0);
	    		
	    		for (int j = i; j < size; j++) {
	    			rightSum = rightSum.add(BigInteger.valueOf(A[j]));
	    		}
	    		
	    		BigInteger tmp = leftSum.subtract(rightSum).abs();
	    		if (tmp.compareTo(min) == -1) {
	    			min = tmp;
	    		}
	    	}
	    	
	    	return min.intValue();
	    }
	}
}
