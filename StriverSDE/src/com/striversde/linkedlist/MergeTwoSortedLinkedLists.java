package com.striversde.linkedlist;

public class MergeTwoSortedLinkedLists {
	//Extra Space
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if ( list1 == null && list2 == null)    return null;
		if ( list1 == null ) return list2;
		if ( list2 == null ) return list1;

		ListNode head1,head2;

		if ( list1.val <= list2.val ){
			head1 = list1;
			head2 = list2;
		}else{
			head1 = list2;
			head2 = list1;
		}
		ListNode head = new ListNode(head1.val);
		ListNode temp = head;
		head1 = head1.next;

		while( head1 != null && head2 != null ){

			if ( head1.val <= head2.val ){
				ListNode node = new ListNode(head1.val);
				temp.next = node;
				temp = temp.next; 
				head1 = head1.next;
			}else{
				ListNode node = new ListNode(head2.val);
				temp.next = node;
				temp = temp.next; 
				head2 = head2.next;
			}
		}
		if ( head1 != null )
			temp.next = head1;
		else   temp.next = head2;

		return head;

	}
	//In Place
	public ListNode mergeTwoListsInPlace(ListNode list1, ListNode list2) {
		if ( list1 == null && list2 == null)    return null;
		if ( list1 == null ) return list2;
		if ( list2 == null ) return list1;

		ListNode head1,head2;

		if ( list1.val <= list2.val ){
			head1 = list1;
			head2 = list2;
		}else{
			head1 = list2;
			head2 = list1;
		}
		ListNode head = head1;

		while(head1!=null && head2!=null){
			ListNode tempNode = null;
			while( head1 != null && head1.val <= head2.val ){
				tempNode = head1;
				head1 = head1.next;
			}
			tempNode.next = head2;

			ListNode temp = head1;
			head1 = head2;
			head2 = temp;
		}
		return head;

	}
}
