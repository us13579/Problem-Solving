package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_SW_1953 {

	// 좌표
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] v;
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			// 세로 크기
			N = Integer.parseInt(st.nextToken());

			// 가로 크기
			M = Integer.parseInt(st.nextToken());

			// 맨홀 뚜껑 세로 위치
			R = Integer.parseInt(st.nextToken());

			// 맨홀 뚜껑 가로 위치
			C = Integer.parseInt(st.nextToken());

			// 탈출 후 소요된 시간
			L = Integer.parseInt(st.nextToken());

			// 시간
			time = L;

			// 터널지도정보 배열
			map = new int[N][M];

			// 방문 여부
			v = new boolean[N][M];

			// 탈주범이 갈 수 있는 총 맨홀뚜껑 수 , 1인 이유는 처음 값은 이미 포함
			cnt = 1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(new Node(R, C));
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static int nr, nc, type, cnt;

	// bfs
	static void bfs(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		// 좌표 삽입
		q.offer(node);

		// 방문 처리 ( 제일처음 맨홀자리 )
		v[node.r][node.c] = true;


		while (!q.isEmpty()) {

			time--;
			// 시간 초과
			if (time < 1)
				break;
			int size = q.size();

			// q가 여러개 넘어왔을 수도
			for (int j = 0; j < size; j++) {
				Node n_node = q.poll();
				// 현재 행
				int r = n_node.r;
				// 현재 열
				int c = n_node.c;

				// 배열 값이 방향이다.
				type = map[r][c];

				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];

					// 범위를 벗어났거나 이미 간곳 이거나 파이프가 없는 곳
					if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1 || v[nr][nc] || map[nr][nc] == 0)
						continue;
					// 그 다음 방향
					int next_type = map[nr][nc];


					// 현재 방향이랑 그다음 방향이랑 같아야 한다
					switch (i) {
					// 상
					case 0:
						if (type == 1 || type == 2 || type == 4 || type == 7) {
							if (next_type == 1 || next_type == 2 || next_type == 5 || next_type == 6) {
								// 방문체크
								v[nr][nc] = true;
								// 큐에 다시 삽입
								q.offer(new Node(nr,nc));
								// 카운팅
								cnt++;
							}
						}
						break;

					// 하
					case 1:
						if (type == 1 || type == 2 || type == 5 || type == 6) {
							if (next_type == 1 || next_type == 2 || next_type == 4 || next_type == 7) {
								// 방문체크
								v[nr][nc] = true;
								// 큐에 다시 삽입
								q.offer(new Node(nr,nc));
								// 카운팅
								cnt++;
							}
						}
						break;

					// 좌
					case 2:
						if (type == 1 || type == 3 || type == 6 || type == 7) {
							if (next_type == 1 || next_type == 3 || next_type == 4 || next_type == 5) {
								// 방문체크
								v[nr][nc] = true;
								// 큐에 다시 삽입
								q.offer(new Node(nr,nc));
								// 카운팅
								cnt++;
							}
						}
						break;

					// 우
					case 3:
						if (type == 1 || type == 3 || type == 4 || type == 5) {
							if (next_type == 1 || next_type == 3 || next_type == 6 || next_type == 7) {
								// 방문체크
								v[nr][nc] = true;
								// 큐에 다시 삽입
								q.offer(new Node(nr,nc));
								// 카운팅
								cnt++;
							}
						}
						break;
					}
				}
			}
		}
	}
}
