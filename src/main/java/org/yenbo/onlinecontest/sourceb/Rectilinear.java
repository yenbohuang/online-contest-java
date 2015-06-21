package org.yenbo.onlinecontest.sourceb;


import org.junit.Assert;
import org.junit.Test;

public class Rectilinear {

	@Test
	public void test1() {
		Assert.assertEquals(42, new Solution().solution(-4, 1, 2, 6, 0, -1, 4, 3));
	}
	
	class Solution {
	    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
	        
	    	int areaA = (M-K) * (N-L);
	    	int areaB = (R-P) * (S-Q);
	    	
	    	int interception = 0;
	    	
	    	if (P >= K && P <= M) {
	    		
	    		if (S >= L && S <= N) {
	    			// case 1
	    			interception = (M - P) * (S - L);
	    		} else if (Q >= L && Q <= N) {
	    			// case 3
	    			interception = (M - P) * (N - Q);
	    		}
	    		
	    	} else if (R >= K && R <= M) {
	    		
	    		if (S >= L && S <= N) {
	    			// case 2
	    			interception = (R - K) * (S - L);
	    		} else if (Q >= L && Q <= N) {
	    			// case 4
	    			interception = (R - K) * (N - Q);
	    		}
	    	}
	    	
	    	// TODO overflow
	    	return areaA + areaB - interception;
	    }
	}
}
