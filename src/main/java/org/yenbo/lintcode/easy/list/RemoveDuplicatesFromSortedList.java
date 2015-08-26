package org.yenbo.lintcode.easy.list;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.ListNode;

public class RemoveDuplicatesFromSortedList {

	@Test
	public void test1() {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		
		Assert.assertEquals("1->2", deleteDuplicates(head).toString());
	}
	
	@Test
	public void test2() {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		
		Assert.assertEquals("1->2->3", deleteDuplicates(head).toString());
	}
	
	public static ListNode deleteDuplicates(ListNode head) { 
		
		if (head == null) {
			return null;
		}
		
		ListNode current = head;
		
		while (current.next != null) {
			
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		
		return head;
    }
}
