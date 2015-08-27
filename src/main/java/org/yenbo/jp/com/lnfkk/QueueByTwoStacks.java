package org.yenbo.jp.com.lnfkk;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class QueueByTwoStacks {

	public class MyQueue {
		
		private Stack<String> inputStack = new Stack<String>();
		private Stack<String> outputStack = new Stack<String>();
		
		public MyQueue(ArrayList<String> list) {
			
			if (list == null || list.isEmpty()) {
				throw new IllegalArgumentException("list is null or empty");
			}
			
			for (String s: list) {
				inputStack.add(s);
			}
			
			int size = list.size();
			
			for (int i = 0; i < size; i++) {
				outputStack.add(inputStack.pop());
			}
		}
		
		public String poll() {
			return outputStack.pop();
		}
	}
	
	private void test(ArrayList<String> data) {
		
		Queue<String> queue = new PriorityQueue<String>();
		queue.addAll(data);
		
		MyQueue myQueue = new MyQueue(data);
		
		int size = data.size();
		
		for (int i = 0; i < size; i++) {
			
			String s = queue.poll();
			Assert.assertEquals(s, myQueue.poll());
			System.out.println(String.format("%d : %s", i, s));
		}
		
		System.out.println("-----------------");
	}
	
	@Test
	public void test1() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		
		test(data);
	}
	
	@Test
	public void test2() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		data.add("b");
		
		test(data);
	}
	
	@Test
	public void test3() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		data.add("b");
		data.add("c");
		
		test(data);
	}
}
