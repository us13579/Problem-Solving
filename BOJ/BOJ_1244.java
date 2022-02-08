/**
 * @author us13579
 * @since 2022-02-05
 * @title 스위치 켜고 끄기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sw = Integer.parseInt(br.readLine());

		int[] arr = new int[sw];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// ����ġ ��ȣ�� 1���� ���� ( ���Ǹ� ���� 0��°�� ����д� )
		for (int i = 0; i < sw; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int stu_cnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < stu_cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// ����
			if (sex == 1) {
				for (int z = 0; z < sw; z++) {
					if ((z+1) % (num) == 0) {
						arr[z] = (arr[z] == 0) ? 1 : 0;

					} else {
						continue;
					}
				}
			}

			// ����
			else if (sex == 2) {
				// ó���� �ڱ��ڽ� �ٲ��ֱ�
				arr[num-1] = (arr[num-1] == 0) ? 1 : 0;
				int left = num-1 - 1;
				int right = num-1 + 1;
				// ��,�� ���� �ٸ��ų�, ����, �������� ������ ��� �� ������
				while (true) {
					if (left < 0 || right > sw-1 || arr[left] != arr[right] ) {
						break;
					} else {
						arr[left] = (arr[left] == 0) ? 1 : 0;
						arr[right] = (arr[right] == 0) ? 1 : 0;
						left--;
						right++;
					}
				}
			}
		}
		for (int a = 0; a < sw; a++) {
			System.out.print(arr[a] + " ");
			if((a+1) % 20 == 0) {
				System.out.println();
			}
		}

	}
}
