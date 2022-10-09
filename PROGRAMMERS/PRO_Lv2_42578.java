package PRO;

import java.util.HashMap;
import java.util.Map;

public class PRO_Lv2_42578 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> map = new HashMap<>();

            // hashMap에 값들 넣기
            // key : 의류 종류 , value : 의류 이름
            for(int i=0; i<clothes.length; i++){
                // 의류 종류
                String clothesType = clothes[i][1];

                // 만약 의류 종류가 이미 있으면
                if(map.containsKey(clothesType)){
                    // 하나 카운팅 추가해주기
                    map.put(clothesType,map.get(clothesType)+1);
                }
                // 의류 종류가 없으면 추가
                else{
                    map.put(clothesType,1);
                }
            }

            for(int num : map.values()){
                answer *= (num+1);
            }

            // 모두 제외하는 경우
            answer -= 1;

            return answer;
        }
    }
}
