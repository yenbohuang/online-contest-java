package org.yenbo.leetcode.todo.easy;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.TreeNode;

/**
 * http://algs4.cs.princeton.edu/32bst/
 * 
 * @author YENBO.HUANG
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

	@Test
	public void test1() {
	
		TreeNode root = sortedArrayToBST(new int[] {1, 2, 3, 4, 5, 6, 7});
		Assert.assertEquals(4, root.val);
		
		Assert.assertEquals(2, root.left.val);
		Assert.assertEquals(1, root.left.left.val);
		Assert.assertEquals(3, root.left.right.val);
		
		Assert.assertEquals(6, root.right.val);
		Assert.assertEquals(5, root.right.left.val);
		Assert.assertEquals(7, root.right.right.val);
	}
	
	@Test
	public void test2() {
		Assert.assertNull(sortedArrayToBST(null));
	}
	
	@Test
	public void test3() {
		Assert.assertNull(sortedArrayToBST(new int[0]));
	}
	
	@Test
	public void test4() {
	
		TreeNode root = sortedArrayToBST(new int[] {-10,-3,0,5,9});
		Assert.assertEquals(0, root.val);
		
		Assert.assertEquals(-3, root.left.val);
		Assert.assertEquals(-10, root.left.left.val);
		
		Assert.assertEquals(9, root.right.val);
		Assert.assertEquals(5, root.right.left.val);
	}

	public TreeNode sortedArrayToBST(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}
		
		int mid = nums.length / 2;
		TreeNode root = new TreeNode(nums[mid]);
		
		construct(root, nums, 0, mid - 1, true);
		construct(root, nums, mid + 1, nums.length - 1, false);
		
		return root;
	}
	
	private void construct(TreeNode node, int[] nums, int start, int end, boolean left) {
		
		if (end < start) {
			return;
		}
		
		int mid = start + (end - start) / 2;
		TreeNode newNode = new TreeNode(nums[mid]);
		
		if (left) {
			node.left = newNode;
		} else {
			node.right = newNode;
		}
		
		construct(newNode, nums, start, mid - 1, true);
		construct(newNode, nums, mid + 1, end, false);
	}
}
