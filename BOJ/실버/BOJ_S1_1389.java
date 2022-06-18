package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220618
 * @title 케빈베이컨의 6단계 법칙
 */

public class BOJ_S1_1389 {
	static int[][] map;
	static boolean[][] v;
	static int N,M;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// input start
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 관계도
		map = new int[N+1][N+1];
		// 방문 처리
		v = new boolean[N+1][N+1];
		
		// 결과값 저장 배열
		int[] res = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 양방향
			map[start][end] = 1;
			map[end][start] = 1;
			
		}
		
		// input end
		
		// 배열 돌면서 check
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				// 출발과 도착이 같으면 통과
				if(i == j) continue;
				// 만약 한번에 연결되어있으면
				if(map[i][j] == 1) {
					// 케빈베이컨 수 1 추가
					res[i] += 1;
				}
				// 한번에 연결안되어있으면 경로 찾기
				else {
					// 방문배열 초기화
					init();
					// 최소값 초기화
					min = Integer.MAX_VALUE;
					dfs(i,j,0);
					res[i] += min;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		// 결과번호
		int num = 0;
		// 케빈 베이컨 수가 가장 작은 사람 구하기
		for(int i=res.length-1; i>0; i--) {
			min = Math.min(min,res[i]);
			if(min == res[i]) {
				num = i;
			}
		}
		
		System.out.println(num);
	}
	
	static void dfs(int start, int end, int sum) {
		// 도착
		if(map[start][end] == 1) {
			sum++;
			min = Math.min(sum, min);
			return;
		}
		
		for(int i=1;i<N+1;i++) {
			// 출발지와 목적지가 같으면 통과 ( 가지치기 ) 
			if(start == i) continue;
			// 연결되어 있으면, 방문하지 않았으면
			if(map[start][i] == 1 && !v[start][i]) {
				// 방문처리
				v[start][i] = true;
				v[i][start] = true;
				// 경로 하나 더해주기
				sum++;
				dfs(i,end,sum);
				// 백트래킹
				sum--;
				v[start][i] = false;
				v[i][start] = false;
			}
		}
	}
	
	// 방문배열 초기화
	static void init() {
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				v[i][j] = false;
			}
		}
	}
}
