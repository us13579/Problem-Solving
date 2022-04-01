package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-11, 1시간
 * @title 다리 놓기, 실버 5
 */

public class BOJ_S5_1010 {
	static StringTokenizer st;
	static int N,M;
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int res =comb(M,N);
			sb.append(res).append("\n");
			
		}
		System.out.println(sb);
	}
	
	// nCr 구하기
	static int comb(int n, int r) {
		// 기저조건
		if(r == 0 || n == r) {
			return 1;
		}
		
		// 기존 값이 있는 경우
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		// 메모이제이션
		return dp[n][r] = comb(n-1,r-1) + comb(n-1,r);
	}
}
