package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/***
 * 
 * @author us13579
 * @since 2022-04-06, 2시간
 * @title 스도쿠
 */

public class BOJ_G4_2239 {
	static int[][] map;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 판
		map = new int[9][9];

		list = new ArrayList<int[]>();

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			String[] sstr = str.split("");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(sstr[j]);

				if (map[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		perm(0);

	}

	// 순열
	static void perm(int idx) {

		// 기저조건
		if (list.size() == idx) {
			output();
			// 제일 처음 나오는 것 출력하고 끝 !!
			System.exit(0);
		}

		// 좌표 기록
		int x = list.get(idx)[1];
		int y = list.get(idx)[0];

		// 1 ~ 9 까지 사용된 숫자 체크 true
		boolean[] v = new boolean[10];

		// 행확인
		check_row(x, y, v);
		// 열확인
		check_col(x, y, v);
		// 3*3 확인
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		check(startX, startY, v);
		
		for(int i=1; i<10; i++) {
			// 아직 수를 넣지 않은 자리면
			if(!v[i]) {
				map[y][x] = i;
				perm(idx+1);
				// 백트래킹
				map[y][x] = 0;
			}
		}

	}

	// 3*3 배열 확인
	static void check(int x, int y, boolean[] v) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				if (map[i][j] != 0) {
					v[map[i][j]] = true;
				}
			}
		}
	}

	// 행확인 -> 이미 본인 값이 있으면 false , 아니면 true
	static void check_row(int x, int y, boolean[] v) {
		for (int i = 0; i < 9; i++) {
			if (map[y][i] != 0)
				v[map[y][i]] = true;
		}
	}

	// 열확인 -> 이미 본인 값이 있으면 false , 아니면 true
	static void check_col(int x, int y, boolean[] v) {
		for (int i = 0; i < 9; i++) {
			if (map[i][x] != 0)
				v[map[i][x]] = true;
		}
	}

	// 스도쿠 출력하는 부분
	static void output() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
