package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-03-24, 20분
 * @title 색종이 만들기
 */

public class BOJ_S3_2630 {
    static StringTokenizer st;
    static int[][] arr;
    static int zero,one;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 종이 크기
        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0 으로 초기화
        zero = 0;
        one = 0;

        go(0,0,N);

        sb.append(zero).append("\n");
        sb.append(one);

        System.out.println(sb);
    }

    static void go(int row, int col, int size){
        // 다 똑같으면
        if(check(row, col, size)){
            // 같은 값이 0 일때
            if(arr[row][col] == 0){
                zero++;
            }
            // 같은 값이 1 일때
            else{
                one++;
            }
            return;
        }
        // 다르면 재귀
        else{
            size /= 2;

            // 왼쪽 위
            go(row,col,size);

            // 오른쪽 위
            go(row,col+size,size);

            // 왼쪽 아래
            go(row+size,col,size);

            // 오른쪽 아래
            go(row+size,col+size,size);
        }
    }


    // 같은 수 인지 아닌지 검사
    static boolean check(int row, int col, int size){

        int first = arr[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(arr[i][j] != first){
                    return false;
                }
            }
        }
        return true;
    }
}
