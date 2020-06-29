package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * @author user
 *
 */
public class BalancedBinaryTree {

	@Test
	public void test1() {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		Assert.assertTrue(isBalanced(root));
	}
	
	@Test
	public void test2() {
		
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		Assert.assertFalse(isBalanced(root));
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(isBalanced(null));
	}
	
	@Test
	public void test4() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		root.left.left.left.left = new TreeNode(16);
		
		Assert.assertTrue(isBalanced(root));
	}
	
	private boolean balanced = true;
	
	public boolean isBalanced(TreeNode root) {
        
		if (root == null) {
			return true;
		}
		
		findNode(root, 1);
		
		return balanced;
    }
	
	private int findNode(TreeNode node, int depth) {
		
		if (node.left == null && node.right == null) {
			return depth;
		}
		
		int leftDepth = depth;
		int rightDepth = depth;
		
		if (node.left != null) {
			leftDepth = findNode(node.left, depth + 1);
		}
		
		if (node.right != null) {
			rightDepth = findNode(node.right, depth + 1);
		}
		
		if (Math.abs(rightDepth - leftDepth) > 1) {
			balanced = false;
		}
		
		return Math.max(rightDepth , leftDepth);
	}
}
