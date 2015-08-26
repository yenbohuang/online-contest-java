package org.yenbo.lintcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class GasStation {

	@Test
	public void test() {
		Assert.assertEquals(2, canCompleteCircuit(
				new int[] {1,1,3,1}, new int[] {2,2,1,1}));
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
