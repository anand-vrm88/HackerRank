package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BoardCuttingDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int numberOfTestInputs = Integer.parseInt(br.readLine());
			
			List<TestInput> testInputs = new LinkedList<TestInput>();
			for(int i = 0; i < numberOfTestInputs; i++){
				String mAndN = br.readLine();
				String[] mAndNSplited = mAndN.split(" ");
				int m = Integer.parseInt(mAndNSplited[0]);
				int n = Integer.parseInt(mAndNSplited[1]);
				String yInput = br.readLine();
				String xInput = br.readLine();
				
				String[] yInputSplited = yInput.split(" ");
				String[] xInputSplited = xInput.split(" ");
				
				List<Cut> yCosts = new LinkedList<Cut>();
				List<Cut> xCosts = new LinkedList<Cut>();
				
				for(int j = 0; j < m-1; j++){
					yCosts.add(new Cut(Orientation.Y, Integer.parseInt(yInputSplited[j])));
				}
				
				for(int j = 0; j < n-1; j++){
					xCosts.add(new Cut(Orientation.X, Integer.parseInt(xInputSplited[j])));
				}
				
				Map<Orientation, List<Cut>> costs = new HashMap<Orientation, List<Cut>>();
				costs.put(Orientation.Y, yCosts);
				costs.put(Orientation.X, xCosts);
				
				testInputs.add(new TestInput(m, n, costs));
			}
			
			for(TestInput testInput : testInputs){
				Map<Orientation, List<Cut>> costs = testInput.getCosts();
				List<Cut> allCosts = new LinkedList<Cut>();
				allCosts.addAll(costs.get(Orientation.Y));
				allCosts.addAll(costs.get(Orientation.X));
				Collections.sort(allCosts);
				
				System.out.println(calculateBoardCuttingCost(allCosts));
			}
			
			String chars = br.readLine();
			String[] nums = chars.split(" ");
			
			int sum = 0;
			for (int i = 0; (i < numberOfTestInputs) && (i < nums.length); i++) {
				sum += Integer.parseInt(nums[i]);
			}
			System.out.println(sum);
		} catch (Exception e){
			
		}

	}
	
	private static long calculateBoardCuttingCost(final List<Cut> allCosts){
		long boardCuttingCost = 0;
		List<Cut> yCosts = new LinkedList<Cut>();
		List<Cut> xCosts = new LinkedList<Cut>();
		for(Cut cut : allCosts){
			if (cut.getOrien() == Orientation.Y) {
				boardCuttingCost += (long)cut.getCost() * (xCosts.size() + 1);
				yCosts.add(cut);
			} else {
				boardCuttingCost += (long)cut.getCost() * (yCosts.size() + 1);
				xCosts.add(cut);
			}
		}
		return boardCuttingCost % (long)(Math.pow(10,9)+7);
	}

	enum Orientation {
		X, Y
	}
	
	private static class Cut implements Comparable<Cut>{
		private Orientation orien;
		private int cost;
		
		@Override
		public int compareTo(Cut o) {
			return o.getCost() - this.cost;
		}

		public Cut(Orientation orien, int cost) {
			super();
			this.orien = orien;
			this.cost = cost;
		}

		public Orientation getOrien() {
			return orien;
		}

		public int getCost() {
			return cost;
		}
		
	}

	private static class TestInput {
		private int m;
		private int n;
		private Map<Orientation, List<Cut>> costs = new HashMap<Orientation, List<Cut>>();
		
		public TestInput(int m, int n, Map<Orientation, List<Cut>> costs) {
			super();
			this.m = m;
			this.n = n;
			this.costs = costs;
		}

		public int getM() {
			return m;
		}

		public int getN() {
			return n;
		}

		public Map<Orientation, List<Cut>> getCosts() {
			return costs;
		}
		
	}
}
