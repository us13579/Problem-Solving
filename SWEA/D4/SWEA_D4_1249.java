package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SWEA_D4_1249 {
	static int N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int minCost;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 지도의 크기
			N = Integer.parseInt(br.readLine());

			// 값 저장 배열
			map = new int[N][N];

			// 입력
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				String[] sstr = str.split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(sstr[j]);
				}
			}

			sb.append(dijkstra(0,0)).append("\n");
		}
		System.out.println(sb);
	}

	static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		// 출발지에서 자신까지의 최소복구시간
		int[][] minTime = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}

		// int[] = 정점정보, 출발지에서 자신까지의 비용 r,c,cost
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			// cost 비교
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		minTime[startR][startC] = 0;
		pQueue.offer(new int[] { startR, startC, minTime[startR][startC] });

		int r, c, minCost, nr, nc, current[];
		while (true) {

			// pQueue 안의 정점 중 출발지에서 자신으로의 비용이 최소인 정점의 정보
			current = pQueue.poll();
			r = current[0];
			c = current[1];
			minCost = current[2];

			if (visited[r][c])
				continue;

			visited[r][c] = true;
			// 도착지라면 끝내기
			if (r == N - 1 && c == N - 1)
				return minCost;

			// 현 정점의 인접정점 들여다보며 최소비용 갱신
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
					pQueue.offer(new int[] { nr, nc, minTime[nr][nc] });
				}
			}
		}
	}
}
