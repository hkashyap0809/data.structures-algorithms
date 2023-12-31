package com.striversde.linkedlist;
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if ( head == null || head.next == null )	return head;
		
		ListNode currPtr = head;
		ListNode prevPtr = null;
		ListNode nextPtr;
		
		while( currPtr != null) {
			nextPtr = currPtr.next;
			currPtr.next = prevPtr;
			
			prevPtr = currPtr;
			currPtr = nextPtr;
			
		}
		return prevPtr;
			
	}
}
