package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PairsDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nAndK = br.readLine();
			String[] nAndKSplit = nAndK.split(" ");
			int n = Integer.parseInt(nAndKSplit[0]);
			int k = Integer.parseInt(nAndKSplit[1]);
			String nums = br.readLine();
			String[] numsSplit = nums.split(" ");
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(numsSplit[i]));
			}
			
			int count = 0;
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()){
				int num = it.next();
				if(set.contains(num+k)){
					count++;
				}
			}
			System.out.println(count);
		} catch (Exception e){
			
		}

	}

}
