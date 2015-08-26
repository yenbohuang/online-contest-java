package org.yenbo.lintcode.easy.list;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.lintcode.domain.ListNode;

public class NthToLastNodeInList {

	@Test
	public void test() {
		
		ListNode root = new ListNode(3);
		root.next = new ListNode(2);
		root.next.next = new ListNode(1);
		root.next.next.next = new ListNode(5);
		
		Assert.assertEquals(1, nthToLast(root, 2).val);
	}
	
	ListNode nthToLast(ListNode head, int n) {
        
		ListNode node = head;
		int count = 0;
		
		while (node != null) {
			count++;
			node = node.next;
		}
		
		node = head;
		
		for (int i = 0; i < count - n; i++) {
			node = node.next;
		}
		
		return node;
    }
}
