package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        // input
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 총 도는 횟수
        int cnt = N-K+1;

        // 최댓값
        // 온도가 마이너스인 경우도 있기 때문에 초기 max 값을 최솟값으로 잡아줘야 한다
        int max = Integer.MIN_VALUE;

        for(int i=0; i<cnt; i++){
            // 연속 K일 총 합
            int sum = 0;
            for(int j=i; j<K+i; j++){
                sum += arr[j];
            }
            // 최댓값 구하기
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
