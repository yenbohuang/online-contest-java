package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author user
 *
 */
public class MinimumDepthOfBinaryTree {

	private int answer = Integer.MAX_VALUE;
	
	@Test
	public void test() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		Assert.assertEquals(2, minDepth(root));
	}
	
	public int minDepth(TreeNode root) {
        
		if (root == null) {
			return 0;
		}
		
		findNode(root, 1);
		
		return answer;
    }
	
	private void findNode(TreeNode node, int depth) {
		
		if (node.left == null && node.right == null) {
			
			if (depth < answer) {
				answer = depth;
			}
		}
		
		if (node.left != null) {
			findNode(node.left, depth + 1);
		}
		
		if (node.right != null) {
			findNode(node.right, depth + 1);
		}
	}
}
