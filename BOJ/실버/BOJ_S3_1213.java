package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220704
 * @title 팰린드롬 만들기
 */

public class BOJ_S3_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// **** input start ****

		String str = br.readLine();

		// **** input end ****

		// 알파벳 개수 저장 배열
		int[] arr = new int[26];

		// 총 알파벳 개수
		int sum = str.length();

		// 개수 저장
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - '0' - 17]++;
		}

		int cnt = 0;
		// 만약 각각의 알파벳의 개수가 홀수개인 것이 2개 이상인 경우 탈락
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1)
				cnt++;
		}
		
		// 실패
		if (cnt >= 2)
			System.out.println("I'm Sorry Hansoo");
		else {
			String res = "";
			// 짝수개인경우
			if (sum % 2 == 0) {
				for (int i = 0; i < arr.length; i++) {
					// 알파벳이 있으면
					if (arr[i] > 0) {
						// 알파벳 개수의 반틈만큼 res에 넣어주고 넣은 것은 빼준다
						int temp = arr[i] / 2;
						for (int j = 0; j < temp; j++) {
							res += (char)(i+'A');
							arr[i]--;
						}
					}
				}
				for (int i = arr.length-1; i >= 0; i--) {
					// 알파벳이 있으면
					if (arr[i] > 0) {
						// 다 넣는다
						int temp = arr[i];
						for (int j = 0; j < temp; j++) {
							res += (char)(i+'A');
							arr[i]--;
						}
					}
				}
			}else {		// 홀수 개 인 경우
				char c = 0;
				// 중간에 홀수개인 것을 넣는다.
				for(int i=0; i<arr.length;i++) {
					if(arr[i] % 2 == 1) {
						c=(char)(i+'A');
						arr[i]--;
					}
				}
				for (int i = 0; i < arr.length; i++) {
					// 알파벳이 있으면
					if (arr[i] > 0) {
						// 알파벳 개수의 반틈만큼 str에 넣어주고 넣은 것은 빼준다
						int temp = arr[i] / 2;
						for (int j = 0; j < temp; j++) {
							res += (char)(i+'A');
							arr[i]--;
						}
					}
				}
				res += c;
				for (int i = arr.length-1; i >= 0; i--) {
					// 알파벳이 있으면
					if (arr[i] > 0) {
						// 다 넣는다
						int temp = arr[i];
						for (int j = 0; j < temp; j++) {
							res += (char)(i+'A');
							arr[i]--;
						}
					}
				}
			}
			System.out.println(res);
		}
		
	} // main end
} // class end
