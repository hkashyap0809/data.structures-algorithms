package com.datastructures.linkedlist;

public class ReverseLinkedList {
	
	static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.err.println();
	}
	
	static void reverseList(ListNode head) {
		ListNode prevPtr = null;
		ListNode currPtr = head;
		ListNode nextPtr ;
		System.out.println("original list");
		print(head);
		
		while(currPtr != null) {
			nextPtr = currPtr.next;
			currPtr.next = prevPtr;
			
			prevPtr = currPtr;
			currPtr = nextPtr;
			
		}
		System.out.println("reversed");
		ListNode newHead = prevPtr;
		print(newHead);
		
		
	}
	
	public static void main(String [] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		
		ListNode head = l1;
		
		reverseList(head);
		
		
	}

}
