package PROGRAMMERS;

import java.util.*;

public class PRO_42586 {

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> qValue = new LinkedList<Integer>();

        for(int i=0; i<progresses.length; i++){
            q.add(progresses[i]);
            qValue.add(speeds[i]);
        }


        while(!q.isEmpty()){
            int size = q.size();
            // 하루에 개발이 다 된 기능 수
            int cnt = 0;
            // 먼저 계산해주기 ( 한번 돌리기 ) - 하루
            for(int i=0; i<size; i++){
                int key = q.poll();
                int value = qValue.poll();
                // 작업 하기
                key += value;

                // 다시 넣어주기
                q.add(key);
                qValue.add(value);
            }

            for(int i=0; i<size; i++){
                int key = q.peek();

                if(key>=100){
                    cnt++;
                    q.poll();
                    qValue.poll();
                }else{
                    break;
                }
                }
            if(cnt > 0){
                answer.add(cnt);
            }
            }
        return answer;
    }
}
}
