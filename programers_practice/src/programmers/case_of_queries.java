package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class case_of_queries {


	public static void main(String[] args) {
		int [] a = {1,6,5,2,4};
		int q = 50;
		int answer = 0;
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
		//System.out.println(getcases(a,0,0,0));
		//System.out.println("2번째 인덱스만드는 경우의수 : "+getcases(a,0,1,0));
		for(int i =0;i<n;i++) {
			makeindexcnt.put(i, getcases(a,0,i,0));
		}
		System.out.println("0번째 인덱스 만드는 쿼리 수" + makeindexcnt.get(0));
		System.out.println("1번째 인덱스 만드는 쿼리 수" + makeindexcnt.get(1));
		System.out.println("2번째 인덱스 만드는 쿼리 수" + makeindexcnt.get(2));
		//4. 조합 출력하기
		boolean [] visited = new boolean[n];
		//4-1. 조합 경우의수를 담을 arraylist 
		List<int[]> result = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			result = combination(result,a,visited,0,n,i,i);
		}
		
		for(int [] abc : result) {
			System.out.println(Arrays.toString(abc));
		}
		//4-2 uselessccases에 조합 경우의수 arr를 활용해서 구하기
		for(int [] abc : result) {
			int casenum = 0;
			if(abc.length%2==1) {
				//홀수개수면 더하고
				for(int num : abc) {
					casenum += makeindexcnt.get(num);
				}
				System.out.println("홀수개일때"+casenum);
				uselesscases+=(int)Math.pow(querycnt-casenum, q);
			}else {
				//짝수개수이면 빼주고
				for(int num : abc) {
					casenum += makeindexcnt.get(num);
				}
				System.out.println("짝수개일때"+casenum);
				uselesscases -=(int)Math.pow(querycnt-casenum, q);
			}
		}
		System.out.println(uselesscases);
		answer = (totalcases - uselesscases)%998244353;
		System.out.println(answer);
	}

	
	
	//3.  각 인덱스를 만드는 쿼리수 
	public static int getcases(int [] array, int result , int index, int equalcnt) {
		int n = array.length;
		int maxnumber = Arrays.stream(array).max().getAsInt();
			if(array[index]<maxnumber) {
				result += (n-index);
			}else if(index<n-1 && array[index] == array[index+1]) {
				//가장 큰 값이 연속 된 경우 재귀함수로 보내서 만족하는 쿼리 결과수를 재 산정해야한다.
				equalcnt ++;
				return getcases(array,equalcnt,index+1,equalcnt);
			}else {
				// 더 이상 가장 큰 값이 연속되지 않을 때 equalcnt가 연속된 횟수
				result += 1;
				return result;
			}
			return result;
	}
	//4_a) 쓸모없는 쿼리 교집합 파악하기위해서 조합 값 출력
	public static int combinationcnt(int n,int r) {
		if(n==r || r==0) {
			return 1;
		}else {
			return combinationcnt(n-1,r-1)+combinationcnt(n-1, r);
		}
		
	}
	//4_b) 조합 구하기(진짜로 뽑아진 애들의 index값)
	public static List<int[]> combination(List<int[]> result,int[] arr, boolean[] visited, int index, int n, int r,int arrnum) {
		if(r==0) {
			result.add(print(arr,visited,n,arrnum));
			return result;
		}
		for(int i = index;i<n;i++) {
			visited[i] = true;
			combination(result,arr,visited,i+1,n,r-1,arrnum);
			visited[i] = false;
		}
		return result;
		
	}
	//4_C) 조합 뽑기
	public static int[] print(int[]arr,boolean[]visited,int n,int arrnum) {
		int [] resultarr = new int[arrnum];
		int cnt = 0;
		for(int i =0; i<n; i++) {
			if(visited[i]) {
				System.out.print(arr[i] + " ");
				resultarr[cnt] = i;
				cnt++;
			}
		}
		System.out.println(Arrays.toString(resultarr));
		return resultarr;
	}
}
