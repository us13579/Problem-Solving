package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author us13579
 * @since 2022-03-22, 1시간
 * @title 종이의 개수
 *
 */

public class BOJ_S2_1780 {
	static StringTokenizer st;
	static int[][] arr;
	static int[] color;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 행렬의 크기 
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		// -1, 0, 1 
		color = new int[3]; 
		
		// 배열 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0,0,N);
		
		
		for(int i=0; i<3; i++) {
			System.out.println(color[i]);
		}
	}
	
	
	static void partition(int row, int col, int size) {
		// 종이가 다 같은 색이면
		if(check(row, col, size)) {
		
			if(arr[row][col] == -1) {
				color[0]++;
			}
			else if(arr[row][col] == 0) {
				color[1]++;
			}
			else {
				color[2]++;
			}
			
			return;
		}
		
		// 다 다른색이면 9 등분
		
		int newSize = size/3;
		
		// 맨 윗줄
		partition(row,col,newSize);
		partition(row,col + newSize ,newSize);
		partition(row,col + 2*newSize,newSize);
		
		// 중간 줄
		partition(row + newSize,col,newSize);
		partition(row + newSize,col + newSize ,newSize);
		partition(row + newSize,col + 2*newSize,newSize);
		
		// 맨 밑줄
		partition(row + 2*newSize,col,newSize);
		partition(row + 2*newSize,col + newSize ,newSize);
		partition(row + 2*newSize,col + 2*newSize,newSize);
		
		
	}
	
	
	// 종이가 다 같은 값인지 아닌지 
	static boolean check(int row, int col, int size) {
		int first = arr[row][col];
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(first != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
