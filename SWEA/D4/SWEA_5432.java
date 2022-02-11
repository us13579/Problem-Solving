package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 
 * @author us13579
 * @since 2022-02-11, 1시간 
 * @title 쇠막대기 자르기, D4
 */
public class SWEA_5432 {
	static char before_value;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			// 총 합
			int res = 0;

			// 괄호 관리해줄 stack
			Stack<Character> stack = new Stack<Character>();

			// 괄호 입력
			String input = br.readLine();

			for (int i = 0; i < input.length(); i++) {
				// 괄호 하나씩 받아오기
				char temp = input.charAt(i);

				// '(' 이면 stack에 저장
				if (temp == '(') {
					stack.add(temp);
				}
				// 레이져인 경우
				else if (temp == ')' && before_value == '(') {
					stack.pop();
					res += stack.size();
				}
				// 앞에 ')' 인 경우
				else if (temp == ')' && before_value == ')') {
					stack.pop();
					res += 1;
				}
				before_value = temp;
			}
			sb.append(res).append("\n");
		}

		System.out.println(sb);
	}
}
