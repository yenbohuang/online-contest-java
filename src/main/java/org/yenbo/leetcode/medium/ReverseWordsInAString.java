package org.yenbo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * @author user
 *
 */
public class ReverseWordsInAString {

	@Test
	public void test1() {
		Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("world! hello", reverseWords("  hello world!  "));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("example good a", reverseWords("a good   example"));
	}
	
	public String reverseWords(String s) {
        
		if (s == null) {
			return null;
		}
		
		s = s.trim();
		
		if (s.length() == 0) {
			return s;
		}
		
		String[] tokens = s.split(" ");
		String answer = "";
		
		for (String t: tokens) {
			
			if (t.trim().length() > 0) {
				answer = t + " " + answer;
			}
		}
		
		return answer.trim();
    }
}
