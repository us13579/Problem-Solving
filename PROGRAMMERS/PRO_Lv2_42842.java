package PROGRAMMERS;

public class PRO_Lv2_42842 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            int s = brown + yellow;

            for(int width = s-1; width>0; width--){
                // 나누어 떨어지지 않으면 넘어가기
                if(s%width!=0) continue;

                int height = s/width;
                int y = (width - 2) * (height -2);
                int b = s-y;


                // 정답일 때
                if(y == yellow && b == brown){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
            return answer;
        }
    }
}
