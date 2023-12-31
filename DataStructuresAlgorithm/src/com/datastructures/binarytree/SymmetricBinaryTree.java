package com.datastructures.binarytree;

public class SymmetricBinaryTree {
	public boolean isSymmetricHelper(TreeNode root1, TreeNode root2){
		if( root1 == null && root2 == null )    return true;
		if( root1 != null && root2 != null && root1.val == root2.val ){
			boolean a = isSymmetricHelper(root1.left,root2.right);
			boolean b = isSymmetricHelper(root1.right,root2.left);
			return a == true && b == true;
		}else{
			return false;
		}
	}
	public boolean isSymmetric(TreeNode root) {
		TreeNode leftSubTree = root.left;
		TreeNode rightSubTree = root.right;
		return isSymmetricHelper(leftSubTree,rightSubTree);
	}

}
