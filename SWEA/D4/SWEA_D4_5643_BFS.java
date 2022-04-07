package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_5643_BFS {
	static int N;
	static int[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 학생수
			N = Integer.parseInt(br.readLine());

			// 비교 횟수
			int M = Integer.parseInt(br.readLine());

			// 학생번호 1부터 시작하도록..
			// 인접행렬 : 0이면 키관계 모름 1이면 자신보다 키가 큰 학생과의 관계를 표현
			adjMatrix = new int[N + 1][N + 1];

			// 다돌고나면 배열이 완성
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a보다 b가 크다
				adjMatrix[a][b] = 1;
			}

			// 자신의 키를 알 수 있는 학생 수
			int answer = 0;
			
			for(int i=1; i<=N; i++) {
				// 만약 N-1 학생들의 키를 알 수 있으면 자신의 키를 알 수 있는 학생이다. 그래서 ++
				if(gtBfs(i, new boolean[N+1]) + ltBfs(i, new boolean[N+1]) == N-1) {
					answer++;
				}
			}
			
			

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	// 자신보다 큰 학생 탐색
	static int gtBfs(int start, boolean[] visited) {
		// 카운트 ( 자신보다 큰 애가 몇명 있나 )
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {

			int cur = queue.poll();

			// 모든학생 들여다 보며 자신보다 키가 큰 학생 따라 탐색
			for (int i = 1; i <= N; i++) {
				if (adjMatrix[cur][i] != 0 && !visited[i]) {
					cnt++;
					// 방문처리
					visited[i] = true;
					// 다시 넣어준다
					queue.offer(i);
				}
			}
		}

		return cnt;
	}

	// 자신보다 작은 학생 탐색
	static int ltBfs(int start, boolean[] visited) {
		// 카운트 ( 자신보다 작은 애가 몇명 있나 )
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {

			int cur = queue.poll();

			// 모든학생 들여다 보며 자신보다 키가 작은 학생 따라 탐색
			for (int i = 1; i <= N; i++) {
				if (adjMatrix[i][cur] != 0 && !visited[i]) {
					cnt++;
					// 방문처리
					visited[i] = true;
					// 다시 넣어준다
					queue.offer(i);
				}
			}
		}

		return cnt;
	}
}
