package com.striversde.string;

import java.util.Stack;

public class ReverseWordsInString {

	//using stack
	public static String reverseWordsStack(String s) {
		s = s.trim();
		int len = s.length();

		String rev = "";
		String currWord = "";
		Stack<String> stack= new Stack<>();

		for(int i = 0; i <len; i++) {
			char ch = s.charAt(i);

			if ( ch == ' ' && s.charAt(i-1)!= ' ') {
				stack.add(currWord.trim());
				currWord = "";
			}
			else {
				currWord = currWord + ch;
			}
			if ( i == len-1 ) {
				stack.add(currWord);
			}
		}
		while( !stack.isEmpty()) {			
			rev = rev + stack.peek()+" ";
			stack.pop();
		}
		return rev.trim();
	}
	
	//Better
	public static String reverseWordsBetter(String str) {
		int len = str.length();
		String revStr="";
		String currWord ="";
		for(int i = 0; i<len;i++) {
			char ch = str.charAt(i);
			//multiple space check
			if ( i>0 && ch == ' ' && str.charAt(i-1)==' ') continue;
			if ( ch == ' ' ) {
				revStr = " "+currWord + revStr;
				currWord = "";
			}else {
				currWord = currWord + ch ;
			}
			if ( i == len - 1) {
				revStr = currWord + revStr;
			}
		}
		return revStr.trim();
	}

}
