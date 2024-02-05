package com.kshema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {
		
	public static void main(String[] args)throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n");
		int n = sc.nextInt();
		List<String> allParantheses = generateParenthesis(n);
		System.out.println(allParantheses);
		System.out.println("total : " +allParantheses.size());
	}
	
	//Optimal
    public static void getAllParantheses(int n,int openParan, int closeParan, List<String> result,String bracket){
        if ( bracket.length() == 2*n ){
            result.add(bracket);
            return;
        }
        if ( openParan < n )
        	//put open parantheses
        	getAllParantheses(n,openParan+1,closeParan,result,bracket+"(");
         if ( openParan > closeParan)
        	 //put close parantheses
        	 getAllParantheses(n,openParan,closeParan+1,result,bracket+")");
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getAllParantheses(n,0,0,result,"");
        return result;       
    }

}
