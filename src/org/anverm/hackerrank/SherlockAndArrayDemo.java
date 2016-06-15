package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SherlockAndArrayDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testCasesCount = Integer.parseInt(br.readLine());
			int[] result = new int[testCasesCount];
			for (int i = 0; i < testCasesCount; i++) {
				int elementsCount = Integer.parseInt(br.readLine());
				String delimitedElems = br.readLine();
				String[] delimitedElemsSplited = delimitedElems.split(" ");
				int[] elemsArray = new int[elementsCount];
				for(int j = 0; j < elementsCount; j++){
					elemsArray[j] = Integer.parseInt(delimitedElemsSplited[j]);
				}
				result[i] = findPartitionIndex(elemsArray);
			}
			for(int partitionIndex : result){
				System.out.println(partitionIndex != 0 ? "YES" : "NO");
			}
		} catch (Exception e){
			
		}
	}
	
	//Main Algorithm
	private static int findPartitionIndex(int[] elemsArray){
		if(elemsArray.length == 1){
			return 1;
		}
		long leftSum = 0;
		long rightSum = 0;
		int leftIndex = 0;
		int rightIndex = elemsArray.length - 1;
		while((leftIndex + 1) < rightIndex){
			if((leftSum + elemsArray[leftIndex]) == (rightSum + elemsArray[rightIndex])){
				leftSum += elemsArray[leftIndex];
				rightSum += elemsArray[rightIndex];
				leftIndex++;
				rightIndex--;
			} else if((leftSum + elemsArray[leftIndex]) < (rightSum + elemsArray[rightIndex])){
				leftSum += elemsArray[leftIndex];
				leftIndex++;
			} else {
				rightSum += elemsArray[rightIndex];
				rightIndex--;

			}
			
			if((leftSum == rightSum) && (leftIndex == rightIndex)){
				return leftIndex;
			}
		}
		return 0;
	}

}
