package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-09, 1시간
 * @title 퍼펙트 셔플 (D3)
 */

public class SWEA_3499 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		
		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 카드 수
			int N = Integer.parseInt(br.readLine());

			// 카드 담을 리스트
			ArrayList<String> list = new ArrayList<String>();

			// 짝수인 경우
			if (N % 2 == 0) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int i = 0; i < N; i++) {
					list.add(st.nextToken());
				}
				
				// 홀수번째 index
				int point = 1;
				
				// 사이에 넣어주고 삭제
				for (int i = N / 2; i < N; i++) {
					String move = list.get(i);
					list.remove(i);
					list.add(point, move);
					point += 2;
				}

				// 출력
				for (int i = 0; i < N; i++) {
					sb.append(list.get(i)).append(" ");
				}

				sb.append("\n");
			}
			// 홀수인경우
			else {
				st = new StringTokenizer(br.readLine(), " ");
				for (int i = 0; i < N; i++) {
					list.add(st.nextToken());
				}

				// 홀수번째 index
				int point = 1;
				
				// 사이에 넣어주고 삭제
				for (int i = N / 2 + 1; i < N; i++) {
					String move = list.get(i);
					list.remove(i);
					list.add(point, move);
					point += 2;
				}

				// 출력
				for (int i = 0; i < N; i++) {
					sb.append(list.get(i)).append(" ");
				}

				sb.append("\n");
			}
		}

		// 전체 출력
		System.out.println(sb);
	}
}
