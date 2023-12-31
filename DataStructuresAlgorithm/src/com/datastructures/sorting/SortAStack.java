package com.datastructures.sorting;

import java.util.Stack;

public class SortAStack {
	public Stack<Integer> sort(Stack<Integer> s){
		sortStack(s);
		return s;
	}
	public void sortStack(Stack<Integer> stack){
		if ( stack.size() == 0 )    return;

		int topEl = stack.peek();
		stack.pop();
		sortStack(stack);

		insertInStack(stack,topEl);
	}

	public void insertInStack(Stack<Integer> stack, int elem){
		if ( stack.size() == 0 ) {
			stack.push(elem);
			return;
		}
		if( stack.peek() > elem ){
			int topEl = stack.peek();
			stack.pop();
			insertInStack(stack,elem);
			stack.push(topEl);
		}else{
			stack.push(elem);
		}

	}
	

}
