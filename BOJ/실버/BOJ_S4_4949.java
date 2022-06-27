package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 
 * @author us13579
 * @since 220627
 * @title 균형잡힌 세상
 * 
 */

public class BOJ_S4_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean check = true;
		while (check) {
			String str = br.readLine();

			// 종료 조건
			if (str.equals(".")) {
				check = false;
			} else {
				String res = check(str);
				sb.append(res).append("\n");
			}
		}
		System.out.println(sb);
	}

	// Stack을 이용해 문자가 균형잡힌 문자열인지 체크
	static String check(String str) {
		String res = "yes";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			// 시작부분
			if (str.charAt(i) == '[' || str.charAt(i) == '(') {
				stack.add(str.charAt(i));
			}
			// 대괄호 닫힘
			if (str.charAt(i) == ']') {
				if (stack.size() == 0) {
					res = "no";
					break;
				}
				char pop = stack.pop();
				if (pop != '[') {
					res = "no";
					break;
				}
			}

			// 소괄호 닫힘
			if (str.charAt(i) == ')') {
				if (stack.size() == 0) {
					res = "no";
					break;
				}
				char pop = stack.pop();
				if (pop != '(') {
					res = "no";
					break;
				}
			}
		}
		
		// 마무리가 안된경우 no
		if(stack.size()>0) res="no";
		return res;
	}
}
