package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * This one is not easy. So, I Googled. :p
 * 
 * http://www.glassdoor.com/Interview/You-are-climbing-a-stair-case-Each-time-you-can-either-make-1-step-or-2-steps-The-staircase-has-n-steps-In-how-many-dist-QTN_133071.htm
 * 
 * @author YENBO.HUANG
 *
 */
public class ClimbingStairs {

	@Test
	public void test() {
		Assert.assertEquals(3, climbStairs(3));
	}
	
	public int climbStairs(int n) {
		
		// Fibonacci
		if (n <= 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;

        int[] steps = new int[n + 1];
        
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }
}
