package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-03-05, 25분
 * @title 정수 삼각형
 */

public class BOJ_S1_1932 {
    static StringTokenizer st;
    static int[][] arr;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 삼각형 크기
        N = Integer.parseInt(br.readLine());

        // 삼각형 값들
        arr = new int[N][N];

        dp = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + arr[i][j];
            }
        }
        System.out.println(dp[0][0]);

    }
}
