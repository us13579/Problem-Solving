package PROGRAMMERS;

import java.util.Arrays;

public class PRO_Lv2_42747 {
    class Solution{
        public int solution(int[] citations) {
            int answer = 0;

            // 정렬
            Arrays.sort(citations);

            int size = citations.length;

            // 배열 돌면서 h의 최댓값이 나오는 순간 끝
            for(int i=0; i<size;i++){
                int temp = size-i;

                if(citations[i] >= temp){
                    answer = temp;
                    break;
                }

            }
            return answer;
        }
    }
}
