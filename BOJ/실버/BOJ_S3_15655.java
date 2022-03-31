package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-31, 5분
 * @title N과M(6)
 */

public class BOJ_S3_15655 {
	static StringTokenizer st;
	static StringBuilder sb;
	static int N,M;
	static int[] arr;
	static int[] res;
	static boolean[] v;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		// 조합 구할때 사용할 배열
		res = new int[M];
		v = new boolean[N+1];
		
		// 배열 값 넣기
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬하기 
		Arrays.sort(arr);
		
		comb(0,0);
		System.out.println(sb);
	}
	
	// 순서가 상관없기 때문에 조합
	static void comb(int idx, int start) {
		// 기저조건
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(v[i]) {
				continue;
			}
			else {
				v[i] = true;
				res[idx] = arr[i];
				comb(idx+1, i+1);
				v[i] = false;
			}
		}
	}
}

