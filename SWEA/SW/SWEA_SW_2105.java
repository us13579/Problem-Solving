package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @title 디저트 카페
 * @since 220530 7:40-9:20
 */

public class SWEA_SW_2105 {
	static int N;
	static int[][] map;
	static int dx[] = { 1, -1, -1, 1 };
	static int dy[] = { 1, 1, -1, -1 };
	static boolean[][] v;
	static boolean[] dessert;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int T = 1; T <= tc; T++) {
			sb.append("#").append(T).append(" ");

			// 한 변의 길이
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;

			// 디저트 종류 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 양옆과 밑에 2칸이 있어야 사각형이 가능 서치
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					v = new boolean[N][N];
					// 디저트 종류
					dessert = new boolean[101];
					// 방문 처리
					v[i][j] = true;
					// 디저트 방문처리
					dessert[map[i][j]] = true;
					dfs(1, i, j, i, j, 0);
				}
			}
			if (max == 0) {
				sb.append("-1").append("\n");
			} else {
				sb.append(max).append("\n");
			}
		}
		System.out.println(sb);
	}

	// dfs - prevD는 이전방향
	static void dfs(int cnt, int y, int x, int initY, int initX, int prevD) {
		for (int i = prevD; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if ((ny == initY) && (nx == initX) && cnt > 2) {
					max = Math.max(max, cnt);
					return;
					// 종료
				}
				if(!v[ny][nx] && !dessert[map[ny][nx]]) {
					v[ny][nx] = true;
					dessert[map[ny][nx]] = true;
					dfs(cnt + 1, ny,nx,initY,initX,i);
					// 백트래킹
					v[ny][nx] = false;
					dessert[map[ny][nx]] = false;
				}
			}

		}
	}

}
