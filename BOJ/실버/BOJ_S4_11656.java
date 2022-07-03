package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/***
 * 
 * @author us13579
 * @since 220703
 * @title 접미사 배열 
 */

public class BOJ_S4_11656 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// **** input start ****
		
		String str = br.readLine();
		
		// **** input end ****		
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<str.length(); i++) {
			String temp = "";
			for(int j=i;j<str.length();j++) {
				temp += str.charAt(j);
			}
			list.add(temp);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	} // main end
} // class end
