package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	
	arr = new int[n][n];
	
	for (int i = 0; i < n; i++) {
		String str = br.readLine();
		for (int j = 0; j < n; j++) {
			arr[i][j] = str.charAt(j)-'0';
		}
	}
		
	quardTree(0,0,n);	
	System.out.println(sb.toString());
	}

	private static void quardTree(int row, int col, int size) {
		System.out.println(row+" "+col+" "+size);
		boolean check = false;
		int idx = arr[row][col];
		
		for (int i = row; i < row+size; i++) {
			for (int j = col; j < col+size; j++) {
				if(arr[i][j]!= idx) {
					check = true;
					break;
				}
			}
		}
		
		if(!check) {
			sb.append(idx);
			return;
		}
		sb.append("(");
		size=size/2;
		quardTree(row,col,size);
		quardTree(row,col+size,size);
		quardTree(row+size,col,size);
		quardTree(row+size,col+size,size);
		sb.append(")");
	}
}