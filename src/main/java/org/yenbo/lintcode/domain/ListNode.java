package org.yenbo.lintcode.domain;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	@Override
	public String toString() {
		
		ListNode cursor = this;
		
		String value = Integer.toString(this.val);
		
		while (cursor.next != null) {
			
			value += "->" + Integer.toString(cursor.next.val);
			cursor = cursor.next;
		}
		
		return value;
	}
}
