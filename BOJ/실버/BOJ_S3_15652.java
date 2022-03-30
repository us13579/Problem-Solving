package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-30, 20분
 * @title N과M(4)
 */


public class BOJ_S3_15652 {
	static StringTokenizer st;
	static int N, M;
	static int[] arr;
	static boolean[] v;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		arr = new int[M + 1];
		v = new boolean[N + 1];

		go(0, 1);
		System.out.println(sb);
	}

	static void go(int idx, int start) {
		// 기저조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N + 1; i++) {
			arr[idx] = i;
			go(idx + 1, i);
		}
	}
}
