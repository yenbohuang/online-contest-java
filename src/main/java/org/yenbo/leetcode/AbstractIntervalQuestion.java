package org.yenbo.leetcode;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractIntervalQuestion {

	protected Comparator<int[]> COMPARATOR = new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {

			if (o1[0] < o2[0]) {
				return -1;
			} else if (o1[0] == o2[0]) {

				if (o1[1] == o2[1]) {
					return 0;
				} else if (o1[1] > o2[1]) {
					return -1;
				} else {
					return 1;
				}
				
			} else {
				return 1;
			}
		}
	};
	
	protected boolean overlap(int[] i1, int[] i2) {
		
		int[] front;
		int[] end;
		
		if (i1[0] < i2[0]) {
			front = i1;
			end = i2;
		} else {
			front = i2;
			end = i1;
		}
		
		return (front[0] <= end[0] && front[1] >= end[1]) ||
				(front[0] <= end[0] && front[1] > end[0]) ||
				(front[1] == end[0]);
	}
	
	protected int[][] toArray(List<int[]> result) {
		
		int[][] answer = new int[result.size()][];
		
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}
}
