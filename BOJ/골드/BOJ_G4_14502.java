package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_14502 {

    public static class Dot {
        private int x;
        private int y;

        public Dot(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    // 4방향 탐색
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    // map
    static int[][] map;
    static int[][] mapCopy;
    // 최대값
    static int maxValue = 0;
    // 빈 공간 List -> 벽 넣을 수 있는 공간
    static List<Dot> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 가로 세로 크기 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        mapCopy = new int[N][M];

        // map 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 빈공간이면 List에 넣어주기
                if (map[i][j] == 0) {
                    list.add(new Dot(i, j));
                }
            }
        }

        inputWall(0,0);
        System.out.println(maxValue);

    }

    // 벽 입력하기 xC3
    // mapCopy[][] 에 벽 입력
    static void inputWall(int idx, int cnt) {
        // 3개 벽 다 넣었을 경우 바이러스 퍼뜨리기
        // 최댓값 계산
        if (idx == 3) {
            // 벽 넣은 map을 mapCopy로 복사
            copy();
            
            // 바이러스 퍼뜨리기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(mapCopy[i][j] == 2) {
                        dfs(i, j);
                    }
                }
            }

            // 안전영역 크기 구하기
            int size = size();
            // 최댓값 갱신
            maxValue = Math.max(maxValue, size);

            // map 초기화
            copy();
            return;
        }

        // 벽 놓기
        for(int i=cnt; i<list.size();i++){
            // 벽을 놓을 수 있는 x,y 좌표
            int x = list.get(i).x;
            int y = list.get(i).y;
            // 벽 놓기
            map[y][x] = 1;

            inputWall(idx+1, i+1);

            // 벽 빼기
            map[y][x] = 0;
        }
    }


    // 4방향 탐색을 통해 바이러스 퍼뜨리기
    // 1이거나 2이면 못가게 -> 어차피 완탐이라 상관 x
    static void dfs(int y, int x) {
        // 4방향 탐색
        int nx,ny;
        for(int i=0; i<4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            // 만약 범위를 초과한 경우 통과
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            // 만약 벽이거나 바이러스가 이미 있는 곳이면 통과
            if(mapCopy[ny][nx] == 1 || mapCopy[ny][nx] == 2) continue;
            
            // 바이러스 퍼뜨리기
            mapCopy[ny][nx] = 2;
            dfs(ny,nx);
        }

    }

    // 안전영역 크기 구하기
    static int size() {
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapCopy[i][j] == 0) size++;
            }
        }
        return size;
    }

    // 배열 복사
    // 벽을 3개 마음대로 놓고 바이러스 퍼뜨리고 최대값 갱신
    static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mapCopy[i][j] = map[i][j];
            }
        }
    }
}
