package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @Author us13579
 * @since 220625
 * @title 체스판 다시 칠하기
 */

public class BOJ_S4_1018 {
    static char[][] board;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // **** input start ****
        // 행
        N = Integer.parseInt(st.nextToken());
        // 열
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        // 좌표입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        // **** input end ****


        // 체크할 string
        String str1 = "BWBWBWBW";
        String str2 = "WBWBWBWB";
        int sum = 0;
        int min = Integer.MAX_VALUE;

        // 모든 좌표 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 가지치기 만약 8*8 배열을 만들지 못한다면 ( 범위 초과 ) 통과
                if(i+8>N || j+8>M){
                    continue;
                }

                sum = rectangle(j,i,str1,str2);
                // 최솟값 구하기
                min = Math.min(min, sum);

                sum = rectangle(j,i,str2,str1);
                // 최솟값 구하기
                min = Math.min(min, sum);
            }
        }

        System.out.println(min);

    } // main end

    // sum 계산
    static int rectangle(int x, int y, String first, String second){
        int sum = 0;
        // 행 번호
        int temp = 0;

        for(int i=y; i<y+8; i++){
            // string 열 번호
            int temp2 = 0;
            for(int j=x; j<x+8; j++){
                // first check
                if(temp % 2 == 0){
                    // 만약 값이 다르다면 카운팅
                    if(board[i][j] != first.charAt(temp2)) sum++;
                }
                // second check
                else{
                    // 만약 값이 다르다면 카운팅
                    if(board[i][j] != second.charAt(temp2)) sum++;
                }
                // string 열 플러스
                temp2++;
            }
            // 행 플러스
            temp++;
        }
        return sum;
    }


} // class end
