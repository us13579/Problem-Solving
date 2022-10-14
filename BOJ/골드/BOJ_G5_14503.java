package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14503 {

    static int N, M;
    static int[][] map;
    // 북, 동, 남, 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int res = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 좌표 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기값 입력
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(res);
    }

    public static void dfs(int y, int x, int d) {
        // 현재 위치 청소
        map[y][x] = -1;

        // 왼쪽방향부터 탐색
        for (int i = 0; i < 4; i++) {
            // 현재 방향에서 왼쪽으로
            d = (d + 3) % 4;
            // 북, 서, 남, 동 탐색
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 청소가 안된 곳이 있으면
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 0) {
                // 카운팅
                res++;
                dfs(ny, nx, d);

                // 리턴 안하면 뒤로 가서 다른 곳을 청소할 수 있음
                return;
            }
        }

            // 네 방향 모두 청소가 되어있거나 벽인 경우
            // 뒤돌기
            int back = (d + 2) % 4;
            int bx = x + dx[back];
            int by = y + dy[back];

            if (bx >= 0 && by >= 0 && bx < M && by < N && map[by][bx] != 1) {
                dfs(by, bx, d);
            }
        }
    }
