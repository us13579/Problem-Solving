package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220702
 * @title 그룹 단어 체커
 */

public class BOJ_S5_1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// **** input start ****
		int N = Integer.parseInt(br.readLine());
		
		// 전체 카운팅
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			// 알파벳 배열
			boolean[] arr = new boolean[26];
			
			// 성공, 실패 체크
			boolean flag = true;
			
			// 처음 값 true
			arr[str.charAt(0)-'0'-49] = true;
			// 알파벳을 숫자로 바꾸어 ( a -> 0 , b -> 1 .. ) 배열에 저장
			// 만약 이미 존재하면 실패
			for(int j=1;j<str.length();j++) {
				int temp = str.charAt(j) -'0'- 49;
				
				// 만약 존재하고 전에 값이 아니면 실패
				if(arr[temp] && str.charAt(j) != str.charAt(j-1)) {
					flag = false;
					break;
				}
				arr[temp] = true;
			}
			
			if(flag) cnt++;
			
		}
		
		
		
		// **** input end ****
		
		System.out.println(cnt);
		
		
	} // main end
} // class end
