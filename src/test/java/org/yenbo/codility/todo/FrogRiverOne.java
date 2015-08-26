package org.yenbo.codility.todo;

import org.junit.Assert;
import org.junit.Test;

public class FrogRiverOne {

	@Test
	public void test1() {
		Assert.assertEquals(6, new Solution().solution(5, new int[] {1,3,1,4,2,3,5,4}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(4, new Solution().solution(4, new int[] {1,2,3,5,4,5,4,4}));
	}
	
	class Solution {
	    public int solution(int X, int[] A) {
	        
	    	boolean[] array = new boolean[X];
	    	int size = A.length;
	    	
	    	for (int i = 0; i < size; i++) {
	    		
	    		if (A[i] <= X) {
	    			array[A[i] - 1] = true;
	    		}
	    		
	    		if (A[i] == X) {
	    			
	    			boolean completed = true;
	    			for (int j = 0; j < X; j++) {
	    				
	    				if (array[j] == false) {
	    					completed = false;
	    					break;
	    				}
	    			}
	    			
	    			if (completed) {
	    				return i;
	    			}
	    		}
	    	}
	    	
	    	return -1;
	    }
	}
}
