package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MissingNumbersDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			String nArray = br.readLine();
			String[] nArraySplited = nArray.split(" ");
			int m = Integer.parseInt(br.readLine());
			String mArray = br.readLine();
			String[] mArraySplited = mArray.split(" ");
			Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
			for(int i = 0; i < n; i++){
				Integer nNum = Integer.parseInt(nArraySplited[i]);
				Integer frequency = cache.get(nNum);
				if(frequency == null){
					frequency = new Integer(0);
				}
				cache.put(nNum, frequency + 1);
			}
			
			for(int i = 0; i < m; i++){
				Integer mNum = Integer.parseInt(mArraySplited[i]);
				Integer frequency = cache.get(mNum);
				if(frequency == null){
					frequency = new Integer(0);
				}
				cache.put(mNum, frequency - 1);
			}
			
			List<Integer> missingNumbers = new LinkedList<Integer>();
			Iterator<Entry<Integer, Integer>> it = cache.entrySet().iterator();
			while(it.hasNext()){
				Entry<Integer, Integer> entry = it.next();
				if(entry.getValue() != 0){
					missingNumbers.add(entry.getKey());
				}
			}
			
			Collections.sort(missingNumbers);

			for(Integer missingNum : missingNumbers){
				System.out.print(missingNum + " ");
			}
		} catch (Exception e){
			
		}

	}

}
