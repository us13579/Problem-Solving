package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_19941 {
    static int N,K;
    static String str;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        str = br.readLine();
        check = new boolean[N];

        for(int i=0; i<N; i++){
            // 햄버거를 구했는지 여부 체크
            boolean flag = false;
            // 사람일 때 햄버거 찾기
            if(str.charAt(i) == 'P'){
                // 앞으로 찾기
                for(int j=K;j>0;j--){
                    int frontNum = i-j;
                    // 범위를 넘어가 거나 이미 선택했는 경우
                    if(frontNum<0 || check[frontNum])continue;
                    // 햄버거를 찾은 경우
                    if(str.charAt(frontNum) == 'H'){
                        check[frontNum] = true;
                        flag = true;
                        break;
                    }
                }
                
                // 만약 햄버거를 이미 찾았다면 통과
                if(flag) continue;
                
                // 뒤로 찾기
                for(int j=1;j<=K;j++){
                    int backNum = i+j;
                    // 범위를 넘어가 거나 이미 선택했는 경우
                    if(backNum>=N || check[backNum]) continue;
                    // 햄버거를 찾은 경우
                    if(str.charAt(backNum) == 'H'){
                        check[backNum] = true;
                        break;
                    }
                }
            }
        }

        int res = 0;
        for(int i=0; i<check.length; i++){
            if(check[i]) res++;
        }

        System.out.println(res);
    }
}
