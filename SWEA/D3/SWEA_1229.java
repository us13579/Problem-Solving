package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author us13579
 * @since 2022-02-08, 20분
 * @title 암호문2 (D3)
 */

public class SWEA_1229 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int T = 1; T <= 10; T++) {
			sb.append("#");
			sb.append(T).append(" ");

			// 원본 암호문 길이
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			ArrayList<Integer> arr = new ArrayList<Integer>();

			// 원본 암호문
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			// 명령어 개수
			int cnt = Integer.parseInt(br.readLine());

			String[] arr_2 = new String[cnt];

			// 'I,D'를 경계로 나누기 -> 배열 arr_2에 저장
			st = new StringTokenizer(br.readLine(), "I|D");
			for (int i = 0; i < cnt; i++) {
				arr_2[i] = st.nextToken();
			}

			// y개의 숫자만큼 arr_int 배열에 저장
			for (int i = 0; i < cnt; i++) {
				String[] arr_int = arr_2[i].split(" ");

				// D인 경우 배열의 크기가 3 ( 공백, x, y)
				if (arr_int.length == 3) {
					// 삭제할 위치 (x값)
					int loc = Integer.parseInt(arr_int[1]);
					
					// x 위치에서 y 개수 만큼 삭제하기 -> 삭제되면 자동으로 댕겨진다 ArrayList는
					for(int j=0; j<Integer.parseInt(arr_int[2]); j++) {
						arr.remove(loc);
					}
					
				}

				// I인경우 배열의 크기가 4이상
				else {
					// 추가될 위치 (x값)
					int loc = Integer.parseInt(arr_int[1]);

					// loc위치 계속 증가해줄 변수
					int temp = 0;
					// x 위치에서 y 개수 만큼 추가시키기
					for (int j = 3; j < 3 + Integer.parseInt(arr_int[2]); j++) {
						arr.add(loc + temp, Integer.parseInt(arr_int[j]));
						temp++;
					}
				}
			}

			for (int i = 0; i < 10; i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}
}
