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
 * @since 2022-04-13, 30분
 * @title 알고스팟
 */

public class BOJ_G4_1261 {
	static int N, M, min, cnt;
	static int[][] map;
	static int[][] v;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 가로크기
		M = Integer.parseInt(st.nextToken());

		// 세로 크기
		N = Integer.parseInt(st.nextToken());

		// 1,1 부터 시작한다
		map = new int[N + 1][M + 1];

		// 누적 비용
		v = new int[N + 1][M + 1];

		// 입력
		for (int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			String[] sstr = str.split("");
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(sstr[j-1]);
				v[i][j] = Integer.MAX_VALUE;
			}
		}

		v[1][1] = 0;
		bfs(1, 1);

		System.out.println(v[N][M]);
	}

	// bfs
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				// 범위 벗어나는 경우
				if(nx < 1 || ny < 1 || nx > M || ny >N ) continue;
				
				// 벽인 경우 && 누적되는 비용이 더 많이 드는 경우 갱신
				if(map[ny][nx] == 1 && v[ny][nx] > v[cur[1]][cur[0]]+1) {
					v[ny][nx] = v[cur[1]][cur[0]]+1;
					q.offer(new int[] {nx,ny});
				}
				// 벽이 아닌 경우 && 누적되는 비용이 더 많이 드는 경우 갱신 -> 1을 더할 필요가 없다
				else if(map[ny][nx] == 0 && v[ny][nx] > v[cur[1]][cur[0]]) {
					v[ny][nx] = v[cur[1]][cur[0]];
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
}
