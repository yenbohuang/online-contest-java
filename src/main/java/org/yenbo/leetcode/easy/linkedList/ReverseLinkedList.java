package org.yenbo.leetcode.easy.linkedList;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author user
 *
 */
public class ReverseLinkedList {

	@Test
	public void test() {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		
		Assert.assertEquals("3->2->1", reverse(head).toString());
	}
	
	public ListNode reverse(ListNode head) {
        
		if (head == null) {
			return null;
		}
		
		ListNode root = new ListNode(head.val);
		ListNode current = head.next;
		
		while (current != null) {
			
			ListNode node = new ListNode(current.val);
			node.next = root;
			root = node;
			
			current = current.next;
		}
		
		return root;
    }
}
