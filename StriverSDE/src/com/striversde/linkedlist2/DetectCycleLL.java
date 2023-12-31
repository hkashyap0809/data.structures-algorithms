package com.striversde.linkedlist2;

import java.util.HashMap;

public class DetectCycleLL {

	//Hashing
	public boolean hasCycleHashing(ListNode head) {
		HashMap<ListNode, Integer> hashMap = new HashMap<>();
		while( head != null) {
			if ( hashMap.containsKey(head) ) return true;
			hashMap.put(head, head.val);
			head = head.next;
		}
		return false;
	}

	//Optimal
	public boolean hasCycle(ListNode head) {
		if ( head == null || head.next == null)	return false;

		ListNode slow = head;
		ListNode fast = head;

		while( fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if ( slow == fast )	return true;
		}
		return false;
	}
}
