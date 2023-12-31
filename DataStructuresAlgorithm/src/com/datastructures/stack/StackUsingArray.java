package com.datastructures.stack;


public class StackUsingArray {
	int top = -1;
	int[] arr;
	StackUsingArray(int capacity) {
		// Write your code here.
		arr = new int[capacity];
	}
	public void push(int num) {
		// Write your code here.
		if ( top >= arr.length - 1) return;
		top++;
		arr[top] = num;

	}
	public int pop() {
		// Write your code here.
		if ( top <= -1 )    return -1;
		int val = arr[top];
		top--;
		return val;
	}
	public int top() {
		// Write your code here.
		if ( top == -1 )    return -1;
		return arr[top];
	}
	public int isEmpty() {
		// Write your code here.
		return top == -1 ? 1 :  0;
	}
	public int isFull() {
		return top == arr.length ? 1 : 0;
	}
}