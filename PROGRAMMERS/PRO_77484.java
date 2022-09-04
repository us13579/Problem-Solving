package PROGRAMMERS;

public class PRO_77484 {
	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        
	        // 0의 개수 구하기
	        int cntZero = 0;
	        for(int i=0; i<lottos.length; i++)
	        {
	            if(lottos[i] == 0){
	                cntZero++;
	            }
	        }        
	        
	        // 기존 맞는 것들 구하기 ( 0제외 )
	        int cntSame=0;
	        for(int i=0; i<lottos.length; i++){
	            for(int j=0; j<win_nums.length;j++){
	                if(lottos[i] == win_nums[j]){
	                    cntSame++;
	                }
	            }
	        }
	        
	        // 최고점수
	        int highest =((cntSame + cntZero) < 2 ? 6 : 7-(cntSame+cntZero));
	        
	        
	        // 최저점수
	        int lowest = (cntSame < 2 ? 6 : 7-cntSame);
	        
	        answer[0] = highest;
	        answer[1] = lowest;
	       
	        
	        
	        return answer;
	    }
	}
}
