package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_G3_2252 {
	static int N; // 정점의 갯수
	static int M; // 간선의 갯수
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		// 인접리스트
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		// 위상정렬
		// 1. 진입차수를 관리할 1차원 배열이 필요하다(정점의 개수만큼)
		int[] inD = new int[N + 1]; // 초기값 0
		// 입력
		int x, y;
		for (int i = 0; i < M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			list[x].add(y);
		// 2. 입력받은면수 진입차수 배열에 진입차수를 누적한다.    
			inD[y]++;
		}

		// 3. 큐에 진입차수가 0인 것을 모두 삽입한다.
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (inD[i] == 0) {
				q.offer(i);
			}
		}
		// 큐 사이즈가 0이면 위상정렬불가
		if (q.size() == 0) {
			return;
		}

		// 4. 큐사이즈가 빌때까지 자신과 연결된 정점의 진입차수를 1씩 감소한다.
		// 감소된 진입차수가 0인 정점은 큐에 삽입한다.

		ArrayList<Integer> res = new ArrayList<Integer>();
		Integer cur = -1;
		while (!q.isEmpty()) {
			cur = q.poll();
			// 자신의 할 일 구현
			res.add(cur);
			//자신과 연결된 정점의 진입차수를 1씩 감소한다.
			for (int i = 0; i < list[cur].size(); i++) {
				int idx = list[cur].get(i);
				inD[idx]--;
				//감소된 진입차수가 0인 정점은 큐에 삽입한다.
				if (inD[idx] == 0) {
					q.offer(idx);
				}
			}

		}

		//사이클 존재여부판단
		if (res.size() != N) {
			return;
		}

		for (int idx : res) {
			System.out.print(idx + " ");
		}
		System.out.println();

	}

}
