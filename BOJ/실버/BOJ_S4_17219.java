package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220619
 * @title 비밀번호 찾기
 * 
 */

public class BOJ_S4_17219 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		// 입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// key : 주소 , value : 비밀번호
		Map<String, String> map = new HashMap<>();
		
		// 주소, 비밀번호 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			// map에 저장
			map.put(str1, str2);
		}
		
		// 주소 입력받기
		for(int i=0; i<M; i++) {
			// 주소에 따른 비밀번호 입력
			sb.append(map.get(br.readLine())).append("\n");
		}
		// 출력
		System.out.println(sb.toString());
	}
}
