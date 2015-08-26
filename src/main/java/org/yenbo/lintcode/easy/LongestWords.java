package org.yenbo.lintcode.easy;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class LongestWords {

	@Test
	public void test1() {

		String[] dictionary = new String[] { "dog", "google", "facebook",
				"internationalization", "blabla" };

		Assert.assertEquals("[internationalization]",
				longestWords(dictionary).toString());
	}

	@Test
	public void test2() {

		String[] dictionary = new String[] { "like", "love", "hate", "yes" };

		Assert.assertEquals("[like, love, hate]",
				longestWords(dictionary).toString());
	}

	ArrayList<String> longestWords(String[] dictionary) {
		
		ArrayList<String> answer = new ArrayList<String>();
		
		if (dictionary != null) {
			
			int max = -1;
			
			for (String str: dictionary) {
				if (str.length() > max) {
					max = str.length();
				}
			}
			
			for (String str: dictionary) {
				if (str.length() == max) {
					answer.add(str);
				}
			}
		}
		
		return answer;
	}
}
