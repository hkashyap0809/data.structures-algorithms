package com.striversde.linkedlist2;


class Node{

	int data;
	Node next;
	Node bottom;

	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
public class FlattenLL {
	public Node mergeTwoLists(Node list1, Node list2) {
		if ( list1 == null && list2 == null)    return null;
		if ( list1 == null ) return list2;
		if ( list2 == null ) return list1;

		Node head1,head2;

		if ( list1.data <= list2.data ){
			head1 = list1;
			head2 = list2;
		}else{
			head1 = list2;
			head2 = list1;
		}
		Node head = head1;

		while(head1!=null && head2!=null){
			Node tempNode = null;
			while( head1 != null && head1.data <= head2.data ){
				tempNode = head1;
				head1 = head1.bottom;
			}
			tempNode.bottom = head2;

			Node temp = head1;
			head1 = head2;
			head2 = temp;
		}
		return head;

	}
	Node flatten(Node root){

		return flattenRecursive(root);

	}
	private Node flattenRecursive(Node root) {
		if ( root.next == null ) {
			return root;
		}
		Node node1 = flattenRecursive(root.next);
		return mergeTwoLists(root, node1);

	}
}
