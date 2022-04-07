package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO_2577 {
	static StringTokenizer st;
	static int N, d, k, c;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");
		// 접시 수
		N = Integer.parseInt(st.nextToken());
		// 초밥의 가짓수
		d = Integer.parseInt(st.nextToken());
		// 연속해서 먹는 접시의 수
		k = Integer.parseInt(st.nextToken());
		// 쿠폰 번호
		c = Integer.parseInt(st.nextToken());

		// N+k 인 이유는 원형이기 때문
		int[] arr = new int[N+k];
		// 먹은 초밥 배열
		int[] check = new int[d+1];

		// 초밥 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 뒤에 더 추가 ( 원형이기 때문에 )
		for(int i=N; i<N+k; i++) {
			arr[i] = arr[i-N];
		}
		
		int ans = -1;
		// 쿠폰에 해당되는 초밥 접시의 개수
		int cnt = 0;
		int coupon = 0;
				
		// 슬라이딩 윈도우 사용
		for(int i=0; i<N+k; i++) {
			// 접시 k개를 선택한 상태에서 다음 선택으로 넘어갔을때
			if(i>=k) {
				// 맨 뒤 접시빼기
				if(--check[arr[i-k]] == 0) cnt--;
				if(arr[i-k] == c) coupon--;
			}
			
			// 현재 접시 추가
			if(++check[arr[i]] == 1) cnt++;
			if(arr[i] == c) coupon++;
			if(i>=k)
				ans = Math.max(ans, coupon == 0 ? cnt+1 : cnt);
		}
		System.out.println(ans);
	}
}
