package org.yenbo.onlinecontest.sourceb;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElem {

	@Test
	public void test1() {
		Assert.assertEquals(4, new Solution().solution(new int[] {2,3,1,5}));
	}
	
	class Solution {
	    public int solution(int[] A) {
	        
	    	int size = A.length;
	    	
	    	boolean[] array = new boolean[size + 1];
	    	
	    	for (int i = 0; i < size; i++) {
	    		array[A[i] - 1] = true;
	    	}
	    	
	    	for (int i = 0; i < size + 1; i++) {
	    		
	    		if (false == array[i]) {
	    			return i + 1;
	    		}
	    	}
	    	
	    	return 0;
	    }
	}
}
