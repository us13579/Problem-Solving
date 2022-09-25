package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_S4_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 데이터 검색 속도가 빠른 HashMap 사용
        HashMap<Integer,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            map.put(input,input);
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++){
            int input = Integer.parseInt(st.nextToken());
            // 만약 값이 없다면
            if(!map.containsKey(input)) map.put(input,input);
            // 값이 있다면
            else{
                map.remove(input);
            }
        }

        System.out.println(map.size());
    }
}
