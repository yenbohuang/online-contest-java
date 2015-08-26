package org.yenbo.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

public class RecoverRotatedSortedArray {

	@Test
	public void test() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		
		recoverRotatedSortedArray(list);
		Assert.assertEquals("[1, 2, 3, 4, 5]", list.toString());
	}
	
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		Collections.sort(nums);
    }
}
