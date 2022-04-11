package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_5607 {
	static long res;
	static final long num = 1234567891;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		// 테스트 케이스
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// nCr N
			int N = Integer.parseInt(st.nextToken());
			
			// R
			int R = Integer.parseInt(st.nextToken());
			
			res = 0;
			
			// N factorial 구하기
			long[] fac = new long[N+1];
			fac[0] = 1;
			for(int i=1; i<=N; i++) {
				fac[i] = (fac[i-1]*i) % num;
			}
			
			// nCr = n! / (n-r)! * r!
			// 분자
			long up = fac[N];
			// 분모
			long down = (fac[N-R] * fac[R]) % num;
			// 페르마 소정리
			// nCr = n! * ((n-r)! * r!)^(num-2)
			long reFacDown = pow(down, num-2);
			
			// nCr 계산
			res = (up*reFacDown)%num;
			
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	// aⁿ 구하기 최적의 방법
	static long pow(long a, long N) {
		// 조합 성질 
		if(N==0) return 1;
		if(N==1) return a;
		// 짝수이면
		if(N%2==0) {
			long temp = pow(a,N/2);
			return (temp*temp)%num;
		}
		long temp = pow(a,N-1)%num;
		return (temp*a)%num;
	}
}
