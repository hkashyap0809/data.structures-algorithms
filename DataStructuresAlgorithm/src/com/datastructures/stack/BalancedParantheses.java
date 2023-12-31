package com.datastructures.stack;

import java.util.Stack;

public class BalancedParantheses {
	public boolean isValid(String str) {
		Stack<Character> stack = new Stack<Character>();
		int len = str.length();

		for(int i=0; i<len; i++){
			char ch = str.charAt(i);
			if ( ch == '(' || ch == '{' || ch == '[' ){
				stack.push(ch);
			}else{
				if( stack.empty() ) return false;
				char topChar = stack.peek();
				if ( ch == '}' && topChar=='{') stack.pop();
				else if ( ch == ')' && topChar=='(') stack.pop();
				else if ( ch == ']' && topChar=='[') stack.pop();
				else return false;
			}
		}
		return stack.empty();
	}

}
