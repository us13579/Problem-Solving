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
 * @since 2022-04-08, 45분
 * @title 스타트와 링크
 */
 
public class BOJ_S2_14889 {
	static int N;
	static int[][] arr;
	static boolean[] c;
	static int min = Integer.MAX_VALUE;
	static int res = 0;
	static List<Integer> team1;
	static List<Integer> team2;
	static int team1_sum;
	static int team2_sum;
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람 수
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		// 뽑음 유무
		c = new boolean[N];
		
		// 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		team1 = new ArrayList<Integer>();
		team2 = new ArrayList<Integer>();
		
		perm(0,0);
		System.out.println(min);
		
	}
	

	
	
	
	// 순열
	static void perm(int idx, int start) {
		
		if(idx == N/2) {			
			for(int i=0; i<N; i++) {
				if(c[i]) {
					team1.add(i);
				}
				else {
					team2.add(i);
				}
			}
			
			// team1 합구하기
			for(int i=0; i<team1.size(); i++) {
				for(int j=0; j<team1.size(); j++) {
					team1_sum += arr[team1.get(i)][team1.get(j)];
				}
			}
			
			// team2 합구하기
			for(int i=0; i<team2.size(); i++) {
				for(int j=0; j<team2.size(); j++) {
					team2_sum += arr[team2.get(i)][team2.get(j)];
				}
			}
			
			// 최솟값 구하기
			min = Math.min(min, Math.abs(team1_sum - team2_sum));
			// 둘다 초기화
			team1.clear();
			team2.clear();
			team1_sum = 0;
			team2_sum = 0;
			
			return;
		}
		
		for(int i=start;i<N; i++) {
			c[i] = true;
			perm(idx+1,i+1);
			c[i] = false;
		}
	}
}
