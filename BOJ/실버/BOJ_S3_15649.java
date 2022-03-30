package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-30, 20분
 * @title n과m
 */

public class BOJ_S3_15649 {
	static StringTokenizer st;
	static int N, M;
	static boolean[] v;
	static StringBuilder sb;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		v= new boolean[N+1];
		
		comb(0);
		
		System.out.println(sb);
		
	}
	
	// 순열 nPm
	static void comb(int ind) {
		// 기저조건
		if(ind == M) {
			for(int i=0; i<M;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<N+1;i++) {
		if(v[i]) {
			continue;
		}
		else {
			v[i] = true;
			arr[ind] = i;
			comb(ind+1);
			v[i] = false;
		}
		}
	}
}
