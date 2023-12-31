package com.striversde.linkedlist2;

public class CheckPalindromeLL {

	//Optimal
	public ListNode reverseLinkedList(ListNode head){
		if (head == null || head.next == null ) return head;
		ListNode prevPtr = null;
		ListNode currPtr = head;
		ListNode nextPtr = currPtr.next;

		while(currPtr != null){
			nextPtr = currPtr.next;

			currPtr.next = prevPtr;
			prevPtr = currPtr;
			currPtr = nextPtr;
		}

		return prevPtr;
	}
	public boolean isPalindrome(ListNode head) {
		if ( head == null || head.next == null )    return true;
		if (head.next.next == null ){
			return head.val == head.next.val;
		}

		ListNode slowPtr = head;
		ListNode fastPtr = head.next;

		//finding the middle of the linked list
		while(fastPtr.next != null ) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if ( fastPtr == null ) break;
		}

		ListNode list2 = slowPtr.next;
		slowPtr.next = null;

		list2 = reverseLinkedList(list2);

		while(list2 != null){
			if ( head.val != list2.val )    return false;
			head = head.next;
			list2 = list2.next;
		}
		return true;
	}
}
