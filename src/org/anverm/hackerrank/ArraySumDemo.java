package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArraySumDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String chars = br.readLine();
			String[] nums = chars.split(" ");
			
			int sum = 0;
			for (int i = 0; (i < n) && (i < nums.length); i++) {
				sum += Integer.parseInt(nums[i]);
			}
			System.out.println(sum);
		} catch (Exception e){
			
		}
	}

}
