package com.datastructures.trie;

import java.util.Arrays;

public class MaxAndXor{
	//	Given an array, Find the number of pairs which satisfy the condition:
	//		condition= ( nums[i] & nums[j] ) >= ( nums[i]^nums[j] )
	//		Constraints: 1 <= n <= 10^5;
	//	
	static class BinaryTrieNode{

		BinaryTrieNode[] children;

		int count;
		BinaryTrieNode() {
			children = new BinaryTrieNode[2];
			Arrays.fill(children, null);
			count = 0;
		}
	}

	static class BinaryTrie{

		private BinaryTrieNode binaryTrieRoot;

		public BinaryTrie() {
			binaryTrieRoot = new BinaryTrieNode();
		}

		public int insert(String binaryString) {
			int retVal = -1;
			BinaryTrieNode tempBinaryTrieRoot = binaryTrieRoot;
			for( int i =0; i< 32; i++) {
				char ch = binaryString.charAt(i);
				int idx = ch - '0';

				if( tempBinaryTrieRoot.children[idx] == null ) {
					tempBinaryTrieRoot.children[idx] = new BinaryTrieNode();
					tempBinaryTrieRoot.children[idx].count++;
				}else {
					if ( idx == 1 && retVal == -1) {
						retVal = tempBinaryTrieRoot.children[idx].count;
					}
					tempBinaryTrieRoot.children[idx].count++;
				}
				tempBinaryTrieRoot = tempBinaryTrieRoot.children[idx];
			}
			return retVal == -1 ? 0 : retVal;
		}
	}
	public static int findMaxAndXor(int[] nums) {

		int countPairs = 0;
		BinaryTrie binaryTrie = new BinaryTrie();
		for(int num : nums ) {

			String str = String.format("%32s", Integer.toBinaryString(num)).replaceAll(" ","0");
			countPairs += binaryTrie.insert(str);
		}
		return countPairs;
	}


	public static int findMaxAndXorBrute(int[] nums) {

		int countPairs = 0;
		for(int i =0; i< nums.length; i++) {
			for(int j=i+1;j<nums.length; j++) {
				if((nums[i]&nums[j])>=(nums[i]^nums[j]))	countPairs++;
			}
		}
		return countPairs;
	}

	public static void main(String [] args) {
		int[] arr = {3,5,6,7,32,4,5,3,6,3,7,8,9,3,5,6,7,8,3,1,31,13,141,6,16,17,1723,21,14,3,3};
		int actual = findMaxAndXorBrute(arr);
		int expec = findMaxAndXorBrute(arr);
		System.out.println("expected "+expec+ "  actual "+actual);
	}
}
