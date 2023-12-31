package com.striversde.linkedlist;

public class MiddleLinkedList {
	public ListNode middleNode(ListNode head) {
		if ( head == null || head.next == null ) return head;

		ListNode ptr1 = head;
		ListNode ptr2 = head;

		while( ptr2 != null && ptr2.next != null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		return ptr1;
	}
}
