package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220718
 * @title 생일
 */

public class BOJ_S5_5635 {

	public static class date implements Comparable<date> {
		int year;
		int month;
		int day;
		String name;

		public date(String name, int day, int month, int year) {
			super();
			this.year = year;
			this.month = month;
			this.day = day;
			this.name = name;
		}

		
		// 다중정렬
		@Override
		public int compareTo(date o) {
			int res = 0;
			if (o.year > this.year)
				res = 1;
			else if (o.year == this.year) {
				if (o.month > this.month)
					res = 1;
				else
					res = -1;
			}
			else res = -1;
			return res;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// **** input start ****
		int N = Integer.parseInt(br.readLine());

		ArrayList<date> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new date(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list);

		// **** input end ****

		System.out.println(list.get(0).name);
		System.out.println(list.get(N-1).name);
	}
}
