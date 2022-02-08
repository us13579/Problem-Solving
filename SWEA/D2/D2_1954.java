/**
 * @author us13579
 * @since 2022-02-03
 * @title 달팽이 숫자 
 */

import java.util.Scanner;

public class D2_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int num = 1;

			if (N == 1) {
				arr[N - 1][N - 1] = 1;
			}

			// N이 짝수인 경우
			if (N / 2 == 0) {
				for (int j = 0; j < N / 2; j++) {
					// 위에 가로
					for (int i = j; i < N - (j + 1); i++) {
						arr[j][i] = num;
						num++;
					}

					// 오른쪽 세로
					for (int i = j; i < N - (j + 1); i++) {
						arr[i][N - (j + 1)] = num;
						num++;
					}

					// 밑에 가로
					for (int i = N - (j + 1); i > j; i--) {
						arr[N - (j + 1)][i] = num;
						num++;
					}

					// 왼쪽 세로
					for (int i = N - (j + 1); i > j; i--) {
						arr[i][j] = num;
						num++;
					}
				}

			}
			
			// N이 홀수인 경우
			else {
				for (int j = 0; j < N / 2; j++) {

					// 위에 가로
					for (int i = j; i < N - (j + 1); i++) {
						arr[j][i] = num;
						num++;
					}

					// 오른쪽 세로
					for (int i = j; i < N - (j + 1); i++) {
						arr[i][N - (j + 1)] = num;
						num++;
					}

					// 밑에 가로
					for (int i = N - (j + 1); i > j; i--) {
						arr[N - (j + 1)][i] = num;
						num++;
					}

					// 왼쪽 세로
					for (int i = N - (j + 1); i > j; i--) {
						arr[i][j] = num;
						num++;
					}
					if (arr[N / 2][N / 2] == 0) {
						arr[N / 2][N / 2] = N * N;
					}
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
