package org.yenbo.lintcode.easy.tree;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

public class Subtree {

	@Test
	public void test1() {
		
		TreeNode T1 = new TreeNode(1);
		T1.left = new TreeNode(2);
		T1.right = new TreeNode(3);
		T1.right.left = new TreeNode(4);
		
		TreeNode T2 = new TreeNode(3);
		T2.left = new TreeNode(4);
		
		Assert.assertTrue(isSubtree(T1, T2));
	}
	
	@Test
	public void test2() {
		
		TreeNode T1 = new TreeNode(1);
		T1.left = new TreeNode(2);
		T1.right = new TreeNode(3);
		T1.right.left = new TreeNode(4);
		
		TreeNode T2 = new TreeNode(3);
		T2.right = new TreeNode(4);
		
		Assert.assertFalse(isSubtree(T1, T2));
	}
	
	@Test
	public void test3() {
		
		TreeNode T1 = null;
		
		TreeNode T2 = new TreeNode(3);
		T2.right = new TreeNode(4);
		
		Assert.assertFalse(isSubtree(T1, T2));
	}
	
	@Test
	public void test4() {
		
		TreeNode T1 = new TreeNode(1);
		T1.left = new TreeNode(2);
		T1.right = new TreeNode(3);
		T1.right.left = new TreeNode(4);
		
		TreeNode T2 = null;
		
		Assert.assertTrue(isSubtree(T1, T2));
	}
	
	@Test
	public void test5() {
		Assert.assertTrue(isSubtree(null, null));
	}
	
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
        
		if (T2 == null) {
			return true;
		} else if (T1 == null) {
			return false;
		} else {
			return compare(T1, T2) ||
					(T1.left != null && isSubtree(T1.left, T2)) || 
					(T1.right != null && isSubtree(T1.right, T2));
		}
    }
	
	private boolean compare(TreeNode node1, TreeNode node2) {
		
		if (node1 == null && node2 == null) {
			return true;
		} if (node1 != null && node2 != null && node1.val == node2.val) {
			 return compare(node1.left, node2.left) &&
					 compare(node1.right, node2.right);
		} else {
			return false;
		}
	}
}
