package com.datastructures.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n2 = nums2.length;
        Stack<Integer> stack = new Stack();
        for(int i=n2-1;i>=0;i--){
            while( !stack.empty() && stack.peek() < nums2[i] ) stack.pop();

            if ( stack.empty() ){
                hashMap.put(nums2[i],-1);
            }else{
                hashMap.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<res.length;i++){
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
        
    }


}
