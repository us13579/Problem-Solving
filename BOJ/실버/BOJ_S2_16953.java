package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 *
 * @Author us13579
 * @since 220708
 * @title A -> B
 *
 */

public class BOJ_S2_16953 {
    static int A,B;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // **** input start ****

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // **** input end ****


        dp(A,1);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);


    }
    static void dp(long num, int cnt){
        if(num > B){
            return;
        }

        if(num == B){
            min = Math.min(min, cnt);
            return;
        }


        // 2 곱하기
        dp(num*2,++cnt);
        cnt--;

        // 1을 수 가장 오른쪽에 추가
        dp(num*10+1, ++cnt);
        cnt--;
    }
}
