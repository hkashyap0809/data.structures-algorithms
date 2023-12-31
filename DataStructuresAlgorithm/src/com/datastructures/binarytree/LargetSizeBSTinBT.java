package com.datastructures.binarytree;

public class LargetSizeBSTinBT {
	static class Tuple{
		int size;
		int largest;
		int smallest;
		Tuple(int size, int largest, int smallest){
			this.size = size;
			this.largest = largest;
			this.smallest = smallest;
		}
	}

	public static boolean isLeaf(TreeNode node){
		return (node.left == null && node.right == null) ;
	}
	private static Tuple postOrder(TreeNode root ){
		if ( root == null ) return new Tuple(0,Integer.MIN_VALUE, Integer.MAX_VALUE);
		if ( isLeaf(root) ) return new Tuple(1,root.val,root.val);

		Tuple leftSubTree = postOrder(root.left);
		Tuple rightSubTree = postOrder(root.right);
		if( leftSubTree.largest < root.val && root.val < rightSubTree.smallest ){
			//it is a BST
			int bstSize = 1 + leftSubTree.size + rightSubTree.size;

			int bstLargest = Math.max(rightSubTree.largest,root.val);

			int bstSmallest = Math.min(leftSubTree.smallest,root.val);

			return new Tuple(bstSize,bstLargest,bstSmallest);
		}else{
			return new Tuple( Math.max(leftSubTree.size,rightSubTree.size), Integer.MAX_VALUE,Integer.MIN_VALUE);   
		}
	}
	public static int largestBST(TreeNode root) {
		Tuple tree = postOrder(root);
		return tree.size;
	}
}