package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220624
 * @title IOIOI
 */

public class BOJ_S1_5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// **** input start ****
		int N = Integer.parseInt(br.readLine());

		int S = Integer.parseInt(br.readLine());

		String str = br.readLine();

		// **** input end ****
		char[] ch = str.toCharArray();
		int[] dp = new int[S];
		
		// 총 횟수
		int cnt = 0;

		// dp 배열 구하기
		for(int i=1; i<S-1; i++) {
			// "OI"값이 있으면 전 dp 값에서 +1
			if(ch[i] == 'O' && ch[i+1] == 'I') {
				dp[i+1] = dp[i-1] + 1;
			}
			// "OI"가 N번 이상 반복 하고 처음 시작하는 값이 "I"면 카운팅
			if(dp[i+1] >= N && ch[i-(N*2)+1] == 'I') {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
