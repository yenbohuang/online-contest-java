package org.yenbo.lintcode.easy.tree;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.TreeNode;

public class InvertBinaryTree {

	@Test
	public void test() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		
		invertBinaryTree(root);
		
		Assert.assertEquals(1, root.val);
		Assert.assertEquals(3, root.left.val);
		Assert.assertEquals(4, root.left.right.val);
		Assert.assertEquals(2, root.right.val);
	}
	
	public void invertBinaryTree(TreeNode root) {

		if (root == null) {
			return;
		}
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if (root.left != null) {
			invertBinaryTree(root.left);
		}
		
		if (root.right != null) {
			invertBinaryTree(root.right);
		}
    }
}
