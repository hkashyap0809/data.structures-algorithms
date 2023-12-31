package com.datastructures.binarytree;

public class DiameterBinaryTree {

	//Brute
	public int height(TreeNode root) {
		if( root == null ) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public void diameterHelper(TreeNode root, int[] diameter) {
		if( root == null ) return;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		diameter[0] = Math.max(diameter[0],leftHeight+rightHeight);
		diameterHelper(root.left, diameter);
		diameterHelper(root.right, diameter);
	}
	public int diameterOfBinaryTreeBrute(TreeNode root) {
		int[] diameter = new int[1];
		diameterHelper(root,diameter);
		return diameter[0];
	}
	

	//Optimal
	public int diameterOfBinaryTree(TreeNode root) {
		int[] diameter = new int[1];
		int height = diameterHelperOptimal(root,diameter);
		return diameter[0];

	}

	private int diameterHelperOptimal(TreeNode root, int[] diameter) {
		if ( root == null ) return 0;

		int leftHeight = diameterHelperOptimal(root.left, diameter);
		int rightHeight = diameterHelperOptimal(root.right, diameter);
		diameter[0] = Math.max( diameter[0], leftHeight+rightHeight);
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
