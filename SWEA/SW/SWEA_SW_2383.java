package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_SW_2383{

	static class Person implements Comparable<Person> {
		int r, c, downCnt, status, time; // 행위치, 열위치, 내려가고 있는 계단 수, 현상태, 입구까지 도착시간

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		// 사람 초기화
		public void init() {
			time = downCnt = 0;
			// 이동 중인 상태로 초기화 ( 초기상태 )
			status = M;
		}

		// 오름차순은 나에서 상대 빼는게 제일 심플
		@Override
		public int compareTo(Person o) {
			return this.time - o.time; // 계단입구까지 소요되는 시간이 빠른순으로..
		}
	}

	// move, wait, down, complete
	static final int M = 1, W = 2, D = 3, C = 4;

	// 한변의 길이, 모두 계단을 내려가는 최소시간, 사람수
	static int N, min, cnt;
	// 부분집합의 구현에 사용할 선택 배열 ( 선택되면 계단1, 선택이 안되면 계단2 )
	static boolean[] selected;
	// 사람 리스트
	static ArrayList<Person> pList;
	// 계단 리스트
	static int[][] sList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			
			pList = new ArrayList<Person>();
			sList = new int[2][];
			min = Integer.MAX_VALUE;

			for (int i = 0, k = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					// 사람이면
					if (c == 1) {
						pList.add(new Person(i, j));
					}
					// 계단이면
					else if (c > 1) {
						sList[k++] = new int[] { i, j, c };
					}
				}
			}

			// 사람 수
			cnt = pList.size();

			// 사람 수 만큼 체크 배열 생성
			selected = new boolean[cnt];

			// 계단 배정하기
			divide(0);
			System.out.println("#" + tc + " " + min);

		}
	}

	// 부분집합을 이용해서 계단 배정 ( 사람이 계속 바뀐다 ) index : 사람
	static void divide(int index) {
		if(index == cnt) {
			makeList();
			return;
		}
		

		// 부분집합에 포함 : 계단 1에 배정
		selected[index] = true;
		divide(index + 1);

		// 부분집합에 비포함 : 계단 1에 배정
		selected[index] = false;
		divide(index + 1);
	}

	// selected 상태에 따라 두 계단을 이용하는 각각의 리스트 생성
	static void makeList() {
		ArrayList<Person> aList = new ArrayList<Person>();
		ArrayList<Person> bList = new ArrayList<Person>();

		for (int i = 0; i < cnt; i++) {
			// 한명씩 꺼낸다
			Person p = pList.get(i);
			// 꺼낸 사람 초기화
			p.init(); // time, downCnt, status 를 초기화
			// 계단 1
			if (selected[i]) {
				// 계단 입구까지 걸리는 시간 구하기
				p.time = Math.abs(p.r - sList[0][0]) + Math.abs(p.c - sList[0][1]);
				aList.add(p);
			}
			// 계단 2
			else {
				// 계단 입구까지 걸리는 시간 구하기
				p.time = Math.abs(p.r - sList[1][0]) + Math.abs(p.c - sList[1][1]);
				bList.add(p);
			}
		}

		// 총 소요시간 최솟값 갱신
		int res = go(aList, bList);
		if (min > res)
			min = res;

	}

	private static int go(ArrayList<Person> aList, ArrayList<Person> bList) {

		// aList 걸리는시간, bList 걸리는 시간
		int timeA = 0, timeB = 0;

		if (aList.size() > 0)
			timeA = goDown(aList, sList[0][2]);
		if (bList.size() > 0)
			timeB = goDown(bList, sList[1][2]);

		// 둘 중에 큰 값 리턴
		return timeA > timeB ? timeA : timeB;
	}

	// 계단 내려가는데 걸리는 시간
	private static int goDown(ArrayList<Person> list, int height) {

		// 계단 입구까지 빠르게 오는 순으로 정렬
		Collections.sort(list);

		// 첫번째 사람의 계단입구 도착시간부터 처리, 흘러가는 시간값
		int time = list.get(0).time;

		// 기존 사이즈 저장 ( 변하면 x )
		int size = list.size();

		// 내려가고 있는 사람수, 다 내려간 사람 수
		int ingCnt = 0, cCnt = 0;

		while (true) {
			// 매시간마다 사람들을 하나씩 꺼내어 상태를 처리한다
			for (int i = 0; i < size; i++) {
				Person p = list.get(i);

				// 사람이 나간다고 지우진 않을 것이다. ( index 가 헷갈릴 수 있음 )
				// 다 내려온 상태이면 건너뛸 것이다.
				if (p.status == C)
					continue;

				// 현재시간이 사람의 계단 입구 도착시간과 같으면
				if (p.time == time) {
					// 대기상태로 바꿔준다.
					p.status = W;
				}
				// 기다리고 있는 상태 , 계단내려가고 있는사람이 3 보다 작을 때 -> 계단 들어갈 수 있다.
				else if (p.status == W && ingCnt < 3) {
					// 이동상태로 바꿔준다.
					p.status = D;
					// 계단수 1부터 시작
					p.downCnt = 1;
					// 계단에 한명 들어왔음
					++ingCnt;
				}
				// 이동중인 상태
				else if (p.status == D) {
					// 아직 덜 내려갔다.
					if (p.downCnt < height) {
						p.downCnt++;
					}
					// 다 내려갔다.
					else {
						// 다 내려간 상태로 변경
						p.status = C;
						// 다 내려간 사람 1 증가
						++cCnt;
						// 계단 안에 사람 1 감소
						--ingCnt;
					}
				}
			}
			// 모든 인원이 내려온 경우
			if (cCnt == size) {
				break;
			}
			++time;
		}
		return time;
	}
}
