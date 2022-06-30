package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/****
 * 
 * @author us13579
 * @since 220630
 * @title DSLR
 */

public class BOJ_G4_9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// **** input start ****
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// **** input end ****

			boolean[] v = new boolean[10000];
			String[] command = new String[10000];
			Queue<Integer> queue = new LinkedList<Integer>();

			queue.add(A);
			// 방문처리
			v[A] = true;
			Arrays.fill(command, "");

			while (!queue.isEmpty() && !v[B]) {
				int temp = queue.poll();

				// DSLR
				int D = (temp * 2) % 10000;
				int S = temp == 0 ? 9999 : temp - 1;
				int L = (temp % 1000) * 10 + (temp / 1000);
				int R = (temp % 10) * 1000 + (temp / 10);

				if (!v[D]) {
					// 방문처리
					v[D] = true;
					// 문자 추가
					command[D] = command[temp] + "D";
					// queue 더하기
					queue.add(D);
				}
				if (!v[S]) {
					// 방문처리
					v[S] = true;
					// 문자 추가
					command[S] = command[temp] + "S";
					// queue 더하기
					queue.add(S);
				}
				if (!v[L]) {
					// 방문처리
					v[L] = true;
					// 문자 추가
					command[L] = command[temp] + "L";
					// queue 더하기
					queue.add(L);
				}
				if (!v[R]) {
					// 방문처리
					v[R] = true;
					// 문자 추가
					command[R] = command[temp] + "R";
					// queue 더하기
					queue.add(R);
				}
			}
			sb.append(command[B]).append("\n");
		}
		System.out.println(sb);
	} // main end
} // class end
