package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {
	public static void main(String[] args) {
		long max = 0, x = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nAndM = br.readLine();
			String[] nAndMSplited = nAndM.split(" ");
			int n = Integer.parseInt(nAndMSplited[0]);
			int m = Integer.parseInt(nAndMSplited[1]);

			long[] arr = new long[n + 1];

			for (int i = 0; i < m; i++) {
				String aBAndK = br.readLine();
				String[] aBAndKSplited = aBAndK.split(" ");
				int a = Integer.parseInt(aBAndKSplited[0]);
				int b = Integer.parseInt(aBAndKSplited[1]);
				int k = Integer.parseInt(aBAndKSplited[2]);
				arr[a] += k;
				if ((b + 1) <= n) {
					arr[b + 1] -= k;
				}
			}

			for (int i = 0; i <= n; i++) {
				x = x + arr[i];
				if (max < x) {
					max = x;
				}
			}
			System.out.println(max);
		} catch (Exception e) {

		}
	}
}
