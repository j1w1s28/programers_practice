package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stirngs_as_i_wish {

	public static void main(String[] args) {
		String [] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		//문제풀이 시작
		List<String> answer2 = new ArrayList<>();
		List<String> resultwords = new ArrayList<>();
		String [] arr = new String[strings.length];
		Map<String, Object> map = new HashMap<>();
		for(int i =0;i<strings.length;i++) {
			List<String> duplicatewords = new ArrayList<>();
			arr[i] = strings[i].substring(n,n+1);
			if(map.containsKey(arr[i])) {
				duplicatewords = (List<String>) map.get(arr[i]);
				duplicatewords.add(strings[i]);
				map.put(arr[i], duplicatewords);
			}else {
				duplicatewords.add(strings[i]);
				map.put(arr[i], duplicatewords);
			}
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for(int i =0;i<arr.length;i+=0) {
			resultwords = (List<String>) map.get(arr[i]);
			Collections.sort(resultwords);
			System.out.println(i);
			for(String result : resultwords) {
				answer2.add(result);
			}
			i += resultwords.size();
		}
		String [] answer = answer2.toArray(new String[strings.length]);
		System.out.println(Arrays.toString(answer));
	}

}
