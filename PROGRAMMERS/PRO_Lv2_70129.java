package PRO;

public class PRO_Lv2_70129 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            while(s.length() > 1){
                int cntOne = 0;
                for(int i=0; i<s.length(); i++){
                    // 만약 0 인 경우
                    if(s.charAt(i) == '0') answer[1]++;
                    else cntOne++;
                }
                // 이진수로 바꾸기
                s = Integer.toBinaryString(cntOne);
                // 횟수 카운팅
                answer[0]++;
            }
            return answer;
        }
    }
}
