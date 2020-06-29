package org.yenbo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * @author user
 *
 */
public class BinaryTreePreorderTraversal {
	
	@Test
	public void test() {
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		Assert.assertArrayEquals(new Integer[] {1,2,3}, preorderTraversal(root).toArray(new Integer[0]));
		
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        
		List<Integer> list = new ArrayList<Integer>();
		
		if (root != null) {
			traverse(root, list);
		}
		
		return list;
    }
	
	private void traverse(TreeNode node, List<Integer> list) {
		
		list.add(node.val);
		
		if (node.left != null) {
			traverse(node.left, list);
		}
		
		if (node.right != null) {
			traverse(node.right, list);
		}
	}
}
