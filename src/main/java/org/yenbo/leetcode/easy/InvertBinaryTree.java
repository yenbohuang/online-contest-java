package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * @author user
 *
 */
public class InvertBinaryTree {

	@Test
	public void test() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		
		invertTree(root);
		
		Assert.assertEquals(1, root.val);
		Assert.assertEquals(3, root.left.val);
		Assert.assertEquals(4, root.left.right.val);
		Assert.assertEquals(2, root.right.val);
	}
	
	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if (root.left != null) {
			invertTree(root.left);
		}
		
		if (root.right != null) {
			invertTree(root.right);
		}
		
		return root;
    }
}
