package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author us13579
 * @since 2022-02-09. 1시간 10분
 * @title 계산기2 (D4)
 */
public class SWEA_1223 {

	static StringTokenizer st;
	static String temp = "";

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

			// 곱셈 구하기
			for (int i = 1; i < N; i++) {
				stack.add(String.valueOf(str.charAt(i)));

				// 연산자 만났을 때
				if (stack.peek().equals("*")) {
					temp = stack.pop();
					continue;
				} else if (stack.peek().equals("+")) {
					continue;
				}
				// 숫자인 경우
				else {
					if (temp.equals("*")) {
						int sum = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
						stack.add(String.valueOf(sum));
						temp = "";
					} else {
						continue;
					}
				}
			}

			// 덧셈 구하기
			int sum = 0;
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				// 연산자 만났을 때
				if (stack.peek().equals("+")) {
					stack.pop();
					continue;
				}
				// 숫자인 경우
				else {
					sum += Integer.parseInt(stack.pop());
				}
			}

			sb.append(sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
