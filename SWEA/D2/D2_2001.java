/**
 * @author us13579
 * @since 2022-02-04
 * @title 파리 퇴치
 */


import java.util.Scanner;

public class D2_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 입력
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			
			int max = 0;

			// 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					int sum = 0;
					
					// M*M 파리채 탐색
					for (int a = 0; a < M; a++) {
						for (int b = 0; b < M; b++) {

							int nx, ny;
							nx = j + b;
							ny = i + a;

							// 범위 넘어가면 중지
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
								break;
							} else {
								sum += arr[ny][nx];
							}
						}
					}
					
					// 최댓값 구하기
					max = Math.max(max, sum);
				}
			}

			// 출력
			System.out.println("#" + tc + " " + max);

		}
	}
}
