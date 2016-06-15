package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiagonalDiffDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int diagSum = 0;
			int revDiagSum = 0;
			int n = Integer.parseInt(br.readLine());
//			int[][] matrix = new int[n][n];
			for(int row = 0; row < n; row++){
				String chars = br.readLine();
				String[] nums = chars.split(" ");
				for (int column = 0; column < n; column++) {
//					matrix[row][column] = Integer.parseInt(nums[column]);
					if(row == column){
						diagSum += Integer.parseInt(nums[column]);
					}
					
					if((row + column) == (n-1)){
						revDiagSum += Integer.parseInt(nums[column]);
					}
				}
			}
			
			if(diagSum > revDiagSum){
				System.out.println(diagSum - revDiagSum);
			} else {
				System.out.println(revDiagSum - diagSum);
			}
		} catch (Exception e){
			
		}
	}

}
