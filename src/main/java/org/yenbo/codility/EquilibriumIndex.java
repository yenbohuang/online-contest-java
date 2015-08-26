package org.yenbo.codility;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class EquilibriumIndex {

	@Test
	public void test1() {

		Assert.assertEquals(1, new Solution().solution(new int[] {-1,3,-4,5,1,-6,2,1}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(0, new Solution().solution(new int[] {500, 1, -2, -1, 2}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(0, new Solution().solution(new int[] {0}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(0, new Solution().solution(new int[] {-1, 0}));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(0, new Solution().solution(new int[] {-1, -1, 1}));
	}

	class Solution {
		public int solution(int[] A) {
			
			// this is the answer from the blog
			if (A == null || A.length == 0) {
				return -1; 
			}
			
			int n = A.length;
		    BigInteger sum = BigInteger.valueOf(0);
		    
		    for (int i = 0; i < n; i++) {
		    	sum = sum.add(BigInteger.valueOf(A[i]));
		    } 

		    BigInteger sum_left = BigInteger.valueOf(0);
		    
		    for (int i = 0; i < n; i++) {
		    	
		        BigInteger sum_right = sum.subtract(sum_left).subtract(BigInteger.valueOf(A[i]));
		        
		        if (sum_left.equals(sum_right)) {
		        	return i;
		        }
		        
		        sum_left = sum_left.add(BigInteger.valueOf(A[i]));
		    }
		    
		    return -1; 
		}
	}
}
