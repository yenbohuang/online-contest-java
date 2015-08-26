package org.yenbo.lintcode.easy.tree;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.TreeNode;

public class InsertNodeInABinarySearchTree {

	@Test
	public void test() {
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		
		TreeNode node = new TreeNode(6);
		
		TreeNode answer = insertNode(root, node);
		
		Assert.assertEquals(2, answer.val);
		
		Assert.assertEquals(1, answer.left.val);
		Assert.assertNull(answer.left.left);
		Assert.assertNull(answer.left.right);
		
		Assert.assertEquals(4, answer.right.val);
		
		Assert.assertEquals(3, answer.right.left.val);
		Assert.assertNull(answer.right.left.left);
		Assert.assertNull(answer.right.left.right);
		
		Assert.assertEquals(6, answer.right.right.val);
		Assert.assertNull(answer.right.right.left);
		Assert.assertNull(answer.right.right.right);
	}
	
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        
		if (root == null) {
			return node;
		}
		
		if (root.val > node.val) {
			
			if (root.left != null) {
				insertNode(root.left, node);
			} else {
				root.left = node;
			}
		} else {
			
			if (root.right != null) {
				insertNode(root.right, node);
			} else {
				root.right = node;
			}
		}
		
		return root;
	}
}
