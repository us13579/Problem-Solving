package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-30, 10분
 * @title N과M(5)
 */

public class BOJ_S3_15654 {
	static StringTokenizer st;
	static StringBuilder sb;
	static int N,M;
	static int[] arr;
	static boolean[] v;
	static int[] res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		res=  new int[M];
		v = new boolean[N];
		
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		comb(0);
		System.out.println(sb);
		
		
		
		
	}
	
	static void comb(int idx) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) {
				continue;
			}
			else {
				v[i] =true;
				res[idx] = arr[i];
				comb(idx+1);
				v[i] = false;
			}
		}
		
	}
	
}
