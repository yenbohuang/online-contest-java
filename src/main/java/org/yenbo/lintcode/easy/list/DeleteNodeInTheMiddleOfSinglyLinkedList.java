package org.yenbo.lintcode.easy.list;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.ListNode;

public class DeleteNodeInTheMiddleOfSinglyLinkedList {

	@Test
	public void test() {
		
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		
		Assert.assertEquals("1->2->3->4", root.toString());
		
		deleteNode(root.next.next);
		Assert.assertEquals("1->2->4", root.toString());
	}
	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
