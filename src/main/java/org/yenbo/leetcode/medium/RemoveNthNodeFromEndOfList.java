package org.yenbo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @author user
 *
 */
public class RemoveNthNodeFromEndOfList {

	@Test
	public void test1() {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		Assert.assertEquals("1->2->3->5", removeNthFromEnd(head, 2).toString());
	}
	
	@Test
	public void test2() {
		
		ListNode head = new ListNode(1);
		
		Assert.assertNull(removeNthFromEnd(head, 1));
	}
	
	@Test
	public void test3() {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		
		Assert.assertEquals("2", removeNthFromEnd(head, 2).toString());
	}
	
	ListNode removeNthFromEnd(ListNode head, int n) {
        
		ListNode current = head;
		int count = 0;
		
		while (current != null) {
			count++;
			current = current.next;
		}
		
		if (count == 1 && n == 1) {
			return null;
		} else if (count - n == 0) {
			return head.next;
		}
		
		current = head;
		
		for (int i = 0; i < count; i++) {
			
			if (i == count - n - 1) {
				current.next = current.next.next;
				break;
			}
			
			current = current.next;
		}
		
		return head;
    }
}
