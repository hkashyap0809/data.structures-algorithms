package com.datastructures.binarytree;

public class CheckValidBST {
	public boolean validBSTHelper(TreeNode root, long low, long high){
		if ( root == null ) return true;
		if ( root.val <= low || root.val >= high ) return false;
		else
			return validBSTHelper(root.left,low,root.val) && validBSTHelper(root.right,root.val,high);
	}
	public boolean isValidBST(TreeNode root) {
		return validBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

}
