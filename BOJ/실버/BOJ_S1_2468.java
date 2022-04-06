package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-04-06, 35분
 * @title 안전영역
 */

public class BOJ_S1_2468 {
	static StringTokenizer st;
	static int N, res;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 행열의 개수
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		// 가장 높은 높이
		int max = 0;
		
		// 안전한 영역의 최대 개수
		int res_max = 0;

		// 높이 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
			}
		}
		
		// 전체 배열 돌면서 확인
		for (int i = 0; i < max; i++) {
			// 잠기는 깊이가 다를 때 마다 영역 초기화
			res = 0;

			// 깊이가 낮은 것은 true 처리
			boolean[][] v = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < N; z++) {
					if (arr[j][z] <= i) {
						v[j][z] = true;
					}
				}
			}

			for (int j = 0; j < N; j++) {
				for (int z = 0; z < N; z++) {
					// 방문하지 않았거나 잠기지 않았으면 dfs 실행
					if (!v[j][z]) {
						dfs(j, z, v);
						res++;
					}
					else {
						continue;
					}
				}
			}
			res_max = Math.max(res, res_max);
		}
		System.out.println(res_max);
	}
	
	// boolean 배열에 true 입력해주는 역할 
	static void dfs(int y, int x, boolean[][] v) {
		
		// 기저조건 : 잠기지 않은 지역 다 
		if (v[y][x]) {
			return;
		}

		// 잠기지도 않고 방문하지도 않았으면
		if(!v[y][x]) {
			v[y][x] = true;
		
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			// 범위를 벗어
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			
			dfs(ny, nx, v);
			}
		}
	}
}
