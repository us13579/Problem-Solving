package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220705
 * @title 회문
 */

public class BOJ_S1_17609 {
	static int N;
	static String str;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// **** input start ****
		N = Integer.parseInt(br.readLine());

		// **** input end ****

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			arr = str.toCharArray();

			int left = 0;
			int right = str.length() - 1;

			// 회문인 경우
			if (check(left, right)) {
				sb.append("0").append("\n");
				continue;
			}
			// 유사회문인 경우
			if (check2(left, right))
				sb.append("1").append("\n");
			// 아무것도 아닌 경우
			else {
				sb.append("2").append("\n");
			}
		}
		System.out.println(sb);

	} // main end

	// 회문인지 체크
	static boolean check(int left, int right) {
		while (left <= right) {
			// 다르면
			if (arr[left] != arr[right])
				return false;
			left++;
			right--;
		}
		return true;
	}

	// 유사 회문인지 체크
	static boolean check2(int left, int right) {
		while (left <= right) {
			if (str.charAt(left) != str.charAt(right)) {
				boolean a = check(left + 1, right);
				boolean b = check(left, right - 1);
				if (!a && !b)
					return false;
				else
					return true;
			}
			left++;
			right--;
		}
		return true;
	}
} // class end
