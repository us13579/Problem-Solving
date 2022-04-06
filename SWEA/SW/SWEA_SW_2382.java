package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_SW_2382 {

	// 비교하기위해
	static class Point implements Comparable<Point> {
		// 행, 열, 군집크기 ,방향
		int x, y, num, way;

		public Point(int y, int x, int num, int way) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.way = way;
		}

		// 크기비교
		@Override
		public int compareTo(Point o) {
			// 음수나 0이 나오면 그대로 양수가 나오면 이동
			// return this.num - o.num; // 오름차순의결과 -> 최소힙
			return o.num - this.num; // 내림차순의 결과 -> 최대힙
		}
	}

	static PriorityQueue<Point> pQueue; 
	static Point map[][];
	static int N, M, K;
	static int[] dy = { 0, -1, 1, 0, 0 }; // way를 변수로 사용하기 위해 이렇게 해줌
	static int[] dx = { 0, 0, 0, -1, 1 }; // 0 : 사용하지않음, 상 : 1, 하 : 2, 좌 : 3, 우 : 4
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");

			// 셀의 개수
			N = Integer.parseInt(st.nextToken());

			// 격리시간
			M = Integer.parseInt(st.nextToken());

			// 미생물 군집의 수
			K = Integer.parseInt(st.nextToken());
			
			map = new Point[N][N];
			pQueue = new PriorityQueue<Point>();

			// 미생물 입력 받기
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				pQueue.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			sb.append(move()).append("\n");
		}
		System.out.println(sb);
	}

	// 주어진 M 시간동안 미생물 이동 처리
	static int move() {

		int time = M, nx, ny, remainNum = 0;

		// 전체 시간
		while (time>0) {
			// 군집리스트에서 군집들을 하나씩 모두 꺼내서 처리
			Point p;
			// 1시간 동안
			while (!pQueue.isEmpty()) {
				// 가장 큰 거 먼저 나온다
				p = pQueue.poll();

				// 값을 더해주고 nx,ny에 넣어주었다.
				nx = p.x += dx[p.way];
				ny = p.y += dy[p.way];
				

				// 가장자리에 도착한 경우
				if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
					p.num /= 2;
					// 만약 1/2 했는데 소멸될 경우 그냥 돌아간다. 밑에 처리할 필요 x
					if (p.num == 0)	continue;

					// 방향 반대로 턴 -> 짝수이면 --, 홀수이면 ++ 1 3 은 방향바꿀려면 + / 2,4 는 방향바꿀려면 -
					if (p.way % 2 == 1)
						p.way++;
					else
						p.way--;
				}

				// 해당 자리에 처음 이동한 미생물 군집이면 그자리에 세팅
				if (map[ny][nx] == null) {
					map[ny][nx] = p;
				}
				// 해당 자리에 처음 이동한 미생물 군집이 아니면 기존 군집에 합치기 ( 무조건 전에 들어간게 더 크다 ->
				// PriorityQueueQueue라서
				else {
					map[ny][nx].num += p.num;
					// System.out.println(ny + " , " + nx + "의 개수는 "+ map[ny][nx].num);
				}
				
			}

			// 1시간 처리
			remainNum = reset();
			time--;
		}
		return remainNum;
	}

	// 매시간마다 필요한 정리, 초기화 작업
	static int reset() {
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != null) {
					// 다시 큐에 넣어주고
					pQueue.offer(map[i][j]);
					// 살아있는 미생물 군집의 크기 누적
					total += map[i][j].num;
					// map을 리셋시킨다
					// 다시 시간을 반복하기 위해
					map[i][j] = null;
				}
			}
		}
		return total;
	}
}