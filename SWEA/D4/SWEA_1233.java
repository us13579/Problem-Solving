package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 2022-02-11,1시간
 * @title 사칙연산 유효성 검사, D4
 */

public class SWEA_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 11; i++) {
			// 정점의 총 수
			int N = Integer.parseInt(br.readLine());
			int res = 0;

			for (int j = 0; j < N; j++) {
				String[] str = br.readLine().split(" ");

				if (j < N / 2) {
					if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
						res = 1;
					} else {
						res = 0;
					}
				} else {
					if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
						res = 0;
					}
				}
			}
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
