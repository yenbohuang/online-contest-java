package org.yenbo.lintcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Anagrams {

	@Test
	public void test1() {
		
		Assert.assertArrayEquals(new String[] {"lint", "intl", "inlt"},
				anagrams(new String[] {"lint", "intl", "inlt", "code"} ).toArray(new String[0]));
	}
	
	@Test
	public void test2() {
		
		Assert.assertArrayEquals(new String[] {"ab", "ba", "cd", "dc"},
				anagrams(new String[] {"ab", "ba", "cd", "dc", "e"} ).toArray(new String[0]));
	}
	
	public List<String> anagrams(String[] strs) {
        
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		
		for (String s: strs) {
			
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			
			String tmp = new String(charArray);
			
			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}
		
		for (String s: strs) {
			
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			
			String tmp = new String(charArray);
			
			if (map.get(tmp) > 1) {
				list.add(s);
			}
		}
		
		return list;
    }
}
