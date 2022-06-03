package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @title 동철이의 일 분배
 * @since 220602
 */

public class SWEA_D4_1865 {
	static int N;
	static double max;
	static double[][] arr;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			// N
			N = Integer.parseInt(br.readLine());

			// 담당 배열
			arr = new double[N][N];

			// 방문 체크
			v = new boolean[N];

			// 확률 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Double.parseDouble(st.nextToken());
					arr[i][j] /= 100;
				}
			}
			
			max = 0;
		
			run(0,1.0);
			String str = String.format("%.6f", max*100);
			sb.append(str).append("\n");
		
			
		}	
		System.out.println(sb);
	}

	static void run(int lev, double sum) {
		// 가지치기 ( 시간복잡도를 줄이는데 제일 중요 ) 
		if(sum <= max) return;
		// 기저조건
		if (lev == N) {
			max = Math.max(max, sum);
			return;
		}

		for(int i=0; i<N; i++) {
			// 이미 방문했으면 통과
			if(v[i]) continue;
			
			// 방문 처리
			v[i] = true;
			
			// 재귀
			run(lev+1, sum * arr[lev][i]);
			
			// 백트래킹
			v[i] = false;
		}
	}
}
