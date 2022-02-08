package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author us13579
 * @since 2022-02-08, 30분
 * @title 암호생성기(D3)
 * 
 */
public class SWEA_1225 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		for (int T = 1; T <= 10; T++) {
			int tc = Integer.parseInt(br.readLine());
			sb.append("#");
			sb.append(T);
			sb.append(" ");
			
			// 입력
			Queue<Integer> q = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(q.size()>7) {
				//한 사이클
			for(int i=1; i<=5; i++) {				
				int x = q.poll();
				x -= i;
				if(x <= 0) {
					for(int j =0; j<7;j++) {
						sb.append(q.poll());
						sb.append(" ");
					}
					sb.append("0");
					break;
				}
				q.offer(x);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
	
}
