package com.datastructures.binarytree;

public class LCABinaryTree {
	
	public TreeNode LCAHelper(TreeNode root, TreeNode p, TreeNode q) {
		if( root == null )	return null;
		
		if( root == p ) return p;
		if( root == q )	return q;
		
		
		TreeNode left = LCAHelper(root.left,p,q);
		TreeNode right = LCAHelper(root.right,p,q);
		
		
		if( right == null ) 	return left;
		else if( left == null)	return right;
		else	return root;

			
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return LCAHelper(root,p,q);
	}

}
