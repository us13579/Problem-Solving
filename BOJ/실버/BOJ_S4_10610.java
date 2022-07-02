package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220702
 * @title 30
 */

public class BOJ_S4_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// **** input start ****
		String num = br.readLine();

		// **** input end ****
		
		// 숫자 저장 배열
		int[] numArr = new int[10];
		
		// 총 합 ( 3의 배수 체크 )
		int total = 0;
		
		// 숫자 개수 체크, total 합 구해주기
		for(int i=0; i<num.length(); i++) {
			int temp = num.charAt(i)-'0';
			numArr[temp]++;
			total += temp;
		}
		
		// 만약 3의 배수 가 아니고 30의 배수가 아닌경우 통과
		if(total % 3 !=0 || numArr[0] == 0) {
			sb.append("-1");
		}
		// 조건이 만족하면
		else {
			// 반대로 탐색하면서 숫자가 있으면 값을 출력해준다.
			for(int i=numArr.length-1;i>=0;i--) {
				while(numArr[i]>0) {
				sb.append(i);
				numArr[i]--;
				}
			}
		}
		System.out.println(sb);
	} // main end
} // class end
