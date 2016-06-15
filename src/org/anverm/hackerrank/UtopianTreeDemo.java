package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UtopianTreeDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testCasesCount = Integer.parseInt(br.readLine());
			long[] answers = new long[testCasesCount];
			for (int i = 0; i < testCasesCount; i++) {
				int n = Integer.parseInt(br.readLine());
				answers[i] = calculateHeight(n);
			}
			for(int i = 0; i < answers.length; i++){
				System.out.println(answers[i]);
			}
		} catch (Exception e){
			
		}
	}
	
	private static long calculateHeight(int n){
		return (2 * (long)Math.pow(2, (n + 1)/2)) - (long)Math.pow(2, n % 2);
	}

}
