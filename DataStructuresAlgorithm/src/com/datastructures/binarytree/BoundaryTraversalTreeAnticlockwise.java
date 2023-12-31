package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversalTreeAnticlockwise {
	public boolean isLeaf(Node node){
		return node.left == null && node.right == null;
	}
	public void leftWithoutLeafNodes(Node node, ArrayList<Integer> boundaryTraversal){
		while( node != null ){
			if( isLeaf(node) == false )   boundaryTraversal.add(node.data);
			if( node.left != null ){
				node = node.left;
			}else{
				node = node.right;
			}
		}
	}
	public void inorderForLeafNodes(Node node, ArrayList<Integer> boundaryTraversal){
		if( isLeaf(node) ){
			boundaryTraversal.add(node.data);
			return;
		}
		if( node.left != null ) inorderForLeafNodes(node.left,boundaryTraversal);
		if( node.right != null ) inorderForLeafNodes(node.right,boundaryTraversal);
	}
	public void rightWIthoutLeafNodes(Node node, Stack<Integer> stack){
		while( node != null ){
			if( isLeaf(node) == false )   stack.push(node.data);
			if( node.right != null ){
				node = node.right;
			}else{
				node = node.left;
			} 
		}
	}
	public ArrayList<Integer> boundary(Node node){
		

		ArrayList<Integer> boundaryTraversal = new ArrayList<>();
		if( node == null )  return boundaryTraversal;

		boundaryTraversal.add(node.data);
		if( isLeaf(node) )  return boundaryTraversal;

		leftWithoutLeafNodes(node.left,boundaryTraversal);

		inorderForLeafNodes(node,boundaryTraversal);

		Stack<Integer> stack = new Stack<>();
		rightWIthoutLeafNodes(node.right,stack);

		while( !stack.empty() ){
			boundaryTraversal.add(stack.peek());
			stack.pop();
		}
		return boundaryTraversal;

	}

}
