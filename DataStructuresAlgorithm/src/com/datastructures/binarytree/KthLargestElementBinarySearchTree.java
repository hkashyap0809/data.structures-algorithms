package com.datastructures.binarytree;

public class KthLargestElementBinarySearchTree {
	public static Integer kthSmallest(TreeNode root, int k) {
		int count = 0 ;
		TreeNode curr = root;

		while( curr != null ){
			if( curr.left == null ){
				count++;
				if( count == k )return curr.val;
				curr = curr.right;
			}else{
				TreeNode tempCurr = curr.left;

				//go to the last node
				while( tempCurr.right !=null && tempCurr.right != curr ){
					tempCurr = tempCurr.right;
				}

				if( tempCurr.right == null ){
					//not threaded
					tempCurr.right = curr;
					curr = curr.left;
				}else{
					//already threaded
					tempCurr.right = null;          //break the link
					count++;
					if( count == k )return curr.val;
					curr = curr.right;
				}
			}
		}
		return -1;
	}
	public static int findNodes(TreeNode root){
		if( root == null )	return 0;
		return 1 + findNodes(root.left) + findNodes(root.right);

	}
	public static int KthLargestNumber(TreeNode root, int k) {
		int n = findNodes(root);
		return kthSmallest(root,n-k+1);
	}

}
