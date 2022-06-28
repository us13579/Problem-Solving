package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220628
 * @title 마인크래프트
 */

public class BOJ_S2_18111 {
	static int N, M, B;
	static int max_floor, min_floor;
	static int time, height;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// **** input start ****

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		max_floor = Integer.MIN_VALUE;
		min_floor = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 최대층 최소층 구하기
				max_floor = Math.max(max_floor, map[i][j]);
				min_floor = Math.min(min_floor, map[i][j]);
			}
		}

		// **** input end ****

		// 층마다 체크
		check();
		
		System.out.println(time + " " + height);

	} // main end

	// 층을 기준으로 체크
	static void check() {
		// 결과 시간
		time = Integer.MAX_VALUE;
		// 결과 층
		height = -1;

		for (int i = min_floor; i <= max_floor; i++) {
			// 인벤토리
			int invent = B;
			// 체크하는 시간
			int second = 0;
			
			for(int j=0; j<N; j++) {
				for(int z=0; z<M; z++) {
					// 좌표와 층 차이
					int minus = map[j][z] - i;
					
					// 좌표가 더 큰 경우 1번 실행
					if(minus > 0) {
						// 시간 추가
						second += (Math.abs(minus)*2);
						// 인벤 추가
						invent += Math.abs(minus);
					}
					// 좌표가 더 작은 경우 2번 실행
					else if(minus < 0) {
						// 시간 추가
						second += Math.abs(minus);
						// 인벤 빼기
						invent -= Math.abs(minus);
					}
				}
			}
			// 조건 부합
			if(invent >= 0) {
				// 가장 짧은 시간인 경우
				if(second <= time) {
					// 시간, 층 갱신
					time = second;
					height = i;
				}
			}
		}
	}

} // class end
