package com.datastructures.binarytree;

public class LCABinarySearchTree {
	public TreeNode LCAHelper(TreeNode root, TreeNode n1, TreeNode n2){

		if  ( root == null )    return null;

		if ( root.val == n1.val || root.val == n2.val )
			return root;
		else if ( root.val >= n1.val && root.val <=n2.val ) 
			return root;
		else if ( root.val < n1.val )
			return LCAHelper(root.right,n1,n2);
		else 
			return LCAHelper(root.left,n1,n2);

	}
	TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2){

		if ( n1.val < n2.val )  return LCAHelper(root,n1,n2);
		return LCAHelper(root,n2,n1);

	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return LCA(root,p,q);
	}

}
