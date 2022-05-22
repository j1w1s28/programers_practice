package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class case_of_queries {


	public static void main(String[] args) {
		int [] a = {2,1,2};
		int q = 2;

		// 문제 풀이 시작
		int n = a.length;
		int maxnumber = Arrays.stream(a).max().getAsInt(); 
		//1. 가능한 쿼리 수 
		int querycnt =0;
		for(int i=0;i<n;i++) {
			querycnt += (n-i) * maxnumber;
		}
		System.out.println(querycnt);

		//2. 총 쿼리 경우의 수 
		int totalcases = (int) Math.pow(querycnt, q);
		System.out.println(totalcases);
		//쓸모 없는 쿼리 경우의 순
		int uselesscases = 0;

		// 3. 각 인덱스를 만들 수 잇는 쿼리의 수 (재귀함수를 활용한 메소드를 써야함)
		Map<Integer, Integer> makeindexcnt = new HashMap<>();
	}
	//3.  각 인덱스를 만드는 쿼리수 
	public static int getcases(int [] array, int result , int index, int equalcnt) {
		int n = array.length;
		int maxnumber = Arrays.stream(array).max().getAsInt();
		for(int i = index; index<n; index++) {
			if(array[i]<maxnumber) {
				result += (n-i)*array[i];
			}else if(i<n-1 && array[i] == array[i+1]) {
				//가장 큰 값이 연속 된 경우 재귀함수로 보내서 만족하는 쿼리 결과수를 재 산정해야한다.
				equalcnt ++;
				getcases(array,result,i,equalcnt);
			}
		}
		return result;
	}


}
