package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-09.37분
 * @title 계산기1 (D4)
 */
public class SWEA_1222 {
	static StringTokenizer st;
	static String num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");

			// 계산식 길이
			int N = Integer.parseInt(br.readLine());

			// 문자열
			String str = br.readLine();

			Stack<String> stack = new Stack<String>();

			// 첫번째 수 입력
			stack.add(String.valueOf(str.charAt(0)));

			for (int i = 1; i < N; i++) {

				stack.add(String.valueOf(str.charAt(i)));

				// 연산자 만났을 때
				if (stack.peek().equals("+")) {
					stack.pop();
					continue;
				}
				// 숫자인 경우
				else {
					int sum = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
					stack.add(String.valueOf(sum));
				}
			}

			sb.append(stack.pop());
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
