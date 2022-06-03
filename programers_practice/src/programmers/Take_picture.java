package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Take_picture {

	public static void main(String[] args) {
		int n =2;
		String [] data = {"N~F=0", "R~T>2"};
		Boolean [] visited = new Boolean[8];
		
		//A, C, F, J, M, N, R, T 각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브
		//네 번째 글자는 다음 3개 중 하나이다. {=, <, >} 각각 같음, 미만, 초과를 의미한다.
		//다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
		
		//문제풀이 시작
		int totalcases = factorial(8);
		int [] distance = {0,1,2,3,4,5,6};
		Map<String, Object> conditions = new HashMap<>();
		Boolean error = false;
	
		//조건 map에 저장
		for(int i =0;i<data.length;i++) {
			String key = data[i].substring(0, 3);
			StringBuffer sb = new StringBuffer(key);
			String[] value = satisfiednumarr(data[i].substring(3));
			String reversekey= sb.reverse().toString();
			if(conditions.containsKey(key) || conditions.containsKey(reversekey)) {
				if(conditions.containsKey(key) == true) {
					String[] arr = (String[]) conditions.get(key);
					String[] intersection = intersection(arr, value);
					if(intersection.length==0) {
						error = true;
						break;
					}else {
						conditions.put(key, value);
					}
					
				}
				else if(conditions.containsKey(reversekey)==true) {
					String [] arr = (String[]) conditions.get(reversekey);
					String[] intersection = intersection(arr, value);
					if(intersection.length==0) {
						error = true;
						break;
					}else {
						conditions.put(reversekey, value);
					}
				}
			}else {
				conditions.put(key, value);
			}
		}
		
		//조건 출력
		conditions.forEach((a,b)->{
			String [] arrr = (String[]) b;
			System.out.println(a+":"+Arrays.toString(arrr));
		});
		System.out.println(error);
		System.out.println(Arrays.toString(visited));


	}

	public static int factorial(int num) {
		if(num<=1) {
			return num;
		}else {
			return factorial(num-1)*num;
		}
	}
	
	public static String [] satisfiednumarr(String condition) {
		char sign = condition.charAt(0);
		String satisfiednums1 ="";
		switch(sign) {
		case '=' : satisfiednums1 = condition.substring(1);
		break;
		case '>' : for(int i=Integer.parseInt(condition.substring(1))+1;i<7;i++) {
			satisfiednums1 = satisfiednums1 +";" + Integer.toString(i);
		}
		break;
		
		case '<' : for(int i =0;i<Integer.parseInt(condition.substring(1));i++) {
			satisfiednums1 = satisfiednums1 +";" + Integer.toString(i);
		}
		break;
		}
		String [] arr = satisfiednums1.replaceFirst(";", "").split(";");
		return arr;
	}
	public static String[] intersection(String[] arr, String[] arr2) {
		Set<String> set1 = new HashSet<String>(Arrays.asList(arr));
		Set<String> set2 = new HashSet<String>(Arrays.asList(arr2));
		set1.retainAll(set2);
		String [] result = set1.toArray(new String[0]);
		return result;
	}
}
