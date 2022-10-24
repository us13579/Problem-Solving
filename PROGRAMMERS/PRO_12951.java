package PROGRAMMERS;

public class PRO_12951 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            StringBuffer sb = new StringBuffer();

            // 소문자로 다 바꿔주기
            s = s.toLowerCase();
            // 첫글자 대문자로 넣어주기
            sb.append(Character.toUpperCase(s.charAt(0)));
            for(int i=1; i<s.length(); i++){
                // 만약 빈칸인 경우
                if(s.charAt(i) == ' ') sb.append(" ");
                    // 빈칸 다음 첫글자 -> 대문자
                else if(s.charAt(i-1) == ' ') sb.append(Character.toUpperCase(s.charAt(i)));
                else sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}
