package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220707
 * @title 트리의 부모 찾기
 */

public class BOJ_S2_11725 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// **** input start ****
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list[] = new ArrayList[N+1];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		// **** input end ****
		
		boolean[] v = new boolean[N+1];
		
		// BFS
		Queue<Integer> queue = new LinkedList<Integer>();
		// 루트 값
		queue.add(1);
		// 방문처리
		v[1] = true;
		// 결과 저장 배열
		int[] res = new int[N+1];
		
		while(!queue.isEmpty()) {
			// 현재 ArrayList 출력 ( 연결되어있는 곳 )
			Integer num = queue.poll();
			// ArrayList for문
			// i 는 값들 ( list 안에 있는 값들 )
			for(Integer i : list[num]) {
				// 방문안했으면 
				if(!v[i]) {
					// 방문처리
					v[i] = true;
					// 결과 값에 부모 넣어주기
					res[i] = num;
					queue.add(i);
				}
			}
		}
		
		// 출력
		for(int i=2; i<res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
