package org.yenbo.lintcode.easy.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.Interval;

public class MergeIntervals {

	@Test
	public void test1() {
		
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(15, 18));
		
		List<Interval> answer = merge(list);
		Assert.assertEquals(3, answer.size());
		
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(6, answer.get(0).end);
		
		Assert.assertEquals(8, answer.get(1).start);
		Assert.assertEquals(10, answer.get(1).end);
		
		Assert.assertEquals(15, answer.get(2).start);
		Assert.assertEquals(18, answer.get(2).end);
	}
	
	@Test
	public void test2() {
		
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(2, 3));
		list.add(new Interval(4, 5));
		list.add(new Interval(6, 7));
		list.add(new Interval(8, 9));
		list.add(new Interval(1, 10));
		
		List<Interval> answer = merge(list);
		Assert.assertEquals(1, answer.size());
		
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(10, answer.get(0).end);
	}
	
	@Test
	public void test3() {
		
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(2, 3));
		list.add(new Interval(2, 2));
		list.add(new Interval(3, 3));
		list.add(new Interval(1, 3));
		list.add(new Interval(5, 7));
		list.add(new Interval(2, 2));
		list.add(new Interval(4, 6));
		
		List<Interval> answer = merge(list);
		Assert.assertEquals(2, answer.size());
		
		Assert.assertEquals(1, answer.get(0).start);
		Assert.assertEquals(3, answer.get(0).end);
		
		Assert.assertEquals(4, answer.get(1).start);
		Assert.assertEquals(7, answer.get(1).end);
	}
	
	public static final Comparator<Interval> COMPARATOR = 
			new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {

			if (o1.start < o2.start) {
				return -1;
			} else if (o1.start == o2.start) {

				if (o1.end == o2.end) {
					return 0;
				} else if (o1.end > o2.end) {
					return -1;
				} else {
					return 1;
				}
				
			} else {
				return 1;
			}
		}
	};
	
	public List<Interval> merge(List<Interval> intervals) {
        
		List<Interval> answer = new ArrayList<Interval>();
		
		if (intervals.size() < 2) {
			answer.addAll(intervals);
		} else {
			
			Collections.sort(intervals, COMPARATOR);
			
			Interval current = intervals.get(0);
			answer.add(current);
			
			for (int i = 1; i < intervals.size(); i++) {
				
				if (overlap(current, intervals.get(i))) {
					current.start = (intervals.get(i).start < current.start) ?
							intervals.get(i).start : current.start;
					current.end = (intervals.get(i).end > current.end) ?
							intervals.get(i).end : current.end;
				} else {
					current = intervals.get(i);
					answer.add(current);
				}
			}
		}
		
		return answer;
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
