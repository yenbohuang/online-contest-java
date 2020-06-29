package org.yenbo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * @author user
 *
 */
public class InsertIntoABinarySearchTree {

	@Test
	public void test1() {
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		
		TreeNode answer = insertIntoBST(root, 6);
		
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
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
        
		if (root == null) {
			return new TreeNode(val);
		}
		
		if (root.val > val) {
			
			if (root.left != null) {
				insertIntoBST(root.left, val);
			} else {
				root.left = new TreeNode(val);
			}
		} else {
			
			if (root.right != null) {
				insertIntoBST(root.right, val);
			} else {
				root.right = new TreeNode(val);
			}
		}
		
		return root;
	}
}
