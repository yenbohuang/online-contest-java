package org.yenbo.lintcode.easy.interval;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.Interval;

public class InsertInterval {
	
	@Test
	public void test1() {
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(5, 9));
		
		ArrayList<Interval> answer = insert(intervals, new Interval(2, 5));
		
		Assert.assertEquals(1, answer.size());
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(9, answer.get(0).end);
	}
	
	@Test
	public void test2() {
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(5, 9));
		
		ArrayList<Interval> answer = insert(intervals, new Interval(3, 4));
		
		Assert.assertEquals(3, answer.size());
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(2, answer.get(0).end);
		
		Assert.assertEquals(3, answer.get(1).start);
		Assert.assertEquals(4, answer.get(1).end);
		
		Assert.assertEquals(5, answer.get(2).start);
		Assert.assertEquals(9, answer.get(2).end);
	}
	
	@Test
	public void test3() {
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		
		ArrayList<Interval> answer = insert(intervals, new Interval(5, 7));
		
		Assert.assertEquals(1, answer.size());
		Assert.assertEquals(5, answer.get(0).start);
		Assert.assertEquals(7, answer.get(0).end);
	}
	
	@Test
	public void test4() {
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		
		ArrayList<Interval> answer = insert(intervals, new Interval(2, 3));
		
		Assert.assertEquals(1, answer.size());
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(5, answer.get(0).end);
	}
	
	@Test
	public void test5() {
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		
		ArrayList<Interval> answer = insert(intervals, new Interval(2, 7));
		
		Assert.assertEquals(1, answer.size());
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(7, answer.get(0).end);
	}
	
	@Test
	public void test6() {
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		
		ArrayList<Interval> answer = insert(intervals, new Interval(1, 7));
		
		Assert.assertEquals(1, answer.size());
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(7, answer.get(0).end);
	}
	
	@Test
	public void test7() {
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(7, 8));
		intervals.add(new Interval(10, 13));
		
		ArrayList<Interval> answer = insert(intervals, new Interval(9, 9));
		
		Assert.assertEquals(4, answer.size());
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(5, answer.get(0).end);
		
		Assert.assertEquals(7, answer.get(1).start);
		Assert.assertEquals(8, answer.get(1).end);
		
		Assert.assertEquals(9, answer.get(2).start);
		Assert.assertEquals(9, answer.get(2).end);
		
		Assert.assertEquals(10, answer.get(3).start);
		Assert.assertEquals(13, answer.get(3).end);
	}
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		if (intervals.isEmpty()) {
			result.add(newInterval);
		} else if (intervals.get(0).start > newInterval.end) {
			result.add(newInterval);
			result.addAll(intervals);
		} else if (intervals.get(intervals.size() - 1).end < newInterval.start) {
			result.addAll(intervals);
			result.add(newInterval);
		} else {
			
			for (Interval i: intervals) {
				
				if (overlap(i, newInterval)) {
					
					newInterval.start = (i.start < newInterval.start)?
							i.start : newInterval.start;
					newInterval.end = (i.end > newInterval.end) ?
							i.end : newInterval.end;
					
					if (false == result.contains(newInterval)) {
						result.add(newInterval);
					}
					
				} else if (i.end < newInterval.start) {
					result.add(i);
				} else {
					
					if (false == result.contains(newInterval)) {
						result.add(newInterval);
					}
					
					result.add(i);
				}
			}
		}
		
		return result;
	}
	
	private boolean overlap(Interval i1, Interval i2) {
		
		Interval front;
		Interval end;
		
		if (i1.start < i2.start) {
			front = i1;
			end = i2;
		} else {
			front = i2;
			end = i1;
		}
		
		return (front.start <= end.start && front.end >= end.end) ||
				(front.start <= end.start && front.end > end.start) ||
				(front.end == end.start);
	}
}
