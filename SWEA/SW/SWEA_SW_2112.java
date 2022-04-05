package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_SW_2112 {
	static int D, W, K;
	static final int A = 0, B = 1;
	static int[][] arr;
	static int[] drugA, drugB;
	static int min;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			// 막 두께
			D = Integer.parseInt(st.nextToken());
			// 막 너비
			W = Integer.parseInt(st.nextToken());
			// 합격기준 연속 셀의 개수
			K = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;

			arr = new int[D][W];
			drugA = new int[W];
			drugB = new int[W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Arrays.fill(drugA, A);
			Arrays.fill(drugB, B);

			process(0, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);

	}

	// 보호필름의 성능검사
	static boolean check() {
		// 열 고정 행 탐색 연속된 셀의 같은 특성이 K개 이상인지 검사

		// 열고정
		for (int i = 0; i < W; i++) {
			int count = 1;
			int before = arr[0][i];
			for (int j = 1; j < D; j++) {
				int current = arr[j][i];
				// 연속된 두 셀의 값이 같다
				if (before == current) {
					count++;
					if (count == K)
						break;
				}
				// 다르면
				else {
					before = current;
					count = 1;
				}
			} // 하나의 열을 고정해서 수직으로 검사
			if (count < K)
				return false;
		}
		return true;
	}

	// 각 막에 부분집합으로 약품 비투여, 약품A 투여, 약품B 투여
	static boolean process(int row, int useCnt) {

		// 기저조건 ( 마지막행까지 와서 벗어난 것 )
		if (row == D) {
			// 성능검사
			if (check()) {
				// 더 최솟값 저장
				min = Math.min(min, useCnt);
				// 약품을 하나도 사용하지 않았으면(0) true, 사용했으면(!0) false
				return min == 0;
			}
			// 성능검사 통과 X
			return false;
		}

		// 지금까지 사용한 약품의 수가 이미 최솟값보다 같거나 커도 return
		// 뒤에 더 볼필요가 없다. 이미 최소는 안됨
		if (useCnt >= min) {
			return false;
		}

		// 백업 배열 ( 현재 막의 상태배열 기억 )
		int[] backup = arr[row];

		// 약품 비투여 - 약품 cnt 는 그대로
		if (process(row + 1, useCnt))
			return true;

		// 약품 A 투여
		// 약품이 투여된 상태로 보호필름을 바꿔야 한다.
		arr[row] = drugA;
		if (process(row + 1, useCnt + 1))
			return true;

		// 약품 B 투여
		arr[row] = drugB;
		if (process(row + 1, useCnt + 1))
			return true;

		// 기존 막의 상태로 다시 바꿔놓기
		arr[row] = backup;
		return false;
	}
}
