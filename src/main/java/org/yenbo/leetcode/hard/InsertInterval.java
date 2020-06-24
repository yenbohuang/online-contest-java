package org.yenbo.leetcode.hard;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.AbstractIntervalQuestion;

/**
 * https://leetcode.com/problems/insert-interval/
 * @author user
 *
 */
public class InsertInterval extends AbstractIntervalQuestion {
	
	@Test
	public void test1() {
		
		int[][] intervals = new int[][] {
			{1,2},
			{5,9}
		};
		
		int[][] answer = insert(intervals, new int[] {2, 5});
		
		Assert.assertEquals(1, answer.length);
		Assert.assertArrayEquals(new int[] {1,9}, answer[0]);
	}
	
	@Test
	public void test2() {
		
		int[][] intervals = new int[][] {
			{1, 2},
			{5, 9}
		};
		
		int[][] answer = insert(intervals, new int[] {3, 4});
		
		Assert.assertEquals(3, answer.length);
		Assert.assertArrayEquals(new int[] {1,2}, answer[0]);
		Assert.assertArrayEquals(new int[] {3,4}, answer[1]);
		Assert.assertArrayEquals(new int[] {5,9}, answer[2]);
	}
	
	@Test
	public void test3() {
		
		int[][] intervals = new int[][] {};
		
		int[][] answer = insert(intervals, new int[] {5, 7});
		
		Assert.assertEquals(1, answer.length);
		Assert.assertArrayEquals(new int[] {5,7}, answer[0]);
	}
	
	@Test
	public void test4() {
		
		int[][] intervals = new int[][] {
			{1,5}
		};
		
		int[][] answer = insert(intervals, new int[] {2, 3});
		
		Assert.assertEquals(1, answer.length);
		Assert.assertArrayEquals(new int[] {1,5}, answer[0]);
	}
	
	@Test
	public void test5() {
		
		int[][] intervals = new int[][] {
			{1,5}
		};
		
		int[][] answer = insert(intervals, new int[] {2, 7});
		
		Assert.assertEquals(1, answer.length);
		Assert.assertArrayEquals(new int[] {1,7}, answer[0]);
	}
	
	@Test
	public void test6() {
		
		int[][] intervals = new int[][] {
			{1,5}
		};
		
		int[][] answer = insert(intervals, new int[] {1, 7});
		
		Assert.assertEquals(1, answer.length);
		Assert.assertArrayEquals(new int[] {1,7}, answer[0]);
	}
	
	@Test
	public void test7() {
		
		int[][] intervals = new int[][] {
			{1,5},
			{7,8},
			{10,13}
		};
		
		int[][] answer = insert(intervals, new int[] {9, 9});
		
		Assert.assertEquals(4, answer.length);
		Assert.assertArrayEquals(new int[] {1,5}, answer[0]);
		Assert.assertArrayEquals(new int[] {7,8}, answer[1]);
		Assert.assertArrayEquals(new int[] {9,9}, answer[2]);
		Assert.assertArrayEquals(new int[] {10,13}, answer[3]);
	}
	
	@Test
	public void test8() {
		
		int[][] intervals = new int[][] {
			{1,3},
			{6,9}
		};
		
		int[][] answer = insert(intervals, new int[] {2,5});
		
		Assert.assertEquals(2, answer.length);
		Assert.assertArrayEquals(new int[] {1,5}, answer[0]);
		Assert.assertArrayEquals(new int[] {6,9}, answer[1]);
	}
	
	@Test
	public void test9() {
		
		int[][] intervals = new int[][] {
			{1,2},
			{3,5},
			{6,7},
			{8,10},
			{12,16}
		};
		
		int[][] answer = insert(intervals, new int[] {4,8});
		
		Assert.assertEquals(3, answer.length);
		Assert.assertArrayEquals(new int[] {1,2}, answer[0]);
		Assert.assertArrayEquals(new int[] {3,10}, answer[1]);
		Assert.assertArrayEquals(new int[] {12,16}, answer[2]);
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		
		ArrayList<int[]> result = new ArrayList<int[]>();
		
		int length = (intervals == null) ? 0 : intervals.length;
		
		if (length == 0) {
			
			result.add(newInterval);
			
		} else if (intervals[0][0] > newInterval[1]) {
			
			result.add(newInterval);
			
			for (int i = 0; i < length; i++) {
				result.add(intervals[i]);
			}
			
		} else if (intervals[length - 1][1] < newInterval[0]) {
			
			for (int i = 0; i < length; i++) {
				result.add(intervals[i]);
			}
			
			result.add(newInterval);
			
		} else {
			
			for (int[] i: intervals) {
				
				if (overlap(i, newInterval)) {
					
					newInterval[0] = (i[0] < newInterval[0]) ? i[0] : newInterval[0];
					newInterval[1] = (i[1] > newInterval[1]) ? i[1] : newInterval[1];
					
					if (false == result.contains(newInterval)) {
						result.add(newInterval);
					}
					
				} else if (i[1] < newInterval[0]) {
					result.add(i);
				} else {
					
					if (false == result.contains(newInterval)) {
						result.add(newInterval);
					}
					
					result.add(i);
				}
			}
		}
		
		return toArray(result);
	}
}
