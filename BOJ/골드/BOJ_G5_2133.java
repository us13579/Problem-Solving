package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 2022-04-01, 2시간
 * @title 타일 채우기
 */

public class BOJ_G5_2133 {
	static int[] dp;
	static int N;
	static int res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+2];
		dp[0] = 1;
		dp[2] = 3;

		if(N>=4) {
			for(int i=4; i<=N; i++) {
				dp[i] += dp[i-2]*dp[2];
				for(int j = 4; j <= i; j += 2) {
					dp[i] += dp[i-j]*2;
				}
			}
		}
		
		System.out.println(dp[N]);
			
	}
}
