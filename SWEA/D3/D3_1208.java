/**
 * @author us13579
 * @since 2022-02-04
 * @title Flatten
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D3_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int dump_cnt = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int max,min,result;

			// 값 입력
			for (int i = 0; i < 100; i++) {
				arr.add(sc.nextInt());
			}

			
			// 평탄화 작업
			for(int i=0; i<dump_cnt;i++) {
				// 정렬 후 / 처음 값 : 최솟값  / 마지막 값 : 최댓값  
				Collections.sort(arr);
				max = arr.get(99);
				min = arr.get(0);
				
				// 평탄화 작업
				max -= 1;
				min += 1;
				
				// 평탄화 작업 후 값 변경
				arr.set(99,max);
				arr.set(0, min);
			}
			
			// 마지막에 정렬 한번 더 !
			Collections.sort(arr);
			
			// 최댓값 - 최솟값
			result = arr.get(99)-arr.get(0);

			// 출력
			System.out.println("#" + t + " " + result);
		}
	}
}
