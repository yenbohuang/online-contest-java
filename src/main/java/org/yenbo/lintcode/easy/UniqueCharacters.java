package org.yenbo.lintcode.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class UniqueCharacters {

	@Test
	public void test1() {
		Assert.assertTrue(isUnique("abc"));
	}
	
	@Test
	public void test2() {
		Assert.assertFalse(isUnique("aab"));
	}
	
	public boolean isUnique(String str) {
        
		if (str == null || str.length() <= 1) {
			return true;
		}
		
		char[] array = str.toCharArray();
		Arrays.sort(array);
		
		for (int i = 1; i < array.length; i++) {
			
			if (array[i - 1] == array[i]) {
				return false;
			}
		}
		
		return true;
    }
}
