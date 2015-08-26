package org.yenbo.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class MajorityNumber {

	@Test
	public void test() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		
		Assert.assertEquals(1, majorityNumber(list));
	}
	
	public int majorityNumber(ArrayList<Integer> nums) {

		int answer = 0;
		int max = 0;
		
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		
		for (Integer i: nums) {
			
			if (countMap.containsKey(i)) {
				countMap.put(i, countMap.get(i) + 1);
			} else {
				countMap.put(i, 1);
			}
		}
		
		for (Integer i: countMap.keySet()) {
			
			if (countMap.get(i) > max) {
				answer = i;
				max = countMap.get(i);
			}
		}
		
		return answer;
    }
}
