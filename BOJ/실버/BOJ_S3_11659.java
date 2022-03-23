package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-23, 20분
 * @title 구간 합 구하기 4
 *
 */

public class BOJ_S3_11659 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 횟수
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr =new int[N+1];
		int[] sum = new int[N+1];
		sum[0] = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i] + sum[i-1];
		}
		
		
		for(int i=0; i<M; i++) {
		st = new StringTokenizer(br.readLine(), " ");
		
		// 시작과 끝
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int res = 0;
		start -= 1;
		res = sum[end] - sum[start];
		
		sb.append(res).append("\n");
		
		}
		
		// 출력
		System.out.println(sb);
	}

}
