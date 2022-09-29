package PROGRAMMERS;

public class PRO_Lv2_87946 {
    class Solution {
        public boolean[] check;
        public int answer = 0;

        public int solution(int k, int[][] dungeons) {

            check = new boolean[dungeons.length];
            dfs(0,k,dungeons);
            return answer;
        }

        public void dfs(int depth, int k, int[][] dungeons){
            for(int i=0; i<dungeons.length; i++){
                // 이미 왔는 곳이면 통과
                if(check[i]) continue;
                // 최소 필요 피로도가 없으면 통과
                if(dungeons[i][0] > k) continue;

                // 방문 처리
                check[i] = true;
                dfs(depth+1,k-dungeons[i][1], dungeons);
                // 백트래킹
                check[i] = false;
            }

            answer = Math.max(answer,depth);
        }
    }
}
