package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220621
 * @title Four Squares
 * 
 */

public class BOJ_S4_17626 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		// 0을 제곱의 합으로 나타낸 개수 ( 0 )
		dp[0] = 0;
		// 1을 제곱의 합으로 나타낸 개수 ( 1 * 1 )
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				// 최소값을 구한다
				min = Math.min(min, dp[i-(j*j)]);
			}
			// 최소값에 1을 더해준다
			dp[i] = min+1;
		}
		// 출력
		System.out.println(dp[n]);
	}
}
