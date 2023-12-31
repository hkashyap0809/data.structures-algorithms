package com.datastructures.binarytree;

public class KthSmallestElementBinarySearchTree {
	public static int kthSmallest(TreeNode root, int k) {
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

}
