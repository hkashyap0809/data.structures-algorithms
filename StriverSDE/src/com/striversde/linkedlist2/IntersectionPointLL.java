package com.striversde.linkedlist2;

import java.util.HashMap;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class IntersectionPointLL {
	

	//Hashing
	public ListNode getIntersectionNodeHashing(ListNode headA, ListNode headB) {
		HashMap<ListNode,Integer> hashMap = new HashMap<>();
		while( headA != null ){
			hashMap.put(headA,headA.val);
			headA = headA.next;
		}
		while( headB != null ) {
			if ( hashMap.containsKey(headB))	return headB;
			headB = headB.next;
		}
		return null;
	}
	
	//Optimal 1 - length
	public ListNode getIntersectionNodeLength(ListNode headA, ListNode headB) {
		int count1 = 0;
		int count2 = 0;
		
		ListNode list1 = headA;
		ListNode list2 = headB;
		
		while( list1 != null && list2 != null) {
			count1++;
			count2++;
			list1 = list1.next;
			list2 = list2.next;
		}
		
		while( list1 != null ) {
			count1++;
			list1 = list1.next;
		}
		
		while( list2 != null ) {
			count2++;
			list2 = list2.next;
		}
		
		int diff = Math.max(count1, count2) - Math.min(count1, count2);
		System.out.println(count1+" "+count2+" "+diff);
		
		list1 = count1 < count2 ? headA : headB;
		list2 = count1 >= count2 ? headA : headB;

		for(int i=1; i<=diff;i++) {
			list2 = list2.next;
		}
		if ( list1 == list2 )	return list1;
		
		while( list1 != null) {
			list1 = list1.next;
			list2 = list2.next;
			if( list1 == list2 )	return list1;
		}
		return null;
	}
	
	//Optimal
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode list1 = headA;
		ListNode list2 = headB;

		while( list1 != list2 ) {
			list1 = list1.next;
			list2 = list2.next;

			if ( list1 == list2 ) {
				return list1;
			}
			if ( list1 == null ){
				list1 = headB;
			}
			if ( list2 == null){
				list2 = headA;
			}
		}
		return list1;
	}
}