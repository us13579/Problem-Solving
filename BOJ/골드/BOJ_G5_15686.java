package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_15686 {
    static class Dot{
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N,M;
    static int[][] map;
    static ArrayList<Dot> mList;
    static ArrayList<Dot> cList;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cList = new ArrayList<>();
        mList = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 치킨집인 경우 리스트에 담기
                if(map[i][j] == 2) cList.add(new Dot(j,i));
            }
        }

        // 조합
        Comb(0,0);
        System.out.println(min);

    }

    // 조합
    static void Comb(int idx, int start){
        // 기저조건
        if(idx == M){
            // 최소 도시 치킨 거리 구하기
            min = Math.min(chLength(), min);
            return;
        }

        for(int i=start; i<cList.size(); i++){
            // M개 선택된 리스트에 좌표 추가하기
            mList.add(cList.get(i));
            Comb(idx+1, i+1);
            // 기저조건
            mList.remove(mList.size()-1);
        }
    }

    // 최소 도시 치킨 거리 구하기
    static int chLength(){
        // 도시 치킨 거리
        int sum = 0;

        // 전체 돌면서 1일 때 계산해주기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 만약 집인 경우
                if(map[i][j] == 1){
                    // 가장 짧은 치킨 거리
                    int chickenLength = Integer.MAX_VALUE;
                    // M 만큼 돌면서 길이 체크
                    for(int z=0;z<mList.size();z++){
                        // 치킨집 좌표
                        int x = mList.get(z).x;
                        int y = mList.get(z).y;

                        // 좌표 계산
                        int length = Math.abs(x-j)+ Math.abs(y-i);
                        // 최솟값 구하기
                        chickenLength = Math.min(chickenLength, length);
                    }
                    // 가장 짧은 치킨 거리 더하기
                    sum += chickenLength;
                }
            }
        }
        return sum;
    }
}
