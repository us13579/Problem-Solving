package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-04-06, 25분
 * @title 최장 증가 부분 수열
 * 
 */

public class SWEA_D3_3307 {
	static StringTokenizer st;
	static int[] arr;
	static int[] dp;
	static int min, N;
	static int idx;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			// 수열의 길이
			N = Integer.parseInt(br.readLine());
			
			// 숫자 배열
			arr = new int[N];
			// dp 값 저장 배열
			dp = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 초기값 설정
			dp[0] = arr[0];
			
			idx = 0;
			
			
			LIS();
			
			sb.append(idx+1).append("\n");
		}
		System.out.println(sb);
		
	}
	
	// LIS
	static void LIS() {
		
		for(int i=1; i<N; i++) {
			
			// arr 값이 더 큰 경우 
			if(arr[i] > dp[idx]) {
				idx++;
				dp[idx] = arr[i];
			}
			
			
			// dp 값이 더 큰 경우
			else {
				int low = bs(idx, arr[i]); 
				dp[low] = arr[i];
			}
			
		}
		
	}
	
	// 이진 탐색
	static int bs(int end, int n) {
		int start = 0;
		
		while(start < end) {
			int mid = ( start + end ) / 2;
			
			if(dp[mid] >= n) {
				end = mid;
			}
			else {
				start = mid+1;
			}
			
		}
		return end;
	}
}
