package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_G5_2565 {
    static int[] dp;
    static int[][] wire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        dp = new int[N];
        wire = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 정렬
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        // 풀이 방법
        // 연결할 수 있는 최대 전선 개수를 구해서 총 전선 개수에서 빼주면 최소 전선 삭제 수를 구할 수 있다.


        // 최댓값 ( 연결가능한 )
        int max = 0;

        // i번째 A전봇대를 개준으로 연결가능한 개수 탐색, 최댓값 찾기
        for(int i=0; i<N; i++){
            max = Math.max(max, recur(i));
        }

        // 전체 전선 개수 - 최댓값 = 최소로 없애는 전선 수
        System.out.println(N - max);

    }

    static int recur(int N) {
        // 처음 탐색하는 전봇대라면
        if(dp[N] == 0){
            
            // 최솟값을 1로 초기화
            dp[N] = 1;

            // A의 N번째와 이후의 전봇대들 비교
            for(int i=N+1; i<dp.length;i++){
                // 만약 연결할 수 있으면
                if(wire[N][1] < wire[i][1]){
                    // dp 배열에 더 큰 값을 저장해준다.
                    // A 전봇대의 N번째 전선이 연결되어있는 B전봇대보다
                    // A의 i번째 전봇대의 전선이 이어진 B전봇대가 뒤에있을 경우
                    // 전선을 설치할 수 있다.
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
