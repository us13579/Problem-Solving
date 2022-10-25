package PRO;

import java.util.*;

public class PRO_Lv2_42583 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> q = new LinkedList<Integer>();

            int time = 0;
            int sum = 0;

            for(int i=0; i<truck_weights.length; i++){
                int truck_weight = truck_weights[i];

                while(true){
                    // queue에 아무것도 없는 경우
                    if(q.isEmpty()){
                        // queue에 추가, 무게 추가, 시간 추가
                        q.add(truck_weight);
                        time++;
                        sum += truck_weight;
                        break;
                    }
                    // 큐에 다리 길이만큼 트럭이 다 찬 경우
                    else if(q.size() == bridge_length){
                        sum -= q.poll();
                    }
                    // queue에 트럭이 있는 경우
                    else{
                        // 무게가 넘는 경우
                        if(weight < sum + truck_weight){
                            q.add(0);
                            time++;
                        }
                        // 무게가 안 넘는 경우
                        else{
                            q.add(truck_weight);
                            time++;
                            sum += truck_weight;
                            break;
                        }
                    }
                }
            }

            // 마지막 트럭이 나올 때 까지
            return time + bridge_length;
        }
    }
}
