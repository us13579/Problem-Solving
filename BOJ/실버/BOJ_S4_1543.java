package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S4_1543 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// **** input start ****
		
		String str = br.readLine();
		
		String search = br.readLine();
		
		// **** input end ****
		
		char[] c = str.toCharArray();
		char[] cc = search.toCharArray();
		
		int cnt = 0;
		
		for(int i=0; i<c.length; i++) {
			// 시작이 같다면
			if(c[i] == cc[0]) {
				int idx = i+1;
				// 같은 값인지 체크 하는 boolean 값
				boolean flag = true;
				for(int j=1;j<cc.length;j++) {
					// 범위 벗어나면 그만
					if(idx >= c.length) {
						flag = false;
						break;
					}
					// 만약 다르면 종료
					if(c[idx]!=cc[j]) {
						flag = false;
						break;
					}
					idx++;
				}
				if(flag) {
					// 문자 길이만큼 이동 -> 위에서 1을 더할 거기 때문에 -1
					// 카운팅
					i = idx-1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
