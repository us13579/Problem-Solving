package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 
 * @author us13579
 * @since 2022-02-11, 20분
 * @title 요세푸스 문제, 실버5
 */

public class BOJ_1158 {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                StringBuilder sb = new StringBuilder();
                Queue<Integer> queue = new LinkedList<>();


                int N = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());

                
                for(int i=1;i<N+1; i++){
                	queue.add(i);
                }


                sb.append("<");
                while(!queue.isEmpty()){
                        for(int i=0;i<K-1;i++){
                        	queue.add(queue.poll());
                        }
                        sb.append(queue.poll());
                        if(queue.isEmpty()){
                                break;
                        }
                        sb.append(", ");
                }
                sb.append(">");
                System.out.println(sb);
        }
}