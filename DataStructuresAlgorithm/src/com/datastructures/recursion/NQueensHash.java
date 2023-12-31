package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensHash {
	static boolean canPlaceQueen(int rowIdx,int colIdx,int[] rowMap, int n, int[] lrDiagonalMap, int[] rlDiagonalMap) {
		if(rowMap[rowIdx]==1) return false;
		if(lrDiagonalMap[rowIdx+colIdx]==1)	return false;
		if(rlDiagonalMap[n-1 + colIdx - rowIdx]==1)	return false;
		
		return true;
	}
	static void solveNqueens(int n,int colIdx,char[][] ds,List<List<String>> result, int[] rowMap, int[] lrDiagonalMap, int[] rlDiagonalMap) {
		if(colIdx==n) {
			List<String> newDs = new ArrayList<>();
			for(int i=0;i<ds.length;i++) {
				String str = "";
				for(int j=0;j<ds[0].length;j++) {
					str=str+ds[i][j];
				}
				newDs.add(str);
			}
			System.out.println("inserting "+newDs.toString());
			result.add(new ArrayList<>(newDs));
			return;
		}
		
		for (int rowIdx=0; rowIdx<n;rowIdx++) {
			if(canPlaceQueen(rowIdx, colIdx,rowMap,n,lrDiagonalMap,rlDiagonalMap)) {
				
				ds[rowIdx][colIdx] = 'Q';
				rowMap[rowIdx]=1;
				lrDiagonalMap[rowIdx+colIdx]=1;
				rlDiagonalMap[n-1+colIdx-rowIdx]=1;
				solveNqueens(n, colIdx+1, ds, result,rowMap,lrDiagonalMap,rlDiagonalMap);
				rowMap[rowIdx]=0;
				lrDiagonalMap[rowIdx+colIdx]=0;
				rlDiagonalMap[n-1+colIdx-rowIdx]=0;
				ds[rowIdx][colIdx] = '.';
			}
		}
	}
	
	static public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		char[][] ds = new char[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(ds[i], '.');
		}
		int[] rowMap = new int[n];
		int[] lrDiagonalMap = new int[2*n-1];
		int[] rlDiagonalMap = new int[2*n-1];
		Arrays.fill(rowMap, 0);
		Arrays.fill(lrDiagonalMap,0);
		Arrays.fill(rlDiagonalMap, 0);
		
		
		
		
		solveNqueens(n,0,ds,result,rowMap,lrDiagonalMap,rlDiagonalMap);
		return result;

	}

	public static void main(String[] args) {
		List<List<String>> res = solveNQueens(4);
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i).toString());
		}

	}

}
