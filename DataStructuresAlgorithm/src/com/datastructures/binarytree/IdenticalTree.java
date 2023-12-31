package com.datastructures.binarytree;

public class IdenticalTree {
	public boolean isSameTreeHelper(TreeNode root1, TreeNode root2){
		
		if( root1 == null && root2 == null )    return true;
		if( root1 == null && root2 !=null || root1 != null && root2 == null )   return false;
		if( root1.val == root2.val ){
			boolean left =  isSameTreeHelper(root1.left,root2.left);
			boolean right =  isSameTreeHelper(root1.right,root2.right);
			return (left==true && right == true);
		}
		else{
			return false;
		}
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return isSameTreeHelper(p,q);
	}
	
	public boolean isSameTreeReference(TreeNode p, TreeNode q) {
        if( p == null && q != null || p != null && q == null ){
            return false;
        }else if( p==null && q == null ){
            return true;
        }else{
            return (p.val == q.val) && isSameTreeReference(p.left,q.left) && isSameTreeReference(p.right,q.right);
        }   
    }

}
