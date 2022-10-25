package PRO;

public class PRO_Lv2_42584 {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i=0; i<prices.length-1; i++){
                int sum =0;
                int value = prices[i];
                boolean flag = false;
                for(int j=i+1; j<prices.length; j++){
                    if(value>prices[j]){
                        answer[i] = ++sum;
                        flag = true;
                        break;
                    }
                    sum++;
                }
                if(!flag){
                    answer[i] = sum;
                }
            }
            return answer;
        }
    }
}
