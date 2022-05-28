package PROGRAMMERS;

import java.util.*;

public class PRO_42839 {
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] v;
    public static void main(String[] args) {
        Solution sol = new Solution();
        int cnt = sol.solution("17");
        System.out.println(cnt);
    }

    public static class Solution {
        public int solution(String numbers) {
            int answer = 0;

            // 각 문자열 저장
            arr = new char[numbers.length()];
            // 사용여부 저장
            v = new boolean[numbers.length()];

            for (int i = 0; i < numbers.length(); i++) {
                arr[i] = numbers.charAt(i);
            }

            // 실행
            recursion("", 0);

            // 결과 ( set 크기 )
            answer = set.size();
            return answer;
        }

        // 재귀
        // 가능한 숫자 조합을 찾는다
        // 소수인지 아닌지에 따라 set에 추가
        public void recursion(String str, int idx) {
            int num;
            // 기저조건
            // 값이 있으면 체크
            if (str != "") {
                // String을 Integer로 바꿔주기
                num = Integer.parseInt(str);
                // 소수이면 set에 추가
                if (check(num)) set.add(num);
            }

            if (idx == arr.length) return;

            for (int i = 0; i < arr.length; i++) {
                // 이미 사용한 것이면 통과
                if (v[i]) continue;
                // 사용 처리
                v[i] = true;
                // 재귀
                recursion(str + arr[i], idx + 1);
                // 백트래킹
                v[i] = false;
            }
        }


        // 에라토스테네스의 채 활용해서 소수 구하기
        // 소수이면 true, 아니면 false
        public boolean check(int n) {
            // 0,1 은 소수가 아니다
            if (n == 0 || n == 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                // 나누어떨어지면 소수가 아니다
                if (n % i == 0) return false;
            }

            // 위에 포함되지 않으면 소수
            return true;
        }
    }
}
