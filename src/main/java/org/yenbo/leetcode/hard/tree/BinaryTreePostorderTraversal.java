package org.yenbo.leetcode.hard.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * @author user
 *
 */
public class BinaryTreePostorderTraversal {
	
	@Test
	public void test() {
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		Assert.assertArrayEquals(new Integer[] {3,2,1}, postorderTraversal(root).toArray(new Integer[0]));
		
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		if (root != null) {
			traverse(root, list);
		}
		
		return list;
    }
	
	private void traverse(TreeNode node, List<Integer> list) {
		
		if (node.left != null) {
			traverse(node.left, list);
		}
		
		if (node.right != null) {
			traverse(node.right, list);
		}
		
		list.add(node.val);
	}
}
