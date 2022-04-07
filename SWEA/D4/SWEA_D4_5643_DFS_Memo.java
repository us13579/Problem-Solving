package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_5643_DFS_Memo {
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

			// 탐색전인 것으로 초기화 ( 나보다 크거나 작은애들이 없는 경우 0이 나올 수 있기 때문에 구분하기 위해 -1로 초기화 해준다.)
			for (int i = 1; i <= N; i++) {
				adjMatrix[i][0] = -1;
			}

			// 다돌고나면 배열이 완성
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a보다 b가 크다
				adjMatrix[a][b] = 1;
			}

			
			for (int i = 1; i <= N; i++) {
				// 탐색전인 학생들만 탐색
				if (adjMatrix[i][0] == -1) {
					gtDfs(i);
				}
			}
			
			// 나보다 작은 학생수 카운팅
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adjMatrix[0][j] += adjMatrix[i][j];
				}
			}
			
			// 자신의 키를 알 수 있는 학생 수
			int answer = 0;
			
			// 총 합 구하기
			for (int i = 1; i <= N; i++) {
				if(adjMatrix[i][0] + adjMatrix[0][i] == N-1) {
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	// 자신보다 큰 학생 탐색
	static void gtDfs(int cur) {
		
		for (int i = 1; i <= N; i++) {
			// 나보다 큰 학생이면
			if (adjMatrix[cur][i] != 0) {

				// 탐색한 적 없다
				if (adjMatrix[i][0] == -1) {
					gtDfs(i);
				}

				// 나보다 큰 학생이 알고있는 다른 학생과의 키 관계를 나와의 직접 관계로 매핑
				// i 보다 큰 학생이 있다면 ( 0 인경우는 큰학생이 없는 경우다 )
				if (adjMatrix[i][0] > 0) {
					for (int j = i; j <= N; j++) {
						// cur < i < j==> cur < j
						if(adjMatrix[i][j] == 1) {
							adjMatrix[cur][j] =1;
						}
					}
				}

			}
		}
		
		// 기록 - 다 더해둔다
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += adjMatrix[cur][i];
		}
		adjMatrix[cur][0] = cnt;

	}
}
