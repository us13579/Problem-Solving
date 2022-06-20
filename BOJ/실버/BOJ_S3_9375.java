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
 * @since 220620
 * @title 패션왕 신해빈
 */

public class BOJ_S3_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// input start
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());

			// key 값은 의상 종류, value 값은 서로다른 의상 수
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// 의상 이름
				String wear = st.nextToken();
				// 의상 종류
				String wear_title = st.nextToken();

				// 만약 map의 key 에 의상종류가 없을때
				if (!map.containsKey(wear_title)) {
					// key를 생성해준다 , 1은 밑에서 더할거
					map.put(wear_title, 0);
				}
				// value 값에 1을 더해서 대체해준다
				map.replace(wear_title, map.get(wear_title) + 1);
			}
			
			// 전체 map을 돌면서 ( value +1 ) 씩 다 곱해준다
			int sum = 1;
			for(Map.Entry<String, Integer> list : map.entrySet()) {
				sum *= (list.getValue()+1);
			}
			
			// 마지막에 1을 빼준다
			sum--;

			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
