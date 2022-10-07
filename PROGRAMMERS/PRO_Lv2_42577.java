package PROGRAMMERS;

public class PRO_Lv2_42577 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            // HashMap 선언
            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<phone_book.length; i++){
                map.put(phone_book[i], i);
            }

            // 모든 전화번호를 돌면서 포함되어 있는지 확인
            for(int i=0; i<phone_book.length; i++){
                for(int j=0; j<phone_book[i].length(); j++){
                    if(map.containsKey(phone_book[i].substring(0,j)))
                        return false;
                }
            }

            return answer;
        }
    }
}
