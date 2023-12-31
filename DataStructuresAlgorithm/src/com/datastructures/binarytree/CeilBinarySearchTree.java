package com.datastructures.binarytree;

public class CeilBinarySearchTree {
	public static void findCeilHelper(TreeNode node, int key, int[] ans){
		if( node == null )  return;
		if( node.val == key ){
			ans[0] = node.val;
			return;
		}

		if( node.val > key ){
			ans[0] = node.val;
			findCeilHelper(node.left,key,ans);
		}else{
			findCeilHelper(node.right,key,ans);
		}
	}
	public  static int findCeil(TreeNode node, int key) {

		int[] ans = new int[1];
		ans[0]=-1;
		findCeilHelper(node,key,ans);
		return ans[0];

	}
}
