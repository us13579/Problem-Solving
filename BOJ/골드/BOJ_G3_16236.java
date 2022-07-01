package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220701
 * @title 아기상어
 */

public class BOJ_G3_16236 {
	static int[][] map;
	static int N;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// **** input start ****
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		// 아기상어
		Node shark = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 상어 위치 지정
				if (map[i][j] == 9) {
					// 상어 위치 저장하고 0으로 초기화 - 지나갈 수 있게
					shark = new Node(j, i);
					map[i][j] = 0;
				}
			}
		}

		// **** input end ****
		int res = bfs(shark);

		System.out.println(res);
	} // main end

	static int bfs(Node shark) {
		int ans = 0;
		// 상어크기
		int sharkSize = 2;
		// 상어크기조절 변수
		int cnt = 0;

		while (true) {
			// 다음 먹을 물고기 위치
			int x = Integer.MAX_VALUE;
			int y = Integer.MAX_VALUE;
			int d = Integer.MAX_VALUE;

			Queue<Node> queue = new LinkedList<Node>();
			// 이동거리 저장 배열
			int[][] distance = new int[N][N];

			// 현재 아기상어 위치부터 저장
			queue.add(shark);

			// bfs 탐색
			while (!queue.isEmpty()) {
				Node current = queue.poll();

				// 4방향 탐색
				int nx, ny;
				for (int i = 0; i < 4; i++) {
					nx = current.x + dx[i];
					ny = current.y + dy[i];

					// 범위를 넘거나 자신보다 큰 물고기거나 이미 방문한 위치는 x
					if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || map[ny][nx] > sharkSize
							|| distance[ny][nx] != 0)
						continue;
					
					// 이동 횟수 저장
					distance[ny][nx] = distance[current.y][current.x] + 1;
					
					// 우선 순위 지정
					if(map[ny][nx] != 0 && map[ny][nx] < sharkSize) {
						// 가장 가까운 물고기를 먹는다
						if(d > distance[ny][nx]) {
							d = distance[ny][nx];
							x = nx;
							y = ny;
						}
						// 거리가 같은 경우
						else if(d == distance[ny][nx]) {
							// 가장 왼쪽에 있는 물고기
							if(y == ny) {
								if(x > nx) {
									x = nx;
									y = ny;
								}
							}
							// 가장 위에 있는 물고기
							else if(y > ny) {
								x = nx;
								y = ny;
							}
						}
					}
					queue.add(new Node(nx, ny));
				}
			}

			// 먹을 물고기가 없는 경우
			if(x==Integer.MAX_VALUE && y == Integer.MAX_VALUE) {
				break;
			}
			
			// 시간 추가, 좌표 0으로
			ans += distance[y][x];
			map[y][x] = 0;
			
			// 좌표 갱신 - 이동한 곳으로
			shark.x = x;
			shark.y = y;
			
			// 먹은 것 추가
			cnt++;
			
			// 상어 크기 증가
			if(cnt == sharkSize) {
				sharkSize++;
				cnt = 0;
			}
		}

		return ans;
	}

} // class end
