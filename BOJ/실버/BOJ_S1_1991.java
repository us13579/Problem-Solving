package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 220709
 * @title 트리 순회
 * 
 */

public class BOJ_S1_1991 {
	// 왼쪽, 오른쪽 저장 노드
	static class Node{
		int left;
		int right;
		public Node(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
	
	static int N;
	static List<Node>[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// **** input start ****
		
		N = Integer.parseInt(br.readLine());
		
		// ArrayList를 품고있는 list 생성
		list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			// 0 -> 'A', 1 -> 'B', 2 -> 'C',
			int top = st.nextToken().charAt(0) - 65;
			int left = st.nextToken().charAt(0) - 65;
			int right = st.nextToken().charAt(0) - 65;
			
			// 리스트에 노드 입력
			list[top].add(new Node(left, right));
		}

		// **** input end ****
		
		// 전위
		preorder(0);
		sb.append("\n");
		// 중위
		inorder(0);
		sb.append("\n");
		// 후위
		postorder(0);
		
		System.out.println(sb);
	}

	// 전위 : 루트 -> 왼 -> 오
	static void preorder(int start) {
		for(Node node : list[start]) {
			int left = node.left;
			int right = node.right;
			
			// 출력
			sb.append((char)(start+'A'));
			// 왼쪽 것이 '.' 이 아닌 경우 
			if(left != -19) preorder(left);
			// 오른쪽 것이 '.' 이 아닌 경우
			if(right != -19) preorder(right);
		}
	}

	// 중위 : 왼 -> 루트 -> 오
	static void inorder(int start) {
		for(Node node : list[start]) {
			int left = node.left;
			int right = node.right;
			
			// 왼쪽 것이 '.' 이 아닌 경우 
			if(left != -19) inorder(left);
			// 출력
			sb.append((char)(start+'A'));
			// 오른쪽 것이 '.' 이 아닌 경우
			if(right != -19) inorder(right);
		}
	}

	// 후위 : 왼 -> 오른 -> 루트
	static void postorder(int start) {
		for(Node node : list[start]) {
			int left = node.left;
			int right = node.right;
			
			// 왼쪽 것이 '.' 이 아닌 경우 
			if(left != -19) postorder(left);
			// 오른쪽 것이 '.' 이 아닌 경우
			if(right != -19) postorder(right);
			// 출력
			sb.append((char)(start+'A'));
		}
	}
}
