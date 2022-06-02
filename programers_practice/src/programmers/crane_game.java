package programmers;

import java.util.Arrays;

public class crane_game {

	public static void main(String[] args) {
		int [][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
				};
		int [] moves = {1,5,3,5,1,2,1,4,3};
		int answer = 0;
		//문제풀이 시작
		int number = board.length;
		int [] answerarr = new int[moves.length]; 
		
		for(int i=0;i<moves.length;i++) {
			for(int j =0;j<number;j++) {
				if(board[j][moves[i]-1]!=0) {
					answerarr[i-(answer)] = board[j][moves[i]-1];
					board[j][moves[i]-1] = 0;
					if(i-answer>0) {
						if(answerarr[i-(answer)-1] == answerarr[i-(answer)] && answerarr[i-(answer)] !=0) {
							answer+=2;
						}
					}
					
					break;
				} 
			}
		}
		
		
		System.out.println(Arrays.toString(answerarr));
		System.out.println(answer);

	}

}
