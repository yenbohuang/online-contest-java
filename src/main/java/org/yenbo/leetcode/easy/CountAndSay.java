package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/count-and-say/
 * @author user
 *
 */
public class CountAndSay {

	@Test
	public void test1() {
		Assert.assertEquals("1", countAndSay(1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("11", countAndSay(2));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("21", countAndSay(3));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals("1211", countAndSay(4));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals("111221", countAndSay(5));
	}
	
	public String countAndSay(int n) {
		
        if (n < 1) {
			throw new IllegalArgumentException("n == 0");
		} else  {
		
			String answer = "1";
			
			for (int i = 1; i < n; i++) {
				
				String tmp = "";
				
				int count = 0;
				
				for (int j = 0; j < answer.length(); j++) {
					
					if (j == 0) {
						count = 1;
					} else {
						
						if (answer.charAt(j) == answer.charAt(j - 1)) {
							count++;
						} else {
							tmp += Integer.toString(count) + answer.charAt(j - 1);
							count = 1;
						}
					}
				}
				
				answer = tmp + Integer.toString(count) + answer.charAt(answer.length() - 1);
			}
			
			return answer;
		}
    }
}
