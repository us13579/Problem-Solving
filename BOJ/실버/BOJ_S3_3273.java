package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_S3_3273 {
    static int N,X,res;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st=  new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
        }
        X = Integer.parseInt(br.readLine());

        // listMinus 에는 X에서 값을 뺀 값이 저장된다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int minus = X-list.get(i);
            
            // 0보다 작거나 같으면 통과
            if(minus<=0) continue;
            map.put(minus,minus);
        }

        // list 돌면서 찾기
        for(int i=0; i<N; i++){
            if(map.containsKey(list.get(i))){
                res++;
            }
        }
        System.out.println(res/2);
    }
}
