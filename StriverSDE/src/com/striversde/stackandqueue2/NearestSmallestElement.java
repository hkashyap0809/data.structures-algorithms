package com.striversde.stackandqueue2;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallestElement {
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> nums) {

		ArrayList<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for(int num : nums ){

			while( !stack.empty() && stack.peek() >= num) stack.pop();


			if ( stack.empty() ){
				result.add(-1);
			}else{
				result.add(stack.peek());
			}
			stack.push(num);
		}
		return result;
	}

}
