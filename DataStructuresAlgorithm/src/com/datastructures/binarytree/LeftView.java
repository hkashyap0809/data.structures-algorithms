package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		getRightSideView(root,0,result);
		return result;


	}

	private void getRightSideView(TreeNode root, int level, List<Integer> result) {
		if ( root == null )	return;
		if ( level == result.size() )	result.add(root.val);

		getRightSideView(root.left, level+1, result);
		getRightSideView(root.right, level+1, result);

	}
}
