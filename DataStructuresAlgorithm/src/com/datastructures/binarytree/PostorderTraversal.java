package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		postorderTraversal(root,result);
		return result;
	}

	private void postorderTraversal(TreeNode root, List<Integer> result) {
		if ( root == null )return;

		postorderTraversal(root.left, result);
		postorderTraversal(root.right, result);
		result.add(root.val);

	}
}
