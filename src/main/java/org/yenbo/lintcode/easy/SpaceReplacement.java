package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class SpaceReplacement {

	@Test
	public void test1() {
		
		String question = "Mr John Smith";
		String answer = question.replace(" ", "%20");
		
		char[] string = new char[answer.length()];
		
		for (int i = 0; i < question.length(); i++) {
			string[i] = question.charAt(i);
		}
		
		Assert.assertEquals(17, replaceBlank(string, question.length()));
		Assert.assertArrayEquals(answer.toCharArray(), string);
	}
	
	@Test
	public void test2() {
		
		String question = "   ";
		String answer = question.replace(" ", "%20");
		
		char[] string = new char[answer.length()];
		
		for (int i = 0; i < question.length(); i++) {
			string[i] = question.charAt(i);
		}
		
		Assert.assertEquals(9, replaceBlank(string, question.length()));
		Assert.assertArrayEquals(answer.toCharArray(), string);
	}
	
	public int replaceBlank(char[] string, int length) {
        
		if (string == null || string.length == 0) {
			return 0;
		}
		
		for (int i = 0; i < length; i++) {
			
			if (string[i] == ' ') {
				
				for (int j = length - 1; j > i; j--) {
					string[j + 2] = string[j];
				}
				
				string[i] = '%';
				string[i + 1] = '2';
				string[i + 2] = '0';
				
				length += 2;
				i += 2;
			}
		}
		
		return length;
    }
}
