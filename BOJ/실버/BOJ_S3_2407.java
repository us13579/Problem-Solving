package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-27, 30분
 * @title 조합
 *
 */

public class BOJ_S3_2407 {
	static StringTokenizer st;
	static long res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		// n1,n2 1로 초기화
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		// nCm 계산 = ( n * (n-1) * (n-2) .. * (n-m+1) ) / ( 1 * 2 * 3 .. * m )
		for(int i=0; i<m; i++){
			n1=n1.multiply(new BigInteger(String.valueOf(n-i)));
			n2=n2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		// 마지막 나눠주기
		System.out.println(n1.divide(n2));

	}
	}

