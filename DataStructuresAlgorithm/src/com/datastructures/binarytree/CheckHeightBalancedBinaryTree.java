package com.datastructures.binarytree;

public class CheckHeightBalancedBinaryTree {
	public int isBalancedHelper(TreeNode root){
		if( root == null )  return 0;

		int leftHeight = isBalancedHelper(root.left);
		int rightHeight = isBalancedHelper(root.right);

		if( leftHeight == -1 || rightHeight == -1)  return -1;
		if( Math.abs(leftHeight - rightHeight) > 1 )    return -1;
		return Math.max(leftHeight,rightHeight) + 1;
	}
	public boolean isBalanced(TreeNode root) {
		return isBalancedHelper(root) != -1;
	}

}
