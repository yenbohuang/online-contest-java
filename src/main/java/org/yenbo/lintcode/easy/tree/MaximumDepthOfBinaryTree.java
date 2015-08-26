package org.yenbo.lintcode.easy.tree;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.TreeNode;

public class MaximumDepthOfBinaryTree {
	
	@Test
	public void test() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		Assert.assertEquals(3, maxDepth(root));
	}
	
	public int maxDepth(TreeNode root) {
        
		if (root == null) {
			return 0;
		}
		
		return findNode(root, 1);
    }
	
	private int findNode(TreeNode node, int depth) {
		
		if (node.left == null && node.right == null) {
			return depth;
		}
		
		int leftDepth = -1;
		int rightDepth = -1;
		
		if (node.left != null) {
			leftDepth = findNode(node.left, depth + 1);
		}
		
		if (node.right != null) {
			rightDepth = findNode(node.right, depth + 1);
		}
		
		return (rightDepth > leftDepth) ? rightDepth : leftDepth;
	}
}
