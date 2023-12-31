package com.striversde.linkedlist;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode start = new ListNode();
		start.next = head;
		ListNode fast = start;
		ListNode slow = start;

		while( n > 0 ){
			fast = fast.next;
			n--;
		}


		while(fast.next != null ){
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;
		return start.next;

	}
}
