package programmers;

import java.util.Arrays;

public class dartgame {

	public static void main(String[] args) {
		String dartResult ="1D2S3T*";
		int answer=0;
		//문제 풀이 시작
		int n = dartResult.length();
		int [] resultarr = new int [3];
		int cnt = 0;
		System.out.println(dartResult.charAt(5));

		for(int i=0;i<n;i++) {
			if(Character.isDigit(dartResult.charAt(i)) && Character.isDigit(dartResult.charAt(i+1))) {
				resultarr[cnt] = 10;
				cnt++;
				i++;
			}else if(Character.isDigit(dartResult.charAt(i))){
				resultarr[cnt] = Character.getNumericValue(dartResult.charAt(i));
				cnt++;
			}else {
				switch(dartResult.charAt(i)) {
				//character 는 '' 사용해야함
				case 'S':resultarr[cnt-1] = (int) Math.pow(resultarr[cnt-1], 1);
				break;
				case 'D':resultarr[cnt-1] = (int) Math.pow(resultarr[cnt-1], 2);
				break;
				case 'T':resultarr[cnt-1] = (int) Math.pow(resultarr[cnt-1], 3);
				break;
				case '*':
						resultarr[cnt-1] *= 2;
						if(cnt>1) {
							resultarr[cnt-2] *= 2;
						}
				break;
				case '#':
						resultarr[cnt-1] *= -1;
					break;
				}
			}		
		}

		for(int num:resultarr) {
			answer += num;
		}
		System.out.println(Arrays.toString(resultarr));
		System.out.println(answer);
	}

}


