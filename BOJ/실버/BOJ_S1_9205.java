package BOJ;

/***
 * @author us13579
 * @since 2022-04-14, 1시간
 * @title 맥주 마시면서 걸어가기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S1_9205 {

    static int N, sx, sy, dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        // 테스트 케이스
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {

            // 편의점 개수
            N = Integer.parseInt(br.readLine());

            // 편의점만 저장하는 배열
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 출발점
                if (i == 0) {
                    sx = x;
                    sy = y;
                }
                // 도착점
                else if (i == N + 1) {
                    dx = x;
                    dy = y;
                }
                // 편의점
                else {
                    list.add(new int[] {x,y});
                }
            }

            String str = "";
            if(bfs(list)){
                str = "happy";
            }
            else{
                str = "sad";
            }
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }

    // bfs
    static boolean bfs(List<int[]> list) {
        // 방문체크
        boolean[] v = new boolean[N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sx, sy});

        while (!q.isEmpty()) {
            int[] d = q.poll();
            // 현재 좌표 값
            int px = d[0];
            int py = d[1];

            // 마지막
            // 맥주가 남는 경우
            if (Math.abs(px - dx) + Math.abs(py - dy) <= 1000) {
                return true;
            }

            // 편의점 돌기
            for (int i = 0; i < N; i++) {
                // 방문 안한 경우
                if (!v[i]) {
                    // list에서 값 가져온다
                    int nx = list.get(i)[0];
                    int ny = list.get(i)[1];

                    // 거리 체크
                    // 맥주가 남는 경우
                    if (Math.abs(px - nx)  + Math.abs(py - ny) <= 1000) {
                        v[i] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
