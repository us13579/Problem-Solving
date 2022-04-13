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
 * @since 2022-04-13,15분
 * @title 바이러스
 */


public class BOJ_S3_2606 {
	static int N;
	static int M;
	static int res;
	static int[][] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 컴퓨터 수
		N = Integer.parseInt(br.readLine());
		
		// 연결되어 있는 컴퓨터 쌍의 수
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		
		// 컴퓨터 감염 여부 
		v = new boolean[N+1];
				
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			
			// 연결 상태를 1로 나타냄
			arr[com1][com2] = arr[com2][com1] = 1;
		}
		
		bfs(1);
		System.out.println(res);
	}
	
	// bfs
	static int bfs(int num) {
		res = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(num);
		// 감염 표시
		v[num] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			// 감염된 컴퓨터와 연결되어 있으면 감염 표시
			for(int i=0; i<N+1; i++) {
				// 감염된 컴퓨터랑 연결되어 있고 아직 감염 안된 경우
				if(arr[cur][i] == 1 && !v[i]) {
					v[i] = true;
					q.offer(i);
				}
			}
		}
		
		// 총 감염된 컴퓨터 수 구하기
		for(int i=1; i<N+1; i++) {
			if(v[i]) {
				res++;
			}
		}
		
		// 본인 빼주기
		res--;
		
		return res;
	}
}
