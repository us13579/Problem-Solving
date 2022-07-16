package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220716
 * @title 문자열 집합
 */

public class BOJ_S3_14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// **** input start ****
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 0);
		}

		int cnt = 0;
		
		for (int i = 0; i < S; i++) {
			if(map.containsKey(br.readLine())) cnt++;
		}
		// **** input end ****
		
		
		System.out.println(cnt);

	} // main end
} // class end
