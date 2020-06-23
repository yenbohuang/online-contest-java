package org.yenbo.leetcode.todo.easy;

import java.util.ArrayDeque;
import java.util.Deque;

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
		Assert.assertTrue(isValidParentheses("()"));
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(isValidParentheses("()[]{}"));
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(isValidParentheses("(]"));
	}
	
	@Test
	public void test4() {
		Assert.assertFalse(isValidParentheses("([)]"));
	}
	
	@Test
	public void test5() {
		Assert.assertTrue(isValidParentheses("([])"));
	}
	
	@Test
	public void test6() {
		Assert.assertFalse(isValidParentheses("[])"));
	}
	
	@Test
	public void test7() {
		Assert.assertTrue(isValidParentheses("[{()}]"));
	}
	
	@Test
	public void test8() {
		Assert.assertFalse(isValidParentheses("[([]])"));
	}
	
	public boolean isValidParentheses(String s) {
        
		if (s == null || s.length() % 2 == 1) {
			return false;
		} else if (s.length() == 0) {
			return true;
		}
		
		int size = s.length();
		char[] charArray = s.toCharArray();
		
		// incorrect start or end
		if (charArray[0] == ')' || charArray[0] == ']' || charArray[0] == '}' ||
				charArray[size - 1] == '(' || charArray[size -1] == '[' || charArray[size - 1] == '{') {
			return false;
		}
		
		int numOfOpen1 = charArray[0] == '(' ? 1 : 0;
		int numOfOpen2 = charArray[0] == '[' ? 1 : 0;
		int numOfOpen3 = charArray[0] == '{' ? 1 : 0;
		
		int numOfClosed1 = 0;
		int numOfClosed2 = 0;
		int numOfClosed3 = 0;
		
		for (int i = 1; i < size; i++) {
			
			char c = charArray[i];
			char prev = charArray[i - 1];
			
			// exclude wrong combinations
			if ((prev == '(' && c == ']') || (prev == '(' && c == '}') ||
					(prev == '[' && c == ')') || (prev == '[' && c == '}') ||
					(prev == '{' && c == ')') || (prev == '{' && c == ']')) {
				return false;
			}
			
			switch(c) {
			case '(':
				numOfOpen1++;
				break;
			case ')':
				numOfClosed1++;
				break;
			case '[':
				numOfOpen2++;
				break;
			case ']':
				numOfClosed2++;
				break;
			case '{':
				numOfOpen3++;
				break;
			case '}':
				numOfClosed3++;
				break;
			}
		}
		
		return (numOfOpen1 == numOfClosed1 && numOfOpen2 == numOfClosed2 && numOfOpen3 == numOfClosed3);
    }
	
	public boolean isValidParenthesesFailVersion2(String s) {
        
		if (s == null || s.length() % 2 == 1) {
			return false;
		} else if (s.length() == 0) {
			return true;
		}
		
		int size = s.length();
		
		Deque<Character> stack1 = new ArrayDeque<Character>(); // ()
		Deque<Character> stack2 = new ArrayDeque<Character>(); // []
		Deque<Character> stack3 = new ArrayDeque<Character>(); // {}
		
		char[] charArray = s.toCharArray();
		
		if (charArray[0] == '(') {
			stack1.add(charArray[0]);
		} else if (charArray[0] == '[') {
			stack2.add(charArray[0]);
		} else if (charArray[0] == '{') {
			stack3.add(charArray[0]);
		}
		
		for (int i = 1; i < size; i++) {
			
			char c = charArray[i];
			char prev = charArray[i - 1];
			
			if (c == '(' || c == ')') {
				
				if ((prev == '[' && c == ')') ||
						(prev == '{' && c == ')')) {
					return false;
				}
				
				stack1.add(c);
			} else if (c == '[' || c == ']') {
				
				if ((prev == ']' && c == '(') ||
						(prev == ']' && c == '{')) {
					return false;
				}
				
				stack2.add(c);
			} else if (c == '{' || c == '}') {
				
				if ((prev == '}' && c == '[') ||
						(prev == '}' && c == '(')) {
					return false;
				}
				
				stack3.add(c);
			}
		}
		
		if (false == stack1.isEmpty() && stack1.peekLast() != ')') {
			return false;
		}
		
		if (false == stack2.isEmpty() && stack2.peekLast() != ']') {
			return false;
		}
		
		if (false == stack3.isEmpty() && stack3.peekLast() != '}') {
			return false;
		}
		
		return true;
    }
	
	public boolean isValidParenthesesFailedVersion(String s) {
        
		if (s == null || s.length() % 2 == 1) {
			return false;
		} else if (s.length() == 0) {
			return true;
		}
		
		int size = s.length();
		
		Deque<Character> stack1 = new ArrayDeque<Character>(); // ()
		Deque<Character> stack2 = new ArrayDeque<Character>(); // []
		Deque<Character> stack3 = new ArrayDeque<Character>(); // {}
		
		char[] charArray = s.toCharArray();
		
		if (charArray[0] == '(') {
			stack1.add(charArray[0]);
		} else if (charArray[0] == '[') {
			stack2.add(charArray[0]);
		} else if (charArray[0] == '{') {
			stack3.add(charArray[0]);
		}
		
		for (int i = 1; i < size; i++) {
			
			char c = charArray[i];
			char prev = charArray[i - 1];
			
			if (c == '(' || (c == ')' && prev == '(')) {
				stack1.add(c);
			} else if (c == '[' || (c == ']' && prev == '[')) {
				stack2.add(c);
			} else if (c == '{' || (c == '}' && prev == '{')) {
				stack3.add(c);
			} else if (c == ')') {
				
				if ((stack1.isEmpty() || stack1.peekLast() != '(') ||
						(false == stack2.isEmpty() && stack2.peekLast() == '[') ||
						(false == stack3.isEmpty() && stack3.peekLast() == '{')) {
					return false;
				} else {
					stack1.add(c);
				}
				
			} else if (c == ']') {
				
				if ((stack2.isEmpty() || stack2.peekLast() != '[') ||
						(false == stack1.isEmpty() && stack1.peekLast() == '(') ||
						(false == stack3.isEmpty() && stack3.peekLast() == '{')) {
					return false;
				} else {
					stack2.add(c);
				}
				
			} else if (c == '}') {
				
				if ((stack3.isEmpty() || stack3.peekLast() != '{') ||
						(false == stack1.isEmpty() && stack1.peekLast() == '(') ||
						(false == stack2.isEmpty() && stack2.peekLast() == '[')) {
					return false;
				} else {
					stack3.add(c);
				}
			}
		}
		
		if (false == stack1.isEmpty() && stack1.peekLast() != ')') {
			return false;
		}
		
		if (false == stack2.isEmpty() && stack2.peekLast() != ']') {
			return false;
		}
		
		if (false == stack3.isEmpty() && stack3.peekLast() != '}') {
			return false;
		}
		
		return true;
    }
}
