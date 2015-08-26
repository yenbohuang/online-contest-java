package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInAString {

	@Test
	public void test() {
		Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
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
