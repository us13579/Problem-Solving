package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-03-30, 2시간
 * @title 최소 스패닝 트리
 */

// 크루스칼 알고리즘
public class SWEA_D4_3124 {
	static StringTokenizer st;
	// 부모노드 저장할 배열
	static int parents[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 수
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");

			// 정점의 개수
			int V = Integer.parseInt(st.nextToken());

			// 간선의 개수
			int E = Integer.parseInt(st.nextToken());

			// 정점 정보 2개 + 이동릐 가중치 순으로 입력이 들어온다
			int[][] edges = new int[E][3];

			// 1번부터 인덱스를 사용하기 위해 V+1
			parents = new int[V + 1];

			// 입력받기
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				edges[i][0] = Integer.parseInt(st.nextToken());
				edges[i][1] = Integer.parseInt(st.nextToken());
				edges[i][2] = Integer.parseInt(st.nextToken());

			}

			// 가중치 오름 차순으로 정리

			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					// 2번 인덱스에 가중치가 있다
					return Integer.compare(o1[2], o2[2]);
				}
			});

			// parents를 -1로 초기화
			Arrays.fill(parents, -1);

			// 출력될 가중치의 합, 범위가 넓어서 long 으로 설정 !!
			long res = 0;
			int cnt = 0;

			// 간선의 수만큼 loop 수행
			for (int i = 0; i < edges.length; i++) {
				// 정점과 정점이 연결될 수 있는지 확인
				if (union(edges[i][0], edges[i][1])) {
					res += edges[i][2]; // 가중치 덧셈
					cnt++;
				}

				// cnt가 ( 정점 -1개 )가 된다는 것은 모든 정점을 다 연결했다는 의미이므로 종효
				if (cnt == V - 1) {
					break;
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int x) {
		if (parents[x] < 0)
			return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int x, int y) {
		int xRoot = find(x); 	// x의 root를 찾아서 결과 받음
		int yRoot = find(y);	// y의 root를 찾아서 결과 받음
		
		if(xRoot != yRoot) {
			parents[yRoot] = xRoot;
			return true;
		}
		// 연결을 하지 못한 경우면 false
		return false;
	}
}
