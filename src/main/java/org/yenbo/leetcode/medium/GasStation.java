package org.yenbo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/gas-station/
 * @author user
 *
 */
public class GasStation {

	@Test
	public void test1() {
		Assert.assertEquals(2, canCompleteCircuit(
				new int[] {1,1,3,1}, new int[] {2,2,1,1}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(3, canCompleteCircuit(
				new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(-1, canCompleteCircuit(
				new int[] {2,3,4}, new int[] {3,4,3}));
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        
		int size = gas.length;
		
		for (int i = 0; i < size; i++) {
			
			int inTank = 0;
			
			for (int j = 0; j < size; j++) {
				
				int index = (i + j) % size;
				inTank += (gas[index] - cost[index]);
				
				if (inTank < 0) {
					break;
				}
			}
			
			if (inTank >= 0) {
				return i;
			}
		}
		
		return -1;
    }
}
