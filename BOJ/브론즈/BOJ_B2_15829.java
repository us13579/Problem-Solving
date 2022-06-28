package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220628
 * @title Hashing
 * 
 */

public class BOJ_B2_15829 {
	static final int M = 1234567891;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// **** input start ****
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		long sum = 0;
		long r = 1;
		for(int i=0; i<N;i++) {
			sum += ((str.charAt(i)-96) * r) % M;
			r = (r * 31) % M;
		}
		
		// **** input end ****
		System.out.println(sum%M);		
	}
}
