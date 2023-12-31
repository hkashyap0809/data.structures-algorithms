package com.striversde.linkedlistandarrays;

import java.util.HashMap;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class CloneLL {

	//Brute
	public Node copyRandomListBrute(Node head) {
		HashMap<Node,Node> hashMap = new HashMap<>();
		Node tempHead = head;
		while( tempHead!=null) {
			Node node = new Node(tempHead.val);
			hashMap.put(tempHead, node);
			tempHead = tempHead.next;
		}

		tempHead = head;
		while(tempHead != null) {
			Node deepCopy = hashMap.get(tempHead);
			deepCopy.next = tempHead.next;
			deepCopy.random = tempHead.random;
			tempHead = tempHead.next;
		}
		return hashMap.get(head);
	}


	//Optimal
	public Node copyRandomList(Node head) {
		if ( head == null ) return null ;

		//Step 1
		Node tempHead = head;
		while(tempHead!=null) {
			Node node = new Node(tempHead.val);

			node.next = tempHead.next;
			tempHead.next = node;

			tempHead = node.next;
		}
		//Step 2 
		Node iter = head;
		while( iter != null ){
			if( iter.random == null )
				iter.next.random = null;
			else
				iter.next.random = iter.random.next;
			iter = iter.next.next;
		}

		//Step 3 
		iter = head;	
		Node dummy = new Node(-1);

		//iterate thee new list
		Node copy = dummy;

		while( iter != null ){

			Node front = iter.next.next;

			copy.next = iter.next;
			iter.next = front;

			copy = copy.next;
			iter = front;

		}

		return dummy.next;
	}
}
