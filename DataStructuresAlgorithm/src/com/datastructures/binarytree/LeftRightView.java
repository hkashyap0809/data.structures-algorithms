package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftRightView {
	//Right View
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		getRightSideView(root,0,result);
		return result;


	}

	private void getRightSideView(TreeNode root, int level, List<Integer> result) {
		if ( root == null )	return;
		if ( level == result.size() )	result.add(root.val);

		getRightSideView(root.right, level+1, result);
		getRightSideView(root.left, level+1, result);

	}

	//Left View
	public ArrayList<Integer> leftView(Node root){
		ArrayList<Integer> result = new ArrayList<>();
		getRightSideView(root,0,result);
		return result;


	}

	private void getRightSideView(Node root, int level, ArrayList<Integer> result) {
		if ( root == null )	return;
		if ( level == result.size() )	result.add(root.data);

		getRightSideView(root.left, level+1, result);
		getRightSideView(root.right, level+1, result);

	}

}
