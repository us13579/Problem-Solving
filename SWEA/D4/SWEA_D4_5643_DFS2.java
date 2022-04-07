package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_5643_DFS2 {
	static int N;
	static int[][] adjMatrix, radjMatrix;

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
			radjMatrix = new int[N + 1][N + 1];

			// 다돌고나면 배열이 완성
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a보다 b가 크다
				radjMatrix[b][a] = adjMatrix[a][b] = 1;
			}

			// 자신의 키를 알 수 있는 학생 수
			int answer = 0;
			
			for(int i=1; i<=N; i++) {
				cnt = 0;
				DFS(i, new boolean[N+1], adjMatrix);	// 나보다 큰애 탐색
				DFS(i, new boolean[N+1], radjMatrix);	// 나보다 작은애 탐색
				// 만약 N-1 학생들의 키를 알 수 있으면 자신의 키를 알 수 있는 학생이다. 그래서 ++
				if(cnt == N-1) {
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static int cnt = 0;

	// 하나의 dfs 문을 이용해서 배열 2개를 처리 ( 하나는 큰 애들, 하나는 작은 애들 )
	static void DFS(int cur, boolean[] visited, int[][] adjM) {

		visited[cur] = true;

		// 모든학생 들여다 보며 자신보다 키가 큰 학생 따라 탐색
		for (int i = 1; i <= N; i++) {
			if (adjMatrix[cur][i] != 0 && !visited[i]) {
				cnt++;
				DFS(i, visited, adjM);
			}
		}
	}
}
