package programmers;

import java.util.Arrays;

public class workout_clothes {

	public static void main(String[] args) {
		int n = 5; 
		int[] lost = {2, 4};
		int[] reserve = {3,1};
		int answer =0;
		//결과 5나와야함

		// 풀이시작 
		Arrays.sort(lost);
		Arrays.sort(reserve);
		answer = n;
		int [] narray= new int [n];
		boolean [] check = new boolean [n];

		//1. 한개씩 가져옴
		for(int i =0;i<n;i++) {
			narray[i] += 1;
		}

		//2.도둑맞음
		for(int i = 0;i<lost.length;i++) {
			narray[lost[i]-1] -= 1;
		}

		//3. 여분 가져옴

		for(int i=0;i<reserve.length;i++) {
			narray[reserve[i]-1] += 1;
		}
		System.out.println(Arrays.toString(narray));
		//4. 여분과 잃어버린 사람 중복되는지 체크 

		if(lost.length>reserve.length) {
			for(int i =0;i<lost.length;i++) {
				for(int j =0;j<reserve.length;j++) {
					if(lost[i] == reserve[j]) {
						check[lost[i]-1] = true;
					}
				}
			}
		}else {
			for(int i =0;i<reserve.length;i++) {
				for(int j =0;j<lost.length;j++) {
					if(reserve[i] == lost[j]) {
						check[reserve[i]-1] = true;
					}
				}
			}
		}

		//check와 비교해서 false인 경우 만 실행

		for(int i = 0; i<n;i++) {
			if(!check[i]) {
				if(i<reserve.length) {
					if(reserve[i]==1) {
						if(narray[reserve[i]]==0 && narray[reserve[i]-1] == 2) {
							narray[reserve[i]] += 1;
							narray[reserve[i]-1] -= 1;
						}
					}else if(reserve[i]==n) {
						if(narray[reserve[i]-2]==0 && narray[reserve[i]-1] == 2) {
							narray[reserve[i]-2] += 1;
							narray[reserve[i]-1] -= 1;
						}
					}else {
						if(narray[reserve[i]-2]==0 && narray[reserve[i]-1] == 2) {
							narray[reserve[i]-2] += 1;
							narray[reserve[i]-1] -= 1;
						}else if(narray[reserve[i]]==0 && narray[reserve[i]-1] == 2) {
							narray[reserve[i]] += 1;
							narray[reserve[i]-1] -= 1;
						}
					}
				}
			}			
		}
		for(int i=0;i<n;i++) {
			if(narray[i]==0) {
				answer --;
			}
		}
		System.out.println(Arrays.toString(narray));
		System.out.println(Arrays.toString(check));
		System.out.println(answer);
	}
}