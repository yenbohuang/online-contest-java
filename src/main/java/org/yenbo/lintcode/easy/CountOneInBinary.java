package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class CountOneInBinary {

	@Test
	public void test1() {
		Assert.assertEquals(1, countOnes(32));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2, countOnes(5));
	}
	
	public int countOnes(int num) {
        
		int answer = 0;
		int tmp = num;
		
		while (tmp > 0) {
			answer += tmp % 2;
			tmp /= 2;
		}
		
		return answer;
    }
}
