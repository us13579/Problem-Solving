package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-03-06, 25분
 * @title 신나는 함수 실행
 */

public class BOJ_S2_9184 {
    static StringTokenizer st;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[21][21][21];

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c)).append("\n");

        }
        System.out.print(sb);

    }

    static int w(int a,int b,int c){

        // 이미 저장되있는 경우, 범위안에 있을 경우 바로 반환
        if(check(a,b,c) && dp[a][b][c] != 0){
            return dp[a][b][c];
        }

        // 재귀식 메모리제이션
        if(a <= 0 || b <=0 || c <= 0){
            return 1;
        }
        else if(a > 20 || b > 20 || c >20){
            return dp[20][20][20] = w(20,20,20);
        }
        else if(b > a && c > b){
            return dp[a][b][c] = w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1 ,c);
        }
        else{
            return dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        }
    }


    // 범위안에 있는지 확인
    static boolean check(int a, int b, int c){
        return a >=0 && a<=20 && b>=0 && b<=20 && c>=0 && c<=20;
    }
}
