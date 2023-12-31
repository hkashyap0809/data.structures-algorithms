package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
	public void inorderTraversal(TreeNode root, List<Integer> result){
		if ( root == null ) return;
		inorderTraversal(root.left,result);
		result.add(root.val);
		inorderTraversal(root.right,result);
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inorderTraversal(root,result);
		return result;

	}

}
