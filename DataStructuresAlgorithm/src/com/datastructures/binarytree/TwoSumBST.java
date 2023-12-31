package com.datastructures.binarytree;

import java.util.Stack;

class DualBSTIterator{

	private Stack<TreeNode> nextStack;
	private Stack<TreeNode> beforeStack;
	private void insertInNextStack(TreeNode root){
		while( root != null ){
			nextStack.push( root );
			root = root.left;
		}
	}
	private void insertInBeforeStack(TreeNode root){
		while( root != null ){
			beforeStack.push( root );
			root = root.right;
		}
	}

	DualBSTIterator(TreeNode root){
		nextStack = new Stack<>();
		beforeStack = new Stack<>();
		insertInNextStack(root);
		insertInBeforeStack(root);
	}
	public int next(){
		TreeNode top = nextStack.peek();
		nextStack.pop();
		if ( top.right != null ){
			insertInNextStack(top.right);
		}
		return top.val;
	}
	public int before(){
		TreeNode top = beforeStack.peek();
		beforeStack.pop();
		if( top.left != null ){
			insertInBeforeStack(top.left);
		}
		return top.val;
	}
	public boolean hasNext(){
		return !nextStack.empty();
	}
	public boolean hasBefore(){
		return !beforeStack.empty();
	}
}
public class TwoSumBST {
	public boolean findTarget(TreeNode root, int k) {
		DualBSTIterator bstIterator = new DualBSTIterator(root);
		int nextVal = bstIterator.next();
		int beforeVal = bstIterator.before();
		while( nextVal < beforeVal ){
			if( nextVal + beforeVal == k ){
				return true;
			}else if( nextVal + beforeVal < k ){
				nextVal = bstIterator.next();        
			}else{
				beforeVal = bstIterator.before();
			}
		}
		return false;   
	}
}
