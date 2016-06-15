package projecteuler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));) {

			int noOfTestcases = Integer.parseInt(br.readLine());
			long[] numbers = new long[noOfTestcases];
			for (int i = 0; i < noOfTestcases; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < noOfTestcases; i++) {
				long num = numbers[i];
				long sum = sumDivisibility(3, num - 1) + sumDivisibility(5, num - 1) - sumDivisibility(15, num - 1);
				bw.write(sum + "\n");
				sum = 0;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static long sumDivisibility(int n, long p) {
		return (n * (p / n) * ((p / n) + 1)) / 2;
	}
	
	private void version1() throws Exception{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));) {

				int noOfTestcases = Integer.parseInt(br.readLine());
				int[] numbers = new int[noOfTestcases];
				for (int i = 0; i < noOfTestcases; i++) {
					numbers[i] = Integer.parseInt(br.readLine());
				}
				for (int i = 0; i < noOfTestcases; i++) {
					int num = numbers[i];
					int sum = 0;
					for (int threeMultiple = 3; threeMultiple < num; threeMultiple += 3) {
						sum += threeMultiple;
					}
					for (int fiveMultiple = 5; fiveMultiple < num; fiveMultiple += 5) {
						if ((fiveMultiple % 3) != 0) {
							sum += fiveMultiple;
						}
					}
					bw.write(sum + "\n");
					sum = 0;
				}
			} catch (Exception e) {
				throw e;
			}
	}
	
	public void version2() throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));) {

				int noOfTestcases = Integer.parseInt(br.readLine());
				int[] numbers = new int[noOfTestcases];
				for (int i = 0; i < noOfTestcases; i++) {
					numbers[i] = Integer.parseInt(br.readLine());
				}
				for (int i = 0; i < noOfTestcases; i++) {
					int num = numbers[i];
					int sum = 0;
					int nextMultipleThree = 3;
					int nextMultipleFive = 5;
					int nextNum = 0;
					while (nextNum < num) {
						if(nextMultipleFive == nextMultipleThree){
							nextNum = nextMultipleFive;
							nextMultipleFive += 5;
							nextMultipleThree += 3;
						} else if(nextMultipleFive < nextMultipleThree){
							nextNum = nextMultipleFive;
							nextMultipleFive += 5;
						} else {
							nextNum = nextMultipleThree;
							nextMultipleThree += 3;
						}
						if(nextNum < num){
							System.out.println(nextNum);
							sum += nextNum;
						}
					}
					bw.write(sum + "\n");
					sum = 0;
				}
			} catch (Exception e) {
				throw e;
			}
	}

}
