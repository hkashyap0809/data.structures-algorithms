package com.datastructures.binarytree;

public class FloorBinarySearchTree {
	public static void floorInBSTHelper(TreeNode root, int key, int[] ans){
		if( root == null )  return;
		if( root.val == key ){
			ans[0] = root.val;
			return;
		}
		if( root.val < key ){
			ans[0] = root.val;
			floorInBSTHelper(root.right,key,ans);
		}else{
			floorInBSTHelper(root.left,key,ans);
		}
	}
	public static int floorInBST(TreeNode root, int key) {
		int[] ans = new int[1];
		floorInBSTHelper(root,key,ans);
		return ans[0];
	}

}
