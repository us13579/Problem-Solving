package BOJ;

import java.io.IOException;
import java.util.Scanner;

/***
 * @author us13579
 * @since 2022-03-19, 2시간
 * @title 리모컨
 */

public class BOJ_G5_1107 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 채널
        int N = sc.nextInt();

        // 고장난 버튼 개수
        int M = sc.nextInt();

        // 고장난 버튼
        boolean[] num = new boolean[10];

        for(int i=0; i<M; i++){
            int temp = sc.nextInt();
            // 고장난 버튼은 true
            num[temp] = true;
        }

        // 초기값 설정
        int result = Math.abs(N - 100);
        for(int i=0; i <= 999999; i++){
            String str = String.valueOf(i);
            int length = str.length();

            boolean isChecked = false;

            for(int j=0;j<length;j++){
                // 고장난 버튼이라면
                if(num[str.charAt(j) -'0']){
                    isChecked = true;
                    break;
                }
            }
            // 고장난 버튼이 없으면
            if(!isChecked) {
                int min = Math.abs(N - i) + length;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
