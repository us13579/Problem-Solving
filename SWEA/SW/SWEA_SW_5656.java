package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_SW_5656 {
	static StringTokenizer st;
	static int N, W, H, min;
	// 오른쪽, 왼쪽, 아래, 위
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");

			// 구슬 놓는 횟수
			N = Integer.parseInt(st.nextToken());

			// 가로
			W = Integer.parseInt(st.nextToken());

			// 세로
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			go(0, map);
			sb.append(min).append("\n");

		}
		System.out.println(sb);
	}

	// 중복순열 이용하여 구슬 던지기
	// 벽돌이 다 부서졌으면 true, 아니면 false
	static boolean go(int count, int[][] map) {
		// 중복순열 구조

		int result = getRemain(map);

		// 모든 벽돌이 다 부서졌다면
		if (result == 0) {
			min = 0;
			return true;
		}

		// 모든 구슬을 던졌다면
		if (count == N) {
			min = Math.min(min, result);
			return false;
		}

		int[][] newMap = new int[H][W];

		// 0열부터 W-1열까지 구슬 던져보기
		for (int c = 0; c < W; c++) {

			// 구슬에 맞는 벽돌 찾기
			int r = 0;
			// 빈공간이면 계속 아래로
			while (r < H && map[r][c] == 0)
				++r;

			// 행이 범위를 벗어나 끝났다면 해당 열은 벽돌이 없음
			if (r == H)
				continue;

			// 배열의 상태를 백업
			copy(map, newMap);

			// 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 처리
			boom(newMap, r, c);

			// 부서진 벽돌 정리
			down(newMap);

			// 다음 배열로 출발
			// 이미 끝났다면 뒤에 돌 필요가 없다.
			if (go(count + 1, newMap)) {
				return true;
			}
		}
		// 위에 구문에서 true 가 안나오면 다 부서지지 않았다는 뜻
		return false;

	}

	// y,x 위치에서 주변의 가능한 모든 벽돌도 함께부수는 처리
	// BFS + 중복순열
	static void boom(int[][] map, int r, int c) {
		// BFS
		Queue<Point> q = new LinkedList<Point>();
		// 벽돌 크기가 2이상이면 queue에 삽입
		if (map[r][c] > 1) {
			q.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 자신은 제거 처리 -> visit 처리랑 같은 역할을 한다

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r, nc = p.c;

				// 벽돌의 크기 - 1만큼 반복, 계속 옆으로 가는거다
				for (int j = 1; j < p.cnt; j++) {
					nr += dr[i];
					nc += dc[i];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (map[nr][nc] > 1) {	// 주변에 영향을 주는 벽돌이면
							q.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;	// 빈공간이면 0, 벽돌이면 제거처리
					}
				}

			}
		}

	}

	// 부서진 벽돌 정리, 밑으로 보내기 !! ( 공중에 떠있는 것들 )
	static ArrayList<Integer> list = new ArrayList<Integer>();

	static void down(int[][] map) {
		// 열 고정
		for (int c = 0; c < W; c++) {
			// 맨밑칸부터 시작
			int r = H - 1;
			while (r > 0) {
				if(map[r][c] == 0) {
					int nr = r-1;
					while(nr>0 && map[nr][c] == 0) nr--;
					
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				r--;
			}
		}
	}

	// 남은 벽돌 수 구하기
	static int getRemain(int[][] map) {
		int count = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] > 0) {
					count++;
				}
			}
		}
		return count;
	}

	// 배열 복사
	static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
}
