package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S2_10164 {
    static int N,M, O;
    static int ox,oy;
    // 이동
    static int[] dx = {1,0};
    static int[] dy = {0,1};

    static int[][] map;
    static int cnt;

    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        // input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        O = Integer.parseInt(st.nextToken());

        // map
        map = new int[N][M];

        // map에 수 넣어주기
        int num = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = num;
                // 동그라미 좌표 저장
                if(O!=1 && num == O){
                    ox = j;
                    oy = i;
                }
                num++;
            }
        }

        list = new ArrayList<>();

        cnt =0;

        // 만약 O가 0이면 모든 경우의수 구해주면 된다
        if(O==0){
            O=M*N;
        }
            // dfs 실행
            dfs(0, 0);


        System.out.println(cnt);



    }

    public static void dfs(int x, int y){
        // 기저조건
        if(x==M-1 && y==N-1){
            // 만약 리스트에 O가 있을 경우 카운팅
            if(list.contains(O)){
                cnt++;
            }
            return;
        }

        // 이동
        for(int i=0; i<2; i++){
            int nx,ny;
            nx = dx[i] + x;
            ny = dy[i] + y;

            // 먼저 범위를 넘으면 통과
            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

            // 만약 동그라미 좌표보다 앞이거나 밑에 있으면 통과 -> 갈 필요가 없다
            if((nx<ox && ny>oy) || (nx>ox && ny<oy)) continue;

            // 리스트에 값 넣기
            list.add(map[ny][nx]);

            // dfs 실행
            dfs(nx, ny);

            // 백트래킹 ( 맨 뒤에 것 빼주기 )
            list.remove(list.size()-1);
        }
    }
}
