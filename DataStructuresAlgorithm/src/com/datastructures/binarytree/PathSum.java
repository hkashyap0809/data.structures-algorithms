package com.datastructures.binarytree;

public class PathSum {
	public boolean pathSumHelper(TreeNode root, int targetSum){

		if( root == null ) return false;
		if ( root.left == null && root.right == null && targetSum == root.val )   return true;

		boolean left = pathSumHelper(root.left , targetSum - root.val);
		if( left == true )   return true;
		boolean right = pathSumHelper(root.right , targetSum - root.val);
		if( right == true ) return true;
		return false;
	}
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if ( root == null ) return false;
		return pathSumHelper(root,targetSum);
	}

}
 