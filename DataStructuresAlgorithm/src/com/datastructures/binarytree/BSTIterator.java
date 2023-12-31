package com.datastructures.binarytree;

import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> stack;
	private void insertInStack(TreeNode root){
		while(root != null ){
			stack.push(root);
			root = root.left;
		}
	}
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		insertInStack(root);
	}

	public int next() {
		TreeNode stackTop = stack.peek();
		stack.pop();
		if( stackTop.right !=null ){
			insertInStack(stackTop.right);
		}
		return stackTop.val;
	}

	public boolean hasNext() {
		return !stack.empty();
	}

}
