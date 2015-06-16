package org.yenbo.onlinecontest.sourceb;

import org.junit.Assert;
import org.junit.Test;

public class EquilibriumIndex {

	@Test
	public void test1() {

		int[] A = new int[8];

		A[0] = -1;
		A[1] = 3;
		A[2] = -4;
		A[3] = 5;
		A[4] = 1;
		A[5] = -6;
		A[6] = 2;
		A[7] = 1;

		Assert.assertEquals(1, new Solution().solution(A));
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
			
			// TODO cannot pass performance test and overflow test
			int size = A.length;
			
			for (int i = 0; i < size; i++) {
				
				int leftSum = 0;
				int rightSum = 0;
				
				for (int j = 0; j < i; j++) {
					leftSum += A[j];
				}
				
				for (int j = i + 1; j < size; j++) {
					rightSum += A[j];
				}
				
				if (leftSum == rightSum) {
					return i;
				}
			}
			
			return -1;
		}
	}
}
