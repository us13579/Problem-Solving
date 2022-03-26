package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-26, 113 0
 * @title 곱셈
 *
 */
public class BOJ_S1_1629 {
	static long C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A,B));
		
		}
	
	static long pow(long a, long b) {
		if(b==1) {
			return a % C;
		}
		
		// 지수를 1/2 한 값을 구해주기 -> 지수 법칙 a^b = a^b/2 * a^b/2
		long temp = pow(a, b/2);
		
		// 지수가 홀수 일 경우
		// 모듈러 법칙 (a * b) % c = ((a%c) * (b%c))%c
		if(b % 2 == 1) {
			return (temp * temp % C) * a % C ;
		}
		
		// 짝수 인 경우
		return temp * temp % C;
		
	}
	
}
