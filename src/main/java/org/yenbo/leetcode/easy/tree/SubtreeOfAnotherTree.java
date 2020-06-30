package org.yenbo.leetcode.easy.tree;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * @author user
 *
 */
public class SubtreeOfAnotherTree {

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
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
        
		if (t == null) {
			return true;
		} else if (s == null) {
			return false;
		} else {
			return compare(s, t) ||
					(s.left != null && isSubtree(s.left, t)) || 
					(s.right != null && isSubtree(s.right, t));
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
