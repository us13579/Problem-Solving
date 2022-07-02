package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220702
 * @title 소트인사이드
 */

public class BOJ_S5_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// **** input start ****
		String num = br.readLine();

		// **** input end ****
		
		// 배열로 만들기 ( 숫자의 개수 저장 )
		int[] arr = new int[10];
		
		for(int i=0; i<num.length(); i++) {
			int temp = (int)num.charAt(i) - 48;
			arr[temp]++;
		}
		
		for(int i=arr.length-1; i>=0;i--) {
			while(arr[i]>0) {
				sb.append(i);
				arr[i]--;
			}
		}
		
		System.out.println(sb);

	} // main end
} // class end
