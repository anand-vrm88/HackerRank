package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindDigitsDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testCasesCount = Integer.parseInt(br.readLine());
			long[] answers = new long[testCasesCount];
			for (int i = 0; i < testCasesCount; i++) {
				int n = Integer.parseInt(br.readLine());
				answers[i] = calculateDigitsCount(n);
			}
			for(int i = 0; i < answers.length; i++){
				System.out.println(answers[i]);
			}
		} catch (Exception e){
			
		}
	}
	
	private static int calculateDigitsCount(int n){
		int m = n;
		int count = 0;
		int msb = 0;
		while(m != 0){
			msb = m % 10;
			if(msb != 0 &&  ((n % msb) == 0)){
				count++;
			}
			m /= 10;
		}
		return count;
	}

}
