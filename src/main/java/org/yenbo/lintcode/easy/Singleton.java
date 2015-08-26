package org.yenbo.lintcode.easy;

public class Singleton {

	static class Solution {
	    
		private static Solution instance;
		
	    public static Solution getInstance() {

	    	if (instance == null) {
	    		instance = new Solution();
	    	}
	    	
	    	return instance;
	    }
	};
}
