package com.datastructures.binarytree;

public class LargestSumBSTinBT {
	static class Tuple{
		int sum;
		int largest;
		int smallest;
		Tuple(int sum, int largest, int smallest){
			this.sum = sum;
			this.largest = largest;
			this.smallest = smallest;
		}
	}
	public static boolean isLeaf(TreeNode node){
		return (node.left == null && node.right == null) ;
	}
	private static Tuple postOrder(TreeNode root,int[] result ){
		if ( root == null ) return new Tuple(0,Integer.MIN_VALUE, Integer.MAX_VALUE);
		// if ( isLeaf(root) ) return new Tuple(root.val,root.val,root.val);

		Tuple leftSubTree = postOrder(root.left,result);
		Tuple rightSubTree = postOrder(root.right,result);
		if( leftSubTree.largest < root.val && root.val < rightSubTree.smallest ){
			//it is a BST
			int bstSum = root.val + leftSubTree.sum + rightSubTree.sum;
			result[0] = Math.max(result[0],bstSum);
			int bstLargest = Math.max(rightSubTree.largest,root.val);

			int bstSmallest = Math.min(leftSubTree.smallest,root.val);

			return new Tuple(bstSum,bstLargest,bstSmallest);
		}
		return new Tuple( Math.max(leftSubTree.sum,rightSubTree.sum), Integer.MAX_VALUE,Integer.MIN_VALUE);   

	}
	public int maxSumBST(TreeNode root) {
		int[] result = {0};
		Tuple maxSum = postOrder(root,result);
		return Math.max(0,result[0]);
	}

}
