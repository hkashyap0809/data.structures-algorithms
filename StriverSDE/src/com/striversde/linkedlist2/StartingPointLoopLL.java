package com.striversde.linkedlist2;

public class StartingPointLoopLL {
	public ListNode detectCycle(ListNode head) {
		if ( head == null || head.next == null )	return null;
		if ( head == head.next.next ) return head;
		ListNode slow = head;
		ListNode fast = head;

		while( fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
			if ( slow == fast )	break;
			
		}

		if ( fast == null )	return null ;
		slow = head;
		while( fast !=null  ) {
			slow = slow.next;
			fast = fast.next;
			if ( slow == fast ) return fast;
		}
		return null;

	}

}
