package org.yenbo.onlinecontest.sourceb;


import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class Rectilinear {

	@Test
	public void test1() {
		Assert.assertEquals(42, new Solution().solution(-4, 1, 2, 6, 0, -1, 4, 3));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(200, new Solution().solution(0, 0, 10, 10, 12,0,22,10));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(175, new Solution().solution(0,5,10,15,5,0,15,10));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(175, new Solution().solution(5,5,15,15,0,0,10,10));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(175, new Solution().solution(0,0,10,10,5,5,15,15));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(175, new Solution().solution(5,0,15,10,0,5,10,15));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(-1, new Solution().solution(-2147483647, -2147483647, 0, 0, 0, 0, 2147483647, 2147483647));
	}
	
	@Test
	public void test8() {
		Assert.assertEquals(100, new Solution().solution(0, 0, 10, 10, 0, 0, 10, 10));
	}
	
	class Solution {
	    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
	        
	    	BigInteger bigK = BigInteger.valueOf(K);
	    	BigInteger bigL = BigInteger.valueOf(L);
	    	BigInteger bigM = BigInteger.valueOf(M);
	    	BigInteger bigN = BigInteger.valueOf(N);
	    	BigInteger bigP = BigInteger.valueOf(P);
	    	BigInteger bigQ = BigInteger.valueOf(Q);
	    	BigInteger bigR = BigInteger.valueOf(R);
	    	BigInteger bigS = BigInteger.valueOf(S);
	    	
	    	BigInteger areaA = bigM.subtract(bigK).multiply(bigN.subtract(bigL)); // (M-K) * (N-L)
	    	BigInteger areaB = bigR.subtract(bigP).multiply(bigS.subtract(bigQ)); // (R-P) * (S-Q)
	    	
	    	BigInteger interception = BigInteger.valueOf(0);
	    	
	    	if (P >= K && P <= M) {
	    		
	    		if (S >= L && S <= N) {
	    			// case 1
	    			interception =  bigM.subtract(bigP).multiply(bigS.subtract(bigL)); // (M - P) * (S - L)
	    		} else if (Q >= L && Q <= N) {
	    			// case 3
	    			interception = bigM.subtract(bigP).multiply(bigN.subtract(bigQ)); // (M - P) * (N - Q)
	    		}
	    		
	    	} else if (R >= K && R <= M) {
	    		
	    		if (S >= L && S <= N) {
	    			// case 2
	    			interception = bigR.subtract(bigK).multiply(bigS.subtract(bigL)); //(R - K) * (S - L);
	    		} else if (Q >= L && Q <= N) {
	    			// case 4
	    			interception = bigR.subtract(bigK).multiply(bigN.subtract(bigQ)); // (R - K) * (N - Q);
	    		}
	    	}
	    	
	    	BigInteger answer = areaA.add(areaB).subtract(interception); // areaA + areaB - interception
	    	
	    	if (answer.compareTo(BigInteger.valueOf(2147483647L)) == 1) {
	    		return -1;
	    	} else {
				return answer.intValue();
			}
	    }
	}
}
