package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-28, 30분
 * @title 스티커
 */

public class BOJ_S1_9465 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// testcase
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[2][n+1];

			// 배열 입력
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < n + 1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// dp 배열 초기화
			int[][] dp = new int[2][n + 1];

			// 제일 처음에 있는 값 설정
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

				// 본인보다 더 작은 2값이랑 비교하기 때문에 2부터 시작
				for (int j = 2; j < n + 1; j++) {
					// 위에 줄
					dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
					
					// 아래줄
					dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
				}
				
				sb.append(Math.max(dp[0][n],dp[1][n])).append("\n");
				
		}
		System.out.println(sb);
	}
}
