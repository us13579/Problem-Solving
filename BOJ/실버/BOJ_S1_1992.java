package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 220617
 * @title 쿼드트리
 * 
 */

public class BOJ_S1_1992 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 start
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		// 입력 end

		// 함수 Start
		QuadTree(0, 0, N);
		// 함수 End
		
		
		// 출력
		System.out.println(sb);
		
	}

	// 재귀 함수 
	static void QuadTree(int x, int y, int size) {
		// 만약 압축이 가능하면 하나의 색상으로 압축
		if(check(x,y,size)) {
			sb.append(map[y][x]);
			return;
		}
		
		// 압축이 불가능 하면 사이즈를 1/2 한다
		int newSize = size / 2;
		
		// 여는 괄호
		sb.append("(");
		
		// 왼쪽 위
		QuadTree(x, y, newSize);
		// 오른쪽 위
		QuadTree(x+newSize,y,newSize);
		// 왼쪽 아래
		QuadTree(x, y+newSize, newSize);
		// 오른쪽 아래
		QuadTree(x+newSize, y+newSize, newSize);
		
		// 닫는 괄호
		sb.append(")");
	}
	
	// 압축이 가능한지 체크 해주는 함수
	static boolean check(int x, int y, int size) {
		// 제일 초기값 입력
		int temp = map[y][x];
		
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				// 만약 다른 색이 있으면 false
				if(temp != map[i][j]) return false;
			}
		}
		// 모두 다 같은 색이면 true
		return true;
	}
}
