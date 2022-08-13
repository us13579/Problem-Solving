package PROGRAMMERS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PRO_92334 {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		int[] answer = new int[id_list.length];
		
		// 유저 ID / 신고한 유저 ID set
		Map<String,HashSet<String>> map = new HashMap<>();
		// 결과 Map
		Map<String,Integer> answerMap = new HashMap<>();
		
		// Map 초기화
		for(int i=0; i<id_list.length; i++) {
			HashSet<String> reportingId = new HashSet<>();
			map.put(id_list[i],reportingId);
			// 받은 메일수 0 개
			answerMap.put(id_list[i], 0);
		}
		
		// report 기록 넣기
		for(int i=0; i<report.length; i++) {
			String[] str = report[i].split(" ");
			// 신고한 ID
			String reportingId = str[0];
			// 신고 당한 ID
			String reportedId = str[1];
			// 신고된 유저가 Key 값이 되고 신고한 유저가 value 값이 된다.
			map.get(reportedId).add(reportingId);			
		}
		
		// 결과 설정
		for(String userId : map.keySet()) {
			// 신고한 유저 HashSet
			HashSet<String> reportingSet = map.get(userId);
			// 신고 횟수가 k 이상일 경우
			if(reportingSet.size()>=k) {
				// 신고한 사람들에게 메일 보내기
				for(String temp : reportingSet) {
					answerMap.put(temp, answerMap.get(temp)+1);
				}
			}
		}
		
		// answer 배열에 세팅
		for(int i=0; i<answer.length;i++) {
			answer[i] = answerMap.get(id_list[i]);
		}
		
	}
}
