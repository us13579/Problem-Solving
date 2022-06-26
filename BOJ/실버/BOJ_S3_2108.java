package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/***
 * 
 * @author us13579
 * @since 220626
 * @title 통계학
 * 
 */

public class BOJ_S3_2108 {
	static ArrayList<Integer> list;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// **** input start ****

		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		// 정수 입력
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			list.add(input);
			// 빈도 추가
		}

		// **** input end ****

		// 정렬하기
		Collections.sort(list);

		// **** output ****
		sb.append(avg()).append("\n").append(center()).append("\n").append(mostView()).append("\n").append(diff());

		System.out.println(sb);

	}

	// 산술평균
	static int avg() {
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			sum += list.get(i);
		}
		double avg = sum / list.size();

		return (int) Math.round(avg);
	}

	// 중앙값
	static int center() {
		return list.get(list.size() / 2);
	}

	// 최빈값
	static int mostView() {
		// N이 한개면 그냥 출력
		if (N == 1)
			return list.get(0);
		else {
			// map 사용 ( 값, 빈도수 )
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < list.size(); i++) {
				// 포함되어져 있으면 빈도수만 1 증가
				if (map.containsKey(list.get(i))) {
					map.replace(list.get(i), map.get(list.get(i)) + 1);
				} else {
					// 새로운 값이면 1 입력
					map.put(list.get(i), 1);
				}
			}

			// 빈도수 리스트
			ArrayList<Integer> check = new ArrayList<>();
			

			for (Entry<Integer, Integer> m : map.entrySet()) {
				check.add(m.getValue());
			}
			
			// 정렬
			Collections.sort(check);
			
			int temp = check.get(check.size()-1);
			
			// 최빈값이 2개 이상
			if(check.get(check.size()-1) == check.get(check.size()-2)) {
				check.clear();
				// map 돌면서 2번째로 작은 값 출력
				for (Entry<Integer, Integer> m : map.entrySet()) {
					// 최빈값인 경우
					if(m.getValue() == temp) {
						// key 값 저장
						check.add(m.getKey());
					}
				}
				// key 값 정렬
				Collections.sort(check);
				
				// 두번째 값 출력
				return check.get(1);
				
			}
			// 최빈값이 1개인 경우
			else {
				int res = 0;
				// map 돌면서 2번째로 작은 값 출력
				for (Entry<Integer, Integer> m : map.entrySet()) {
					// 최빈값인 경우
					if(m.getValue() == temp) {
						res = m.getKey();
					}
				}
				return res;
			}
		}
	}

	// 범위
	static int diff() {
		return list.get(list.size() - 1) - list.get(0);
	}

}
