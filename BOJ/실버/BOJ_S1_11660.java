package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author us13579
 * @title 구간 합 구하기 5
 * @since 220531
 */

public class BOJ_S1_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		// 표의 크기
		int N = Integer.parseInt(st.nextToken());
		// 합을 구해야 하는 횟수
		int M = Integer.parseInt(st.nextToken());

		// map
		int[][] map = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// DP 저장 배열 -> ( 1,1 ) 에서 ( i,j ) 까지의 합
				int[][] dp = new int[N+1][N+1];
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
					}
				}
		// 범위
		int x1,y1,x2,y2;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			sb.append((dp[x2][y2] -dp[x2][y1-1]-dp[x1-1][y2] +dp[x1-1][y1-1]) + "\n");
		}

		System.out.println(sb);
	}
}
