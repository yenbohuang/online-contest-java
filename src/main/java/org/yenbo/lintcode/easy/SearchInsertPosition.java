package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPosition {

	@Test
	public void test1() {
		Assert.assertEquals(2, searchInsert(new int[] {1,3,5,6}, 5));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, searchInsert(new int[] {1,3,5,6}, 2));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(4, searchInsert(new int[] {1,3,5,6}, 7));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(0, searchInsert(new int[] {1,3,5,6}, 0));
	}
	
	public int searchInsert(int[] A, int target) {
        
		if (A == null || A.length == 0 || A[0] >= target) {
			return 0;
		}
		
		for (int i = 1; i < A.length; i++) {
			
			if (A[i] >= target) {
				return i;
			}
		}
		
		return A.length;
    }
}
