package org.yenbo.codility;


import org.junit.Assert;
import org.junit.Test;

public class FrogJmp {

	@Test
	public void test1() {
		Assert.assertEquals(3, new Solution().solution(10, 85, 30));
	}
	
	class Solution {
	    public int solution(int X, int Y, int D) {
	        
	    	int steps = (Y - X) / D;
	    	
	    	if (X + steps * D < Y) {
	    		return steps + 1;
	    	} else {
	    		return steps;
	    	}
	    }
	}
}
