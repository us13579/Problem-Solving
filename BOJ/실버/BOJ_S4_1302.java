package BOJ;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

/****
 * 
 * @author us13579
 * @since 220713
 * @title 베스트셀러
 */

public class BOJ_S4_1302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// **** input start ****

		int N = Integer.parseInt(br.readLine());
		int max = 0;
		String res = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			// 만약 포함하고 있다면
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}else {
				map.put(str, 1);
			}
		}

		// **** input end ****
		
		// map을 돌면서 value가 최대값을 찾음
		for(String key : map.keySet()) {
			int cnt = map.get(key);
			
			// 만약 이미 최대값과 값이 같다면 사전순으로 앞서는거 비교
			if(max == cnt && res.compareTo(key)>0) {
				res = key;
				max = cnt;
			}else if(max < cnt){
				res = key;
				max = cnt;
			}
		}
		System.out.println(res);

	
	} // main end
} // class end