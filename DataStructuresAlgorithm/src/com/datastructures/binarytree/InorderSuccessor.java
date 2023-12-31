package com.datastructures.binarytree;

public class InorderSuccessor {
	public Node inorderSuccessor(Node root,Node x){

		Node successor = null;
		Node iter = root;

		while( iter != null ){

			if ( iter.data > x.data ){
				successor = iter;
			}

			if ( x.data < iter.data ){
				iter = iter.left;
			}else{
				iter = iter.right;
			}
		}

		if ( successor == null ){
			return new Node(-1);
		}
		return successor;
	}
}
