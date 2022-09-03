package PROGRAMMERS;

import java.util.*;

public class PRO_118666{

class Solution {
    // 문자와 그 문자의 개수 
    class Set{
        private char type;
        private int count;

        public Set(char type, int count){
            this.type = type;
            this.count = count;
        }

    }
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        // 리스트에 문자와 개수 넣기
        List<Set> list = new ArrayList<Set>();
        list.add(new Set('R',0));
        list.add(new Set('T',0));
        list.add(new Set('C',0));
        list.add(new Set('F',0));
        list.add(new Set('J',0));
        list.add(new Set('M',0));
        list.add(new Set('A',0));
        list.add(new Set('N',0));

        for(int i=0; i<survey.length; i++){
            // 숫자
            int num = choices[i];
            // 점수
            int score = 0;
            // 만약 4보다 작으면
            if(num < 4){
                char temp = survey[i].charAt(0);
                score = 4-num;
                // 리스트 돌면서 확인
                for(int j=0; j<list.size(); j++){
                    if(temp == list.get(j).type){
                        list.get(j).count += score;
                        break;
                    }
                }
            }
            // 4보다 크면
            else if(num > 4){
                char temp = survey[i].charAt(1);
                score = num-4;
                // 리스트 돌면서 확인
                for(int j=0; j<list.size(); j++){
                    if(temp == list.get(j).type){
                        list.get(j).count += score;
                        break;
                    }
                }
            }            
        }

        // 점수 체크하기
        for(int i=0; i<list.size(); i+=2){
            // 앞에것이 더 큰 경우
            if(list.get(i).count > list.get(i+1).count){
                answer += list.get(i).type;
            }
            // 뒤에것이 더 큰 경우
            else if(list.get(i).count < list.get(i+1).count){
                answer += list.get(i+1).type;
            }
            // 같은 경우 ( 사전 순으로 )
            else{
                answer += list.get(i).type;
            }
        }


        return answer;
    }
}
}
