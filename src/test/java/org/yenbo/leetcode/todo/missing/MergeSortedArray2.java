package org.yenbo.leetcode.todo.missing;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArray2 {

	@Test
	public void test1() {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(2);
		B.add(4);
		B.add(5);
		B.add(6);
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(1);
		answer.add(2);
		answer.add(2);
		answer.add(3);
		answer.add(4);
		answer.add(4);
		answer.add(5);
		answer.add(6);
		
		Assert.assertArrayEquals(answer.toArray(new Integer[0]), mergeSortedArray(A, B).toArray(new Integer[0]));
	}
	
	@Test
	public void test2() {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(7);
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(5);
		B.add(7);
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(5);
		answer.add(7);
		answer.add(7);
		
		Assert.assertArrayEquals(answer.toArray(new Integer[0]), mergeSortedArray(A, B).toArray(new Integer[0]));
	}
	
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.addAll(A);
		
		for (int b: B) {
			
			boolean inserted = false;
			
			for (int i = 0; i < answer.size(); i++) {
				
				if (answer.get(i) > b) {
					inserted = true;
					answer.add(i, b);
					break;
				}
			}
			
			if (inserted == false) {
				answer.add(b);
			}
		}
				
		return answer;
	}
}
