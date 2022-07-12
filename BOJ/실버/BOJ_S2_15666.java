package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220712
 * @title N과 M ( 12 )
 */

public class BOJ_S2_15666 {
	static int N, M;
	static int[] arr;
	static int[] res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// **** input start ****
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		res = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
		}
		// **** input end ****

		// 정렬
		Arrays.sort(arr);

		dfs(0, 0);

		// 출력
		System.out.println(sb);
	}

	// comb
	static void dfs(int start, int idx) {
		// 기저조건
		if (idx == M) {
			// 결과값들 출력
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 이전 값 확인 용도
		int num = 0;
		for (int i = start; i < N; i++) {
			// 그전 값이랑 같다면
			if (arr[i] == num)
				continue;

			// 결과 배열에 넣기
			res[idx] = arr[i];
			dfs(i, idx + 1);
			num = arr[i];
		}

	}
}
