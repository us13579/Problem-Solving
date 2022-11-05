package PRO;

import java.util.*;

public class PRO_Lv3_49189 {
    class Solution {
        static ArrayList<Integer>[] map;
        static boolean[] visit;
        static int[] dist;
        static int max = Integer.MIN_VALUE;

        public int solution(int n, int[][] edge) {
            int answer = 0;

            // map 크기
            map = new ArrayList[n+1];

            // 방문처리
            visit = new boolean[n+1];

            // 거리
            dist = new int[n+1];

            // 각 list 만들어주기
            for(int i=1; i<=n; i++){
                map[i] = new ArrayList<>();
            }

            for(int i=0; i<edge.length; i++){
                int start = edge[i][0];
                int end = edge[i][1];

                map[start].add(end);
                map[end].add(start);
            }

            // 거리 측정
            bfs();

            int cnt = 0;
            for(int i=0; i<dist.length;i++){
                if(dist[i] == max) cnt++;
            }

            answer = cnt;
            return answer;
        }

        static void bfs(){
            Queue<Integer> q = new LinkedList<Integer>();
            // 처음 시작 좌표 처리
            q.add(1);
            visit[1] = true;
            dist[0] = 0;

            while(!q.isEmpty()){
                int num = q.poll();

                for(int i=0; i<map[num].size(); i++){
                    // 방문을 안했으면
                    if(!visit[map[num].get(i)]){
                        q.add(map[num].get(i));
                        visit[map[num].get(i)] = true;
                        dist[map[num].get(i)] = dist[num] +1;
                        max = Math.max(max,dist[map[num].get(i)]);
                    }
                }
            }
        }
    }
}
