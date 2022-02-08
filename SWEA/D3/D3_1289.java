/**
 * @author us13579
 * @since 2022-02-03
 * @title 원재의 메모리 복구하기
 */

import java.util.Scanner;

public class D3_1289 {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			char[] c = sc.next().toCharArray();
			int cnt = 0;
			char check = '0';
			
			for(int i=0;i<c.length;i++) {
				if(c[i] != check) {
					cnt++;
					check = c[i];
				}
			}
			System.out.println("#"+t+" "+ cnt);
		}
	}
}
