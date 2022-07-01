package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220701
 * @title 뱀과 사다리 게임
 */

public class BOJ_G5_16928 {
	static int N, M, res;
	static int[] map;
	static int[] cnt;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// **** input start ****
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[101];
		v = new boolean[101];
		cnt = new int[101];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// 어차피 사다리 , 뱀 이동하는 것은 같다
			map[start] = end;
		}
		// **** input end ****

		bfs();

		System.out.println(res);

	} // main end

	// bfs
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		// 카운팅, 방문처리
		cnt[1] = 0;
		v[1] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur == 100) {
				res = cnt[cur];
				break;
			}
			
			// 주사위 던지기
			for(int i=1; i<=6; i++) {
				int next = cur + i;
				
				// 100을 넘거나 이미 방문한 경우 통과
				if(next > 100 || v[next]) continue;
				
				// 이동할 거리가 있는 경우 ( 사다리 아니면 뱀 )
				if(map[next] != 0) {
					// 도착하는 곳이 방문하지 않은 경우
					if(!v[map[next]]) {
						// 방문처리
						v[map[next]] = true;
						// 카운팅
						cnt[map[next]] = cnt[cur] +1;
						queue.add(map[next]);
					}
				}
				// 이동할 거리가 없는 경우
				else {
					// 방문처리
					v[next] = true;
					cnt[next] = cnt[cur] + 1;
					queue.add(next);
				}
			}
		}
	}

} // class end
