package PRO;

import java.util.*;

public class PRO_LV2_86971 {
    class Solution {
        static int[][] map;
        static boolean[][] v;
        public int solution(int n, int[][] wires) {
            int answer = -1;

            map = new int[n][n];


            for(int i=0; i<wires.length; i++){
                int start = wires[i][0] -1;
                int end = wires[i][1] -1;

                map[start][end] = 1;
                map[end][start] = 1;
            }

            int min = Integer.MAX_VALUE;

            for(int i=0; i<wires.length; i++){
                int start = wires[i][0] -1;
                int end = wires[i][1] -1;

                map[start][end] = 0;
                map[end][start] = 0;

                min = Math.min(min, bfs(start, n));
                map[start][end] = 1;
                map[end][start] = 1;
            }


            answer = min;
            return answer;
        }

        static int bfs(int start, int n){
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            int cnt = 1;
            v = new boolean[n][n];

            while(!q.isEmpty()){
                int point = q.poll();
                for(int i=0; i<n; i++){
                    if(map[point][i] == 1 || map[i][point] == 1){
                        if(!v[i][point] && !v[point][i]){
                            cnt++;
                            v[i][point] = true;
                            v[point][i] = true;
                            q.add(i);
                        }
                    }
                }
            }
            return Math.abs(cnt - (n-cnt));
        }
    }
}
