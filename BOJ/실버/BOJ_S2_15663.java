package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220711
 * @title N과 M (9)
 */

public class BOJ_S2_15663 {
	static int N, M;
	static int[] arr;
	static int[] ans;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// **** input start ****

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		ans = new int[M];
		check = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// **** input end ****

		// 정렬
		Arrays.sort(arr);

		comb(0);

		System.out.println(sb);

	} // main end

	static void comb(int cnt) {
		// 기저조건
		if (cnt == M) {
			for (int i = 0; i < ans.length; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			// 이전 값 저장
			int before = 0;
			for (int i = 0; i < N; i++) {
				// 이미 뽑은 것이면
				if (check[i])
					continue;
				// 이전 값과 다르다면
				else if (before != arr[i]) {
					// 방문처리
					check[i] = true;
					// 정답 배열에 값 넣어주기
					ans[cnt] = arr[i];
					// 전의 값 갱신 -> 들어왔던 값이 전의 값으로 된다
					before = arr[i];
					comb(cnt + 1);
					// 백트래킹
					check[i] = false;
				}
			}
		}

	}

} // class end
