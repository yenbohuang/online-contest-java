package org.yenbo.lintcode.easy.list;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.ListNode;

public class InsertionSortList {

	@Test
	public void test1() {
		
		ListNode root = new ListNode(1);
		
		Assert.assertEquals("1", root.toString());
		Assert.assertEquals("1", insertionSortList(root).toString());
	}
	
	@Test
	public void test2() {
		
		ListNode root = new ListNode(1);
		root.next = new ListNode(3);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(0);
		
		Assert.assertEquals("1->3->2->0", root.toString());
		Assert.assertEquals("0->1->2->3", insertionSortList(root).toString());
	}
	
	public ListNode insertionSortList(ListNode head) {

		ListNode newRoot = new ListNode(head.val);
		ListNode srcNode = head.next;
		
		while (srcNode != null) {
			
			ListNode node = newRoot;
			
			while (node.val < srcNode.val && node.next != null) {
				node = node.next;
			}
			
			ListNode addNode;
			
			if (node.val < srcNode.val) {
				addNode = new ListNode(srcNode.val);
			} else {
				addNode = new ListNode(node.val);
				node.val = srcNode.val;
			}
			
			addNode.next = node.next;
			node.next = addNode;
			
			srcNode = srcNode.next;
		}
		
		return newRoot;
    }
}
