package com.datastructures.binarytree;

public class SearchBinarySeachTree {
	public TreeNode searchBSTHelper(TreeNode root, int val){
		if( root != null && root.val == val )   return root;
		if( root == null )  return null;

		if( val > root.val ){
			return searchBSTHelper( root.right, val );
		}else{
			return searchBSTHelper(root.left , val );
		}
	}
	public TreeNode searchBST(TreeNode root, int val) {
		return searchBSTHelper(root,val);
	}
}
