package com.striversde.recursionbacktracking;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solve(board);
	}
	public boolean solve(char[][] board) {
		for(int i=0; i<9; i++) {
			for( int j=0; j<9; j++) {
				if( board[i][j] == '.' ) {
					for(char val = '1'; val<='9'; val++) {
						if ( canPlace(i,j,val,board) ) {
							board[i][j] = val;
							if ( solve(board) ) {
								return true;
							}else {
								board[i][j]='.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean canPlace(int row, int col, char val, char[][] board) {
		for(int i=0 ;i <9; i++) {
			if ( board[i][col] == val ) return false;
			if ( board[row][i] == val )	return false;
		}
		int nR = (row/3)*3;
		int nC = (col/3)*3;
		
		for(int i = nR; i<nR+3; i++) {
			for(int j = nC; j<nC+3; j++) {
				if ( board[i][j] == val)	return false;
			}
		}
		
		return true;
	}
}
