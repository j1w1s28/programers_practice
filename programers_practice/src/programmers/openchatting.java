package programmers;

import java.util.HashMap;
import java.util.Map;

public class openchatting {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		
		// 문제풀이 시작
		
		//1. id별 상태를 저장할 map ex) uid, muzi 
		Map<String,String> id_nickname = new HashMap<>();
		//2. 진행상황 저장할 map ex) 0, uid1234 enter
		Map<Integer,String> status = new HashMap<>();
		//3. 0번째 이벤트를 넣기위한 숫자
		int number = 0;
		//4. change 이벤트가 발생했을 때 해당 index만큼 땡기기 위해서 존재
		int count = 0;
		//5. answer의 길이를 측정하기 위해서 존재
		int length = 0;
		for(String rec : record) {
			String [] arr = rec.split(" ");
			if(arr.length>2) {
				id_nickname.put(arr[1], arr[2]);
			}
			status.put(number, arr[1]+" "+arr[0]);
			number++;
			if(!arr[0].equals("Enter")){
				length++;
			}
		}
		String[] answer = new String[length];
		for(int i =0;i<record.length;i++) {
			String result = status.get(i);
			String [] resultarr = result.split(" ");
			if(resultarr[1].equals("Enter")) {
				answer[i+count] = id_nickname.get(resultarr[0]) + "님이 들어왔습니다."; 
			}else if(resultarr[1].equals("Leave")) {
				answer[i+count] = id_nickname.get(resultarr[0]) + "님이 나갔습니다.";
			}else {
				count--;
			}
		}
	}

}
