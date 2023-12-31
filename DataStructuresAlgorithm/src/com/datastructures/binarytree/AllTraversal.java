package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NodeNumPair{
	TreeNode node;
	int num;
	NodeNumPair(TreeNode node, int num){
		this.node = node;
		this.num = num;
	}
}
public class AllTraversal {
	public static List<List<Integer>> getTreeTraversal(TreeNode root) {
		List<Integer> preOrder = new ArrayList<>();
		List<Integer> inOrder = new ArrayList<>();
		List<Integer> postOrder = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Stack<NodeNumPair> stack = new Stack<>();

		stack.push(new NodeNumPair(root,1));
		while(! stack.empty() ){
			NodeNumPair topEl = stack.pop();
			if( topEl.node == null )    continue;
			if( topEl.num == 1 ){
				preOrder.add(topEl.node.val);
				stack.push( new NodeNumPair(topEl.node,topEl.num+1));
				stack.push( new NodeNumPair(topEl.node.left,1));
			}else if( topEl.num == 2 ){
				inOrder.add(topEl.node.val);
				stack.push( new NodeNumPair(topEl.node,topEl.num+1));
				stack.push( new NodeNumPair(topEl.node.right,1));
			}else if( topEl.num == 3 ){
				postOrder.add(topEl.node.val);
			}
		}

		result.add(inOrder);
		result.add(preOrder);
		result.add(postOrder);
		return result;
	}
}