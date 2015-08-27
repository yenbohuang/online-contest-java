package org.yenbo.jp.com.lnfkk;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class Permutation {

	@Test
	public void test1() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		
		ArrayList<String> answer = permutate(data);
		
		Assert.assertEquals("size", 1, answer.size());
		Assert.assertEquals("a", answer.get(0));
		
		for (String s: answer) {
			System.out.println(s);
		}
		
		System.out.println("----------------------------------");
	}
	
	@Test
	public void test2() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		data.add("b");
		
		ArrayList<String> answer = permutate(data);
		Assert.assertEquals("size", 4, answer.size());
		Assert.assertEquals("aa", answer.get(0));
		Assert.assertEquals("ab", answer.get(1));
		Assert.assertEquals("ba", answer.get(2));
		Assert.assertEquals("bb", answer.get(3));
		
		for (String s: answer) {
			System.out.println(s);
		}
		
		System.out.println("----------------------------------");
	}
	
	@Test
	public void test3() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		data.add("b");
		data.add("c");
		
		ArrayList<String> answer = permutate(data);
		
		Assert.assertEquals("size", 27, answer.size());
		Assert.assertEquals("aaa", answer.get(0));
		Assert.assertEquals("aab", answer.get(1));
		Assert.assertEquals("aac", answer.get(2));
		Assert.assertEquals("aba", answer.get(3));
		Assert.assertEquals("abb", answer.get(4));
		Assert.assertEquals("abc", answer.get(5));
		Assert.assertEquals("aca", answer.get(6));
		Assert.assertEquals("acb", answer.get(7));
		Assert.assertEquals("acc", answer.get(8));
		Assert.assertEquals("baa", answer.get(9));
		Assert.assertEquals("bab", answer.get(10));
		Assert.assertEquals("bac", answer.get(11));
		Assert.assertEquals("bba", answer.get(12));
		Assert.assertEquals("bbb", answer.get(13));
		Assert.assertEquals("bbc", answer.get(14));
		Assert.assertEquals("bca", answer.get(15));
		Assert.assertEquals("bcb", answer.get(16));
		Assert.assertEquals("bcc", answer.get(17));
		Assert.assertEquals("caa", answer.get(18));
		Assert.assertEquals("cab", answer.get(19));
		Assert.assertEquals("cac", answer.get(20));
		Assert.assertEquals("cba", answer.get(21));
		Assert.assertEquals("cbb", answer.get(22));
		Assert.assertEquals("cbc", answer.get(23));
		Assert.assertEquals("cca", answer.get(24));
		Assert.assertEquals("ccb", answer.get(25));
		Assert.assertEquals("ccc", answer.get(26));
		
		for (String s: answer) {
			System.out.println(s);
		}
		
		System.out.println("----------------------------------");
	}
	
	public ArrayList<String> permutate(ArrayList<String> data) {
		
		if (data== null || data.isEmpty()) {
			throw new IllegalArgumentException("data is null or empty");
		}
		
		ArrayList<String> answer = new ArrayList<String>();
		recursive(answer, data, 1, "");
		
		return answer;
	}
	
	private void recursive(ArrayList<String> answer, ArrayList<String> data, int level, String element) {
		
		int size = data.size();
		
		if (level > size) {
			answer.add(element);
			return;
		}
		
		for (int i = 0; i < size; i++) {
			recursive(answer, data, level + 1, element + data.get(i));
		}
	}
}
