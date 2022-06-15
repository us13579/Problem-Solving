package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220614
 * @title AC
 */

public class BOJ_G5_5430 {
	static ArrayDeque<Integer> deque;
	static String str, error;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		// 테케
		int TC = Integer.parseInt(br.readLine());

		for (int t = 0; t < TC; t++) {
			// 함수 입력
			str = br.readLine();

			// 수의 개수 입력
			N = Integer.parseInt(br.readLine());

			// error 저장
			error = "";

			// ArrayList ( 수 저장 리스트 )
			deque = new ArrayDeque<Integer>();
			st = new StringTokenizer(br.readLine(), "[,]");
			for (int i = 0; i < N; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			go();
		}
		System.out.println(sb);
	}
	static void go() {
		// 앞인지 뒤인지 ( 앞 true, 뒤 false )
		boolean check = true;
		
		for(int i=0; i<str.length(); i++) {
			// R 함수인 경우 방향 바꾸기 
			if(str.charAt(i) == 'R') {
				check = !check;
			}
			// D 함수 인 경우
			else if(str.charAt(i) == 'D') {
				// 배열이 정방향인 경우
				if(check) {
					// 크기가 없는 경우
					if(deque.size()<1) {
						error = "error";
					}else {
						deque.removeFirst();
					}
				}
				// 배열이 반대인 경우
				else {
					// 크기가 없는 경우
					if(deque.size()<1) {
						error = "error";
					}else {
						deque.removeLast();
					}
				}
			}
		}
		
		print(check);
	}
	
	static void print(boolean check) {
		// error 인 경우
		if(error.equals("error")) {
			sb.append("error").append("\n");
		}
		// 아닌 경우
		else {
			sb.append("[");
			// 정방향인 경우 그대로 출력
			if(check) {
				int a = deque.size();
				for(int i=0; i<a;i++) {
					sb.append(deque.poll());
					// 쉼표
					if(i != a-1) {
						sb.append(",");
					}
				}
			}
			// 아닌 경우 반대로 출력
			else {
				int a = deque.size();
				for(int i=0; i<a;i++) {
					sb.append(deque.pollLast());
					// 쉼표
					if(i != a-1) {
						sb.append(",");
					}
				}
			}
			sb.append("]").append("\n");
		}
	}
}
