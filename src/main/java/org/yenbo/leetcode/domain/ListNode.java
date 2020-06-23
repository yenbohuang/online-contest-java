package org.yenbo.leetcode.domain;

public class ListNode {

	public int val;
	public ListNode next;
	public ListNode() {}
	public ListNode(int val) { this.val = val; }
	public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
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
