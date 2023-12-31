package com.datastructures.dp;

import java.util.Arrays;

public class EvaluateBooleanExpression {

	private static int evaluateExpressionRec(int i, int j, boolean isTrue, String exp,int mod) {
		if ( i > j )	return 0;
		if ( i == j ){
			if ( isTrue ) 
				return exp.charAt(i) == 'T' ? 1 : 0;
			else
				return exp.charAt(i) == 'F' ? 1 : 0;
		}

		int ans = 0;
		for ( int idx = i+1; idx <= j-1 ; idx++) {

			int leftTrue = evaluateExpressionRec(i , idx-1, true, exp,mod);
			int leftFalse = evaluateExpressionRec(i , idx-1, false, exp,mod);

			int rightTrue = evaluateExpressionRec(idx+1, j, true, exp,mod);
			int rightFalse = evaluateExpressionRec(idx+1, j, false, exp,mod);

			if ( exp.charAt(idx) == '&' ) {
				if ( isTrue ) {
					ans += leftTrue*rightTrue;
					ans %= mod;
				}else {
					ans+= leftFalse * rightTrue + leftTrue * rightFalse + leftFalse * rightFalse;
					ans %=mod;
				}
			}
			if ( exp.charAt(idx) == '|' ) {
				if ( isTrue ) {
					ans += leftTrue*rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
					ans %= mod;
				}else {
					ans+= leftFalse * rightFalse;
					ans %=mod;
				}
			}
			if ( exp.charAt(idx) == '^' ) {
				if ( isTrue ) {
					ans += leftFalse * rightTrue + leftTrue * rightFalse;
					ans %= mod;
				}else {
					ans+= leftTrue*rightTrue  + leftFalse * rightFalse;
					ans %=mod;
				}
			}
		}
		return ans%mod;

	}
	public static int evaluateExpRec(String exp) {
		int mod = 1000000007;
		return evaluateExpressionRec(0,exp.length()-1,true,exp,mod);
	}
	//Memoization
	private static int evaluateExpressionMem(int i, int j, int isTrue, String exp,int mod,int[][][] dp) {
		if ( i > j )	return 0;
		if ( i == j ){
			if ( isTrue == 1 ) 
				return exp.charAt(i) == 'T' ? 1 : 0;
			else
				return exp.charAt(i) == 'F' ? 1 : 0;
		}

		if ( dp[i][j][isTrue] !=- 1 )	return dp[i][j][isTrue];

		long ans = 0;
		for ( int idx = i+1; idx <= j-1 ; idx+=2) {

			int leftTrue = evaluateExpressionMem(i , idx-1, 1, exp,mod,dp);
			int leftFalse = evaluateExpressionMem(i , idx-1, 0, exp,mod,dp);

			int rightTrue = evaluateExpressionMem(idx+1, j, 1, exp,mod,dp);
			int rightFalse = evaluateExpressionMem(idx+1, j, 0, exp,mod,dp);

			if ( exp.charAt(idx) == '&' ) {
				if ( isTrue == 1 ) {
					ans = (ans + (leftTrue * rightTrue)%mod) % mod;
				}else {
					ans = ( ans + (leftFalse * rightTrue)%mod + (leftTrue * rightFalse)%mod + (leftFalse * rightFalse)%mod ) % mod;
					
				}
			}
			if ( exp.charAt(idx) == '|' ) {
				if ( isTrue == 1 ) {
					ans = (ans + (leftTrue * rightTrue)%mod + (leftFalse * rightTrue)%mod + (leftTrue * rightFalse)%mod) %mod  ; 
				}else {
					ans = (ans + (leftFalse * rightFalse)%mod )%mod;
				}
			}
			if ( exp.charAt(idx) == '^' ) {
				if ( isTrue == 1 ) {
					ans = ( ans + (leftFalse * rightTrue)%mod +  (leftTrue * rightFalse)%mod ) % mod;
					
				}else {
					ans =(ans + (leftTrue * rightTrue)%mod + (leftFalse * rightFalse)%mod ) % mod;
				}
			}
		}
		dp[i][j][isTrue] = (int)ans;
		return (int)ans;

	}
	public static int evaluateExpMem(String exp) {
		int mod = 1000000007;
		int n = exp.length();
		int[][][] dp = new int[n][n][2];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				Arrays.fill(dp[i][j],-1);
			}
		}
		return evaluateExpressionMem(0,exp.length()-1,1,exp,mod,dp);
	}
	//Tabulation
	public static int evaluateExpTab(String exp) {
		int n= exp.length();
		int[][][] dp = new int[n][n][2];
		int mod = 1000000007;
		
		
		for(int i=0; i<n; i++) {
			dp[i][i][1] = exp.charAt(i) == 'T' ? 1 : 0;
			dp[i][i][0] = exp.charAt(i) == 'F' ? 1 : 0;
		}
		
		
		for(int i=n-1; i>=0;i--) {
			for(int j = i+1; j<n; j++) {
				
				for(int isTrue =0; isTrue<2; isTrue++) {
					
			
					long ans = 0;
					for ( int idx = i+1; idx <= j-1 ; idx+=2) {

						int leftTrue = dp[i][idx-1][1];
						int leftFalse = dp[i][idx-1][0];

						int rightTrue = dp[idx+1][j][1];
						int rightFalse = dp[idx+1][j][0];

						if ( exp.charAt(idx) == '&' ) {
							if ( isTrue == 1 ) {
								ans = (ans + (leftTrue * rightTrue)%mod) % mod;
							}else {
								ans = ( ans + (leftFalse * rightTrue)%mod + (leftTrue * rightFalse)%mod + (leftFalse * rightFalse)%mod ) % mod;
								
							}
						}
						if ( exp.charAt(idx) == '|' ) {
							if ( isTrue == 1 ) {
								ans = (ans + (leftTrue * rightTrue)%mod + (leftFalse * rightTrue)%mod + (leftTrue * rightFalse)%mod) %mod  ; 
							}else {
								ans = (ans + (leftFalse * rightFalse)%mod )%mod;
							}
						}
						if ( exp.charAt(idx) == '^' ) {
							if ( isTrue == 1 ) {
								ans = ( ans + (leftFalse * rightTrue)%mod +  (leftTrue * rightFalse)%mod ) % mod;
								
							}else {
								ans =(ans + (leftTrue * rightTrue)%mod + (leftFalse * rightFalse)%mod ) % mod;
							}
						}
					}
					dp[i][j][isTrue] = (int)ans;
				}

			}
		}
		return dp[0][n-1][1];
	}
}
