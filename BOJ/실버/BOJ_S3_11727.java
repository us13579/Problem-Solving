package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220629
 * @title 2*n 타일링 2
 */

public class BOJ_S3_11727 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 3;
		for(int i=2; i<N; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
		}
		
		System.out.println(dp[N-1]);
	}
}
