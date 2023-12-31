package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
	static boolean canPlaceQueen(int rowIdx, int colIdx,int n, char[][] ds) {
		int tempRowIdx = rowIdx;
		int tempColIdx = colIdx;
		
//		diagonal checks
		while(tempRowIdx>=0 && tempColIdx>=0) {
			if(ds[tempRowIdx][tempColIdx]=='Q')
				return false;
			tempRowIdx--;
			tempColIdx--;
		}
		
		tempRowIdx = rowIdx;
		tempColIdx = colIdx;
		
		while(tempRowIdx<n && tempColIdx>=0) {
			if(ds[tempRowIdx][tempColIdx]=='Q')
				return false;
			tempRowIdx++;
			tempColIdx--;
		}
		
		tempRowIdx = rowIdx;
		tempColIdx = colIdx;
		
		while(tempColIdx>=0) {
			if(ds[tempRowIdx][tempColIdx] == 'Q') {
				return false;
			}
			tempColIdx--;
		}
		return true;
	}

	static void solveNqueens(int n,int colIdx,char[][] ds,List<List<String>> result) {
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
			if(canPlaceQueen(rowIdx, colIdx, n, ds)) {
				ds[rowIdx][colIdx] = 'Q';
				solveNqueens(n, colIdx+1, ds, result);
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
		
		solveNqueens(n,0,ds,result);
		return result;

	}

	public static void main(String[] args) {
		List<List<String>> res = solveNQueens(4);
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i).toString());
		}

	}

}
