package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-03-25, 10분
 * @title 좌표 압축
 */

public class BOJ_S2_18870 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 수 개수
        int N = Integer.parseInt(br.readLine());
        
        // 숫자 저장 배열
        int[] arr = new int[N];
        // 숫자 정렬 배열
        int[] sort = new int[N];

        // 숫자 넣기
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sort[i] = arr[i];
        }

        // 정렬
        Arrays.sort(sort);

        int index = 0;


        // 순위 숫자 넣어주기
        for(int i=0; i<N; i++){
            // 만약 map 안에 값이 없다면 ( 새로운 값 )
            if(!map.containsKey(sort[i])){
                map.put(sort[i], index);
                index++;
            }
        }

        for(int i =0; i<N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
        
        
        
    }
}
