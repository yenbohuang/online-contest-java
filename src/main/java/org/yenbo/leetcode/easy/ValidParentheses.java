package org.yenbo.leetcode.easy;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author user
 *
 */
public class ValidParentheses {

	@Test
	public void test1() {
		Assert.assertTrue(isValid("()"));
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(isValid("()[]{}"));
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(isValid("(]"));
	}
	
	@Test
	public void test4() {
		Assert.assertFalse(isValid("([)]"));
	}
	
	@Test
	public void test5() {
		Assert.assertTrue(isValid("([])"));
	}
	
	@Test
	public void test6() {
		Assert.assertFalse(isValid("[])"));
	}
	
	@Test
	public void test7() {
		Assert.assertTrue(isValid("[{()}]"));
	}
	
	@Test
	public void test8() {
		Assert.assertFalse(isValid("[([]])"));
	}
	
	public boolean isValid(String s) {
        
		if (s == null || s.length() % 2 == 1) {
			return false;
		} else if (s.length() == 0) {
			return true;
		}
		
		int size = s.length();
		
		// incorrect start or end
		char first = s.charAt(0);
		char last = s.charAt(size - 1);
		if (first == ')' || first == ']' || first == '}' ||
				last == '(' || last == '[' || last == '{') {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for (char c: s.toCharArray()) {
			
			if (c == ')') {
				
				if ('(' != stack.pop()) {
					return false;
				}
				
			} else if (c == '}') {
				
				if ('{' != stack.pop()) {
					return false;
				}
				
			} else if (c == ']') {
				
				if ('[' != stack.pop()) {
					return false;
				}
				
			} else {
				stack.add(c);
			}
		}
		
		return true;
    }
	
}
