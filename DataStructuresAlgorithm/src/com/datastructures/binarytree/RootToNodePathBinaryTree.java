package com.datastructures.binarytree;

import java.util.ArrayList;

public class RootToNodePathBinaryTree {
	public boolean pathToNodeHelper(TreeNode root, int key, ArrayList<Integer> path){

		if( root == null )  return false;

		if ( root.val == key ){
			path.add(root.val);
			return true;
		}

		path.add(root.val);

		boolean left = pathToNodeHelper(root.left,key,path);
		if( left == true ){
			//path exists -> no need to go to right
			return true;   
		}
		boolean right = pathToNodeHelper(root.right,key,path);
		if( right == true ){
			//path exists
			return true;
		}else{
			//path does not exists
			path.remove(path.size()-1);
			return false;
		}
	}
	public ArrayList<Integer> pathToNode(TreeNode root, int B) {
		ArrayList<Integer> path = new ArrayList<>();
		pathToNodeHelper(root,B,path);
		return path;
	}

}
