package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exam {

	public static void main(String[] args) {
		int [] answers = {1,2,3,4,5};
		
		//문제풀이 시작
		
		int n = answers.length;
		int[] person1_answer = new int[n];
		int [] person2_answer = new int[n];
		int [] person3_answer = new int[n];
		int person1cnt = 0;
		int person2cnt = 0;
		int person3cnt = 0;
		List<Integer> list = new ArrayList<>();
		//1. 1번사람 찍는 방식
		for(int i = 0; i<n;i++) {
			switch((i+1)%5){
			case 1 : person1_answer[i] = 1;
				break;
			case 2 : person1_answer[i] = 2;
			break;
			case 3 : person1_answer[i] = 3;
			break;
			case 4 : person1_answer[i] = 4;
			break;
			case 0 : person1_answer[i] = 5;
			break;
			}
			if(person1_answer[i]==answers[i]) {
				person1cnt++;
			}
		}
		System.out.println(Arrays.toString(person1_answer));
		
		//2. 2번 사람 찍는 방식;
		
		for(int i =0 ;i<n;i++) {
			switch((i+1)%2) {
			case 1 : person2_answer[i] = 2;
			break;
			case 0: 
				switch((i+1)%8) {
				case 2: person2_answer[i] = 1;
				break;
				case 4: person2_answer[i] = 3;
				break;
				case 6: person2_answer[i] = 4;
				break;
				case 0: person2_answer[i] = 5;
				break;
				}
			}
			if(person2_answer[i]==answers[i]) {
				person2cnt++;
			}
			
		}
		
		System.out.println(Arrays.toString(person2_answer));
		
		//3. 3번 찍는 사람 방식
		for(int i=0;i<n;i++) {
			switch((i+1)%10) {
			case 1: person3_answer[i] = 3;
			break;
			case 2: person3_answer[i] = 3;
			break;
			case 3: person3_answer[i] = 1;
			break;
			case 4: person3_answer[i] = 1;
			break;
			case 5: person3_answer[i] = 2;
			break;
			case 6: person3_answer[i] = 2;
			break;
			case 7: person3_answer[i] = 4;
			break;
			case 8: person3_answer[i] = 4;
			break;
			case 9: person3_answer[i] = 5;
			break;
			case 0: person3_answer[i] = 5;
			break;
			}
			if(person3_answer[i]==answers[i]) {
				person3cnt++;
			}
		}
		System.out.println(Arrays.toString(person3_answer));
		System.out.println(person3cnt);
		System.out.println(person2cnt);
		System.out.println(person1cnt);
		int max = max(person1cnt,person2cnt,person3cnt);
		if(person1cnt == max) {
			list.add(1);
		}
		if(person2cnt == max) {
			list.add(2);
		}
		if(person3cnt == max) {
			list.add(3);
		}
		//list 를 array로 바꿈
		int [] answer = list.stream().mapToInt(i->i).toArray();
		System.out.println(Arrays.toString(answer));
	}
	
	
	
	public static int max(int a, int b ,int c) {
		int max = a;
		if(b>max) {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		return max;

	}

}
