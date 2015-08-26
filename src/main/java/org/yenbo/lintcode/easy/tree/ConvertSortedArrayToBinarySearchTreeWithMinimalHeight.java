package org.yenbo.lintcode.easy.tree;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.TreeNode;

/**
 * http://algs4.cs.princeton.edu/32bst/
 * 
 * @author YENBO.HUANG
 *
 */
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {

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

	public TreeNode sortedArrayToBST(int[] A) {

		if (A == null || A.length == 0) {
			return null;
		}
		
		int mid = A.length / 2;
		TreeNode root = new TreeNode(A[mid]);
		
		construct(root, A, 0, mid - 1, true);
		construct(root, A, mid + 1, A.length - 1, false);
		
		return root;
	}
	
	private void construct(TreeNode node, int[] A, int start, int end, boolean left) {
		
		if (end < start) {
			return;
		}
		
		int mid = start + (end - start) / 2;
		TreeNode newNode = new TreeNode(A[mid]);
		
		if (left) {
			node.left = newNode;
		} else {
			node.right = newNode;
		}
		
		construct(newNode, A, start, mid - 1, true);
		construct(newNode, A, mid + 1, end, false);
	}
}
