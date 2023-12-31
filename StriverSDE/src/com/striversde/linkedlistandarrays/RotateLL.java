package com.striversde.linkedlistandarrays;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RotateLL {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null ) return head;
		ListNode tempHead = head;
		int length = 0;
		while(tempHead.next!=null) {
			length++;
			tempHead = tempHead.next;
		}
		tempHead.next = head;
		length = length+1;
		// System.out.println(length);

		k = k%length;
		tempHead = head;

		for( int i=1; i<length - k; i++) {
			tempHead = tempHead.next;
		}
		ListNode newHead = tempHead.next;
		tempHead.next = null;
		return newHead;
	}
}
