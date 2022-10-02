package PROGRAMMERS;

import java.util.*;

public class PRO_Lv2_1844 {
    class Solution {
        public class Node{
            int x;
            int y;
            int cost;

            public Node(int x, int y, int cost){
                this.x = x;
                this.y = y;
                this.cost = cost;
            }

        }

        boolean[][] check;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n,m;


        public int solution(int[][] maps) {
            int answer = 0;

            n = maps.length;
            m = maps[0].length;
            check = new boolean[n][m];

            answer = bfs(maps,0,0);

            return answer;
        }

        public int bfs(int[][] maps, int x, int y){
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(x,y,1));
            check[y][x] = true;

            while(!q.isEmpty()){
                Node node = q.poll();
                if(node.x == m-1 && node.y == n-1) return node.cost;

                int nx = 0;
                int ny = 0;
                for(int i=0; i<4; i++){
                    nx = node.x + dx[i];
                    ny = node.y + dy[i];

                    // 만약 범위를 벗어나거나 벽이거나 이미 갔는 경우 통과
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || check[ny][nx] || maps[ny][nx] == 0) continue;

                    // 방문 처리
                    check[ny][nx] = true;
                    q.offer(new Node(nx,ny,node.cost+1));
                }
            }
            return -1;
        }
    }
}
