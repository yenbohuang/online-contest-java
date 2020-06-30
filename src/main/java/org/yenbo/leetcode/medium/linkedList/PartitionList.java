package org.yenbo.leetcode.medium.linkedList;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 * @author user
 *
 */
public class PartitionList {

	@Test
	public void test1() {
		
		// 1->4->3->2->5->2
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		
		Assert.assertEquals("1->2->2->4->3->5", partition(head, 3).toString());
	}
	
	public ListNode partition(ListNode head, int x) {
        
		if (head == null || head.next == null) {
			return head;
		}
		
		ArrayList<Integer> greaterThan = new ArrayList<Integer>();
		ArrayList<Integer> lessThan = new ArrayList<Integer>();
		ListNode node = head;
		
		while (node != null) {
			
			if (node.val < x) {
				lessThan.add(node.val);
			} else {
				greaterThan.add(node.val);
			}
			
			node = node.next;
		}
		
		lessThan.addAll(greaterThan);
		
		ListNode answer = new ListNode(lessThan.get(0));
		ListNode tmpNode = answer;
		
		for (int i = 1; i < lessThan.size(); i++) {
			tmpNode.next = new ListNode(lessThan.get(i));
			tmpNode = tmpNode.next;
		}
		
		return answer;
    }
}
