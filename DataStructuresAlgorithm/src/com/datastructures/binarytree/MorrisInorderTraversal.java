package com.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		TreeNode curr = root;

		while( curr != null ){
			if( curr.left == null ){
				result.add(curr.val);
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
					result.add(curr.val);
					curr = curr.right;
				}
			}
		}
		return result;

	}

}
