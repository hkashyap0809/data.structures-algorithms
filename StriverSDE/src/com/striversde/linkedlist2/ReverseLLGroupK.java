package com.striversde.linkedlist2;

public class ReverseLLGroupK {
	public ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode tempHead = head;
		int len = 0;
		while(tempHead!=null) {
			tempHead = tempHead.next;
			len++;
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode newHead = dummy;
		
		ListNode currPtr,nextPtr;
		
		currPtr = head;
		dummy.next = currPtr;
		nextPtr = currPtr.next;
		
		while( len >= k) {
			
			//k-1 operations to reverse the group
			for(int i=1;i<k-1;i++) {
				currPtr.next = nextPtr.next;
				nextPtr.next = dummy.next;
				dummy.next = nextPtr;
				nextPtr = currPtr.next;
			}
			len = len - k;
			
			dummy = currPtr;
			currPtr = dummy.next;
			nextPtr = currPtr.next;
			
					
		}
		
		return newHead.next;

	}

}
