package com.striversde.linkedlist;

public class Add2Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		ListNode tempNode = null;
		ListNode list = l2;

		while( l1 != null && l2 != null ){

			int sum = l1.val + l2.val + carry;
			if ( sum > 9 ){
				l2.val = sum % 10;
				carry = sum / 10 ;
			}else{
				carry = 0;
				l2.val = sum;
			}
			tempNode = l2;
			l1 = l1.next;
			l2 = l2.next;
		}

		if ( l1 != null ){
			tempNode.next = l1;
		}else{
			tempNode.next = l2;
		}

		ListNode prevTemp = tempNode;
		tempNode = tempNode.next;
		while( tempNode != null ){
			int sum = tempNode.val + carry;
			if ( sum > 9 ){
				tempNode.val = sum % 10;
				carry = sum / 10 ;
			}else{
				carry = 0;
				tempNode.val = sum;
			}
			prevTemp = tempNode;
			tempNode = tempNode.next;
		}
		if ( carry > 0 ){
			prevTemp.next = new ListNode(carry);
		}

		return list;
	}

}
