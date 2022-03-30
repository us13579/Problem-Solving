package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-30, 10분
 * @title N과M(3)
 */

public class BOJ_S3_15651 {
	static StringTokenizer st;
	static int N,M;
	static StringBuilder sb;
	static boolean[] v;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		v = new boolean[N];
		
		
		go(0);
		System.out.println(sb);

	}
	
	// 부분집합 합 구하기
	
	static void go(int idx) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]+1).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
				v[i] = true;
				arr[idx] = i;
				
				go(idx+1);
				v[i] = false;
			
		}
		
		
	}
}
