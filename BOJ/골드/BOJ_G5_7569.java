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
 * @since 220629
 * @title 토마토
 * 
 */

public class BOJ_G5_7569 {

	static class tomato {
		int x;
		int y;
		int z;

		public tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int M, N, H, cnt;
	static int[][][] box;
	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<tomato> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// **** input start ****
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H][N][M];

		queue = new LinkedList<tomato>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int z = 0; z < M; z++) {
					box[i][j][z] = Integer.parseInt(st.nextToken());
					// 익은 토마토라면 queue 에 삽입
					if (box[i][j][z] == 1)
						queue.add(new tomato(z, j, i));
				}
			}
		}
		// **** input end ****
		
		System.out.println(BFS());

	} // main end

	public static int BFS() {
		// 큐가 빌때까지
		while(!queue.isEmpty()) {
			tomato to = queue.poll();
			
			int x = to.x;
			int y = to.y;
			int z = to.z;

			int nx,ny,nz;
			for(int i=0; i<6; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				nz = z + dz[i];
				
				// 범위 안에서 체크
				if(nx>=0 && ny>=0 && nz>=0 && nx<M && ny<N && nz<H) {
					// 토마토가 안익었으면
					if(box[nz][ny][nx]==0) {
						// 토마토 익혀서 추가
						queue.add(new tomato(nx, ny, nz));
						
						// 익은 날 + 1
						box[nz][ny][nx] = box[z][y][x] + 1;
					}
				}
			}
		}
			// 최대 날짜
			int res = Integer.MIN_VALUE;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						// 만약 안익은 토마토가 있다면
						if(box[i][j][k] == 0) return -1;
						
						// 좌표에는 날짜들이 저장되어 있다.
						res = Math.max(res, box[i][j][k]);
					}
				}
			}
			
			// 돌기전에 이미 다 익은 토마토만 있는 경우
			if(res == 1) return 0;
			
			// 최대날짜에서 1빼주기
			else return res-1;
		}
} // class end
