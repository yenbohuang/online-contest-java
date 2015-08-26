package org.yenbo.lintcode.easy;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayExcludeItself {

	@Test
	public void test() {
		
		// 1, 2, 3
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		
		ArrayList<Long> answer = productExcludeItself(A);
		
		Assert.assertArrayEquals(new Long[] {6L, 3L, 2L}, answer.toArray(new Long[0]));
	}
	
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        
		ArrayList<Long> answer = new ArrayList<Long>();
		
		for (int i = 0; i < A.size(); i++) {
			
			Long tmp = 1L;
			
			for (int j = 0; j < A.size(); j++) {
				
				if (j != i) {
					tmp *= A.get(j);
				}
			}
			
			answer.add(tmp);
		}
		
		return answer;
    }
}
