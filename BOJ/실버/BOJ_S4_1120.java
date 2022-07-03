package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220703
 * @title 문자열
 */

public class BOJ_S4_1120 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=(B.length()-A.length()); i++) {
			// 몇개가 다른가 체크
			int cnt = 0;
			int idx = i;
			for(int j=0;j<A.length();j++) {
				if(B.charAt(idx) != A.charAt(j)) cnt++;
				idx++;
			}
			min = Math.min(min, cnt);
		}
		System.out.println(min);
	}
}
