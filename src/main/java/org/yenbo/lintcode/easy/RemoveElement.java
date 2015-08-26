package org.yenbo.lintcode.easy;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class RemoveElement {

	@Test
	public void test() {
		Assert.assertEquals(4, removeElement(new int[] {0,4,4,0,0,2,4,4}, 4));
	}
	
	public int removeElement(int[] A, int elem) {
        
		if (A == null) {
			return 0;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int a: A) {
			
			if (a != elem) {
				list.add(a);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			A[i] = list.get(i).intValue();
		}
		
		return list.size();
    }
}
