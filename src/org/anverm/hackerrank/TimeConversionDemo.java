package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TimeConversionDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String time = br.readLine();
			StringBuilder sb = new StringBuilder();
			String[] timeComponents = time.split(":");
			int hour = Integer.parseInt(timeComponents[0]);
			if(time.endsWith("PM")){
				if(hour != 12){
					timeComponents[0] = new Integer(hour += 12).toString();
				}
			} else {
				if(hour == 12){
					timeComponents[0] = "00";
				}
			}
			sb.append(timeComponents[0]+":"+timeComponents[1]+":"+timeComponents[2].substring(0, 2));
			System.out.println(sb.toString());
		} catch (Exception e){
			
		}
	}

}
