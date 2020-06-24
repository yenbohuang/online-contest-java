package org.yenbo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.AbstractIntervalQuestion;

/**
 * https://leetcode.com/problems/merge-intervals/
 * @author user
 *
 */
public class MergeIntervals extends AbstractIntervalQuestion {

	@Test
	public void test1() {
		
		int[][] list = new int[][] {
			{1,3},
			{2,6},
			{8,10},
			{15,18}
		};
		
		int[][] answer = merge(list);
		Assert.assertEquals(3, answer.length);
		Assert.assertArrayEquals(new int[] {1,6}, answer[0]);
		Assert.assertArrayEquals(new int[] {8,10}, answer[1]);
		Assert.assertArrayEquals(new int[] {15,18}, answer[2]);
	}
	
	@Test
	public void test2() {
		
		int[][] list = new int[][] {
			{2, 3},
			{4, 5},
			{6, 7},
			{8, 9},
			{1, 10}
		};
		
		int[][] answer = merge(list);
		
		Assert.assertEquals(1, answer.length);
		Assert.assertArrayEquals(new int[] {1,10}, answer[0]);
	}
	
	@Test
	public void test3() {
		
		int[][] list = new int[][] {
			{2, 3},
			{2, 2},
			{3, 3},
			{1, 3},
			{5, 7},
			{2, 2},
			{4, 6}
		};
		
		int[][] answer = merge(list);
		Assert.assertEquals(2, answer.length);
		Assert.assertArrayEquals(new int[] {1, 3}, answer[0]);
		Assert.assertArrayEquals(new int[] {4, 7}, answer[1]);
	}
	
	@Test
	public void test4() {
		Assert.assertArrayEquals(new int[][] {}, new int[][] {});
	}
	
	public int[][] merge(int[][] intervals) {
        
		List<int[]> answer = new ArrayList<int[]>();
		
		int length = (intervals == null) ? 0 : intervals.length;
		
		if (length == 0) {
			return new int[][] {};
		} else if (length < 2) {
			for (int i = 0; i < length; i++) {
				answer.add(intervals[i]);
			}
		} else {
			Arrays.parallelSort(intervals, COMPARATOR);
			
			int[] current = intervals[0];
			answer.add(current);
			
			for (int i = 1; i < length; i++) {
				
				if (overlap(current, intervals[i])) {
					current[0] = (intervals[i][0] < current[0]) ? intervals[i][0] : current[0];
					current[1] = (intervals[i][1] > current[1]) ? intervals[i][1] : current[1];
				} else {
					current = intervals[i];
					answer.add(current);
				}
			}
		}
		
		return toArray(answer);
    }
}
