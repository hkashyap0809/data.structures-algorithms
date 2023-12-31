package com.datastructures.binarytree;

public class MaxPathSum {

	public int maxPathSum(TreeNode root, int[] ans) {
		if( root == null ) return 0;

		int left = Math.max(0 , maxPathSum(root.left,ans));
		int right = Math.max(0 , maxPathSum(root.right,ans));
		ans[0] = Math.max( ans[0], root.val + left+right);
		return root.val + Math.max(left, right);

	}
	public int maxPathSum(TreeNode root) {
		int[] ans = new int[1];
		ans[0] = Integer.MIN_VALUE;
		maxPathSum(root,ans);
		return ans[0];

	}
}
