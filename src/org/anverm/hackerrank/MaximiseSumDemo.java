package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximiseSumDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testCasesCount = Integer.parseInt(br.readLine());
			long[] result = new long[testCasesCount];
			for (int i = 0; i < testCasesCount; i++) {
				String arraySizeAndModulo = br.readLine();
				String[] arraySizeAndModuloSplit = arraySizeAndModulo.split(" ");
				int arraySize = Integer.parseInt(arraySizeAndModuloSplit[0]);
				int modulo = Integer.parseInt(arraySizeAndModuloSplit[1]);
				String delimitedElems = br.readLine();
				String[] delimitedElemsSplited = delimitedElems.split(" ");
				int[] elemsArray = new int[arraySize];
				for(int j = 0; j < arraySize; j++){
					elemsArray[j] = Integer.parseInt(delimitedElemsSplited[j]);
				}
				result[i] = findMaxSumIndex(elemsArray, modulo);
			}
			for(long iceCreamIndex : result){
				System.out.println(iceCreamIndex);
			}
		} catch (Exception e){
			
		}
	}
	
	private static long findMaxSumIndex(int[] elemsArray, int modulo) {
		long maxSum = 0;
		for (int i = 0; i < elemsArray.length; i++) {
			long max = elemsArray[i];
			for (int j = i + 1; j < elemsArray.length; j++) {
				if (max < ((max + elemsArray[j]) % modulo)) {
					max = ((max + elemsArray[j]) % modulo);
				}
			}
			if (maxSum < (max % modulo)) {
				maxSum = max % modulo;
			}
		}
		return maxSum % 500000;
	}

}
