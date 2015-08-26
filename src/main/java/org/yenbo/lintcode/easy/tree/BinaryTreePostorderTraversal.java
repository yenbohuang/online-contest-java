package org.yenbo.lintcode.easy.tree;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.TreeNode;

public class BinaryTreePostorderTraversal {
	
	@Test
	public void test() {
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		Assert.assertArrayEquals(new Integer[] {3,2,1}, postorderTraversal(root).toArray(new Integer[0]));
		
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (root != null) {
			traverse(root, list);
		}
		
		return list;
    }
	
	private void traverse(TreeNode node, ArrayList<Integer> list) {
		
		if (node.left != null) {
			traverse(node.left, list);
		}
		
		if (node.right != null) {
			traverse(node.right, list);
		}
		
		list.add(node.val);
	}
}
