package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_5643_DFS_Floyd {
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
			} // 입력처리
			
			// 모든 쌍의 관계를 파악
			// 경출도
			for (int i = 1; i <= N; i++) {	// 경유 학생 : 고정
				for (int j = 1; j <= N; j++) {	// 출발 학생 ( 자신과 다른 학생과의 관계를 알고 싶은 학생 )
					// 나 자신으로 도는 것은 의미가 없다
					if( i == j ) continue;
					
					for (int z = 1; z <= N; z++) {	// 도착 학생 ( 다른 학생 )
						if(adjMatrix[i][j] == 1 && adjMatrix[i][z]==1 ) {
							adjMatrix[j][z] = 1;
						}
					}
					
				}
			}
			
			// 알 수 있는 모든 쌍의 관계가 반영되어 있다.
			
			// 자신보다 작은 학생수 카운트
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N;j++) {
					adjMatrix[i][0] += adjMatrix[i][j];
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
}
