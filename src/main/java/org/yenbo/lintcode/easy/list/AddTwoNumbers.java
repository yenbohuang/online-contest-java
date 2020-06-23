package org.yenbo.lintcode.easy.list;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.domain.ListNode;

public class AddTwoNumbers {
	
	@Test
	public void test1() {
		
		ListNode caseA1_1 = new ListNode(7);
		ListNode caseA1_2 = new ListNode(1);
		caseA1_1.next = caseA1_2;
		ListNode caseA1_3 = new ListNode(6);
		caseA1_2.next = caseA1_3;
		
		ListNode caseA2_1 = new ListNode(5);
		ListNode caseA2_2 = new ListNode(9);
		caseA2_1.next = caseA2_2;
		ListNode caseA2_3 = new ListNode(2);
		caseA2_2.next = caseA2_3;
		
		Assert.assertEquals("7->1->6", caseA1_1.toString());
		Assert.assertEquals("5->9->2", caseA2_1.toString());
		Assert.assertEquals("2->1->9", addLists(caseA1_1, caseA2_1).toString());
	}
	
	@Test
	public void test2() {
		
		ListNode caseB1_1 = new ListNode(3);
		ListNode caseB1_2 = new ListNode(1);
		caseB1_1.next = caseB1_2;
		ListNode caseB1_3 = new ListNode(5);
		caseB1_2.next = caseB1_3;
		
		ListNode caseB2_1 = new ListNode(5);
		ListNode caseB2_2 = new ListNode(9);
		caseB2_1.next = caseB2_2;
		ListNode caseB2_3 = new ListNode(2);
		caseB2_2.next = caseB2_3;
		
		Assert.assertEquals("3->1->5", caseB1_1.toString());
		Assert.assertEquals("5->9->2", caseB2_1.toString());
		Assert.assertEquals("8->0->8", addLists(caseB1_1, caseB2_1).toString());
	}
	
	public ListNode addLists(ListNode l1, ListNode l2) {
		
		ListNode answer = new ListNode(0);
		
		ListNode cursor1 = l1;
		ListNode cursor2 = l2;
		ListNode cursorAnswer = answer;
		
		int tmp = 0;
		
		while (cursor1 != null || cursor2 != null) {
			
			if (cursor1 != null) {
				tmp += cursor1.val;
				cursor1 = cursor1.next;
			}
			
			if (cursor2 != null) {
				tmp += cursor2.val;
				cursor2 = cursor2.next;
			}
			
			cursorAnswer.val = (tmp % 10);
			tmp /= 10;
			
			if (tmp > 0 || cursor1 != null || cursor2 != null) {
				ListNode newNode = new ListNode(tmp);
				cursorAnswer.next = newNode;
				cursorAnswer = newNode;
			}
		}
		
		return answer;
	}
}
