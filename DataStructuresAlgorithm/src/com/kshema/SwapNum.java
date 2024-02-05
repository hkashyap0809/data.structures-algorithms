package com.kshema;

public class SwapNum {
	
	public static void main(String[] args) {
		long num1 = 45546;
		long num2 = 62732;
		
		System.out.println("Before swapping");
		System.out.println("num1 = "+num1);
		System.out.println("num2 = "+num2);
		
		
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		
		System.out.println("After swapping");
		System.out.println("num1 = "+num1);
		System.out.println("num2 = "+num2);
				
	}

}
