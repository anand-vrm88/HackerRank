package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IceCreamParlorDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testCasesCount = Integer.parseInt(br.readLine());
			String[] result = new String[testCasesCount];
			for (int i = 0; i < testCasesCount; i++) {
				int money = Integer.parseInt(br.readLine());
				int elementsCount = Integer.parseInt(br.readLine());
				String delimitedElems = br.readLine();
				String[] delimitedElemsSplited = delimitedElems.split(" ");
				int[] elemsArray = new int[elementsCount];
				for(int j = 0; j < elementsCount; j++){
					elemsArray[j] = Integer.parseInt(delimitedElemsSplited[j]);
				}
				result[i] = findIceCreamIndex(elemsArray, money);
			}
			for(String iceCreamIndex : result){
				System.out.println(iceCreamIndex);
			}
		} catch (Exception e){
			
		}
	}
	
	private static String findIceCreamIndex(int[] elemsArray, int money){
		for(int i = 0; i < elemsArray.length; i++){
			if(elemsArray[i] >= money){
				continue;
			}
			for(int j = i + 1; j < elemsArray.length; j++){
				if(elemsArray[i] + elemsArray[j] == money){
					return i + " " + j;
				}
			}
		}
		return "";
	}

}
