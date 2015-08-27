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
	
	@Test
	public void test1() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		
		Queue<String> queue = new PriorityQueue<String>();
		for (String s: data) {
			queue.add(s);
		}
		
		MyQueue myQueue = new MyQueue(data);
		
		for (String s: data) {
			Assert.assertEquals(s, queue.poll());
			Assert.assertEquals(s, myQueue.poll());
			System.out.println(s);
		}
		
		System.out.println("-----------------");
	}
	
	@Test
	public void test2() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		data.add("b");
		
		Queue<String> queue = new PriorityQueue<String>();
		for (String s: data) {
			queue.add(s);
		}
		
		MyQueue myQueue = new MyQueue(data);
		
		for (String s: data) {
			Assert.assertEquals(s, queue.poll());
			Assert.assertEquals(s, myQueue.poll());
			System.out.println(s);
		}
		
		System.out.println("-----------------");
	}
	
	@Test
	public void test3() {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("a");
		data.add("b");
		data.add("c");
		
		Queue<String> queue = new PriorityQueue<String>();
		for (String s: data) {
			queue.add(s);
		}
		
		MyQueue myQueue = new MyQueue(data);
		
		for (String s: data) {
			Assert.assertEquals(s, queue.poll());
			Assert.assertEquals(s, myQueue.poll());
			System.out.println(s);
		}
		
		System.out.println("-----------------");
	}
}
