package org.yenbo.lintcode.easy;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class SingleNumber {

	@Test
	public void test() {
		
		Assert.assertEquals(4, singleNumber(new int[] {1,2,2,1,3,4,3}));
	}
	
	public int singleNumber(int[] A) {
		
		if (A == null || A.length == 0) {
			return 0;
		}
		
		HashSet<Integer> singleIntegers = new HashSet<Integer>();
		HashSet<Integer> multipleIntegers = new HashSet<Integer>();
		
		singleIntegers.add(A[0]);
		
		for (int i = 1; i < A.length; i++) {
			
			if (singleIntegers.contains(A[i])) {
				singleIntegers.remove(A[i]);
				multipleIntegers.add(A[i]);
			} else if (false == multipleIntegers.contains(A[i])) {
				singleIntegers.add(A[i]);
			}
		}
		
		return singleIntegers.isEmpty() ? 0 : singleIntegers.iterator().next().intValue();
	}
}
