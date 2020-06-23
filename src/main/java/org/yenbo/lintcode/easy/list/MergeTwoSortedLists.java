package org.yenbo.lintcode.easy.list;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.ListNode;

public class MergeTwoSortedLists {

	@Test
	public void test1() {
		
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(3);
		list1.next.next = new ListNode(8);
		list1.next.next.next = new ListNode(11);
		list1.next.next.next.next = new ListNode(15);
		Assert.assertEquals("1->3->8->11->15", list1.toString());
		
		ListNode list2 = new ListNode(2);
		Assert.assertEquals("2", list2.toString());
		
		Assert.assertEquals("1->2->3->8->11->15", mergeTwoLists(list1, list2).toString());
	}
	
	@Test
	public void test2() {
		
		ListNode list1 = null;
		
		ListNode list2 = new ListNode(0);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(3);
		Assert.assertEquals("0->3->3", list2.toString());
		
		Assert.assertEquals("0->3->3", mergeTwoLists(list1, list2).toString());
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
		ListNode answer = null;
		
		if (l1 == null) {
			
			// copy second list
			answer = new ListNode(l2.val);
			ListNode answerCurrent2 = answer;
			
			for (ListNode current = l2; current.next != null; current = current.next) {
				answerCurrent2.next = new ListNode(current.next.val);
				answerCurrent2 = answerCurrent2.next;
			}
			
		} else {
		
			// copy first list
			answer = new ListNode(l1.val);
			ListNode answerCurrent1 = answer;
			
			for (ListNode current = l1; current.next != null; current = current.next) {
				answerCurrent1.next = new ListNode(current.next.val);
				answerCurrent1 = answerCurrent1.next;
			}
			
			for (ListNode current = l2; current != null; current = current.next) {
				
				if (answer.val > current.val) {
					
					ListNode toAdd = new ListNode(current.val);
					toAdd.next = answer;
					answer = toAdd;
					
				} else {
					
					boolean inserted = false;
					ListNode answerCurrent2 = answer;
					
					while (answerCurrent2.next != null) {
							
						if (answerCurrent2.next.val > current.val) {
							
							ListNode toAdd = new ListNode(current.val);
							toAdd.next = answerCurrent2.next;
							answerCurrent2.next = toAdd;
							
							inserted = true;
							break;
						}
						
						answerCurrent2 = answerCurrent2.next;
					}
					
					// add at tail
					if (inserted == false) {
						answerCurrent2.next = new ListNode(current.val);
					}
				}
			}
		}
				
		return answer;
    }
}
