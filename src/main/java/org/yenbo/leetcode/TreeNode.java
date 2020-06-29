package org.yenbo.leetcode;

public class TreeNode {

	public int val;
	public TreeNode left, right;

	public TreeNode() {}
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right) {
		 this.val = val;
		 this.left = left;
		 this.right = right;
	}
	
	@Override
	public String toString() {
		return Integer.toString(val);
	}
}
