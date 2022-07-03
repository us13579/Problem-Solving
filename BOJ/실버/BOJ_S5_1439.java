package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220703
 * @title 뒤집기
 */

public class BOJ_S5_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// **** input start ****
		String str = br.readLine();
		// **** input end ****

		int cnt0 = 0;
		int cnt1 = 0;

		if (str.charAt(0) - '0' == 0)
			cnt0++;
		else
			cnt1++;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1))
				continue;
			else {
				if (str.charAt(i) - '0' == 0)
					cnt0++;
				else if (str.charAt(i) - '0' == 1)
					cnt1++;
			}
		}
		
		int res =0;
		if(cnt0 == 0 || cnt1 == 0) res = 0;
		else {
			if(cnt0 >= cnt1) res = cnt1;
			else res = cnt0;
		}
		
		System.out.println(res);
		
		
	} // main end
} // class end
