package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-30, 10분
 * @title N과M(2)
 */


public class BOJ_S3_15650 {
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean[] v;
	static int[] arr;
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		v = new boolean[N+1];
		
		per(0,1);
		
		System.out.println(sb);
		
		
	}
	
	// 조합 nPm
	static void per(int idx, int start) {
		if(idx == M) {
			for(int i=0;i<M;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N+1;i++) {
			if(v[i]) {
				continue;
			}
			else {
				v[i]=true;
				arr[idx] = i;
				per(idx+1, i+1);
				v[i] =false;
			}
		}
		
		
	}
	
}
