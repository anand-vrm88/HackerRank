package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ConnectedCellInGridDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int rowsCount = Integer.parseInt(br.readLine());
			int columnsCount = Integer.parseInt(br.readLine());
			int[][] matrix = new int[rowsCount][columnsCount];
			for(int i = 0; i < rowsCount; i++){
				String rowNumsStr = br.readLine();
				String[] rowNumsStrSplit = rowNumsStr.split(" ");
				for(int j = 0; j < columnsCount; j++){
					matrix[i][j] = Integer.parseInt(rowNumsStrSplit[j]);
				}
			}
			int maxRegionSize = calculateMaxRegionSize(matrix);
			System.out.println(maxRegionSize);
		} catch (Exception e){
			
		}
	}
	
	private static int calculateMaxRegionSize(final int[][] matrix){
		int max = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!visited[i][j]) {
					int size = calculateRegionSize(matrix, visited, i, j);
					if (max < size) {
						max = size;
					}
				}
			}
		}
		return max;
	}
	
	private static int calculateRegionSize(final int[][] matrix, boolean[][] visited, int m, int n){
		visited[m][n] = true;
		if(matrix[m][n] == 0){
			return 0;
		}
		int size = 0;
		for(Coordinate coordinate : getNearbyCoordinates(new Coordinate(m, n), matrix)){
			if(!visited[coordinate.getM()][coordinate.getN()]){
				size += calculateRegionSize(matrix, visited, coordinate.getM(), coordinate.getN());
			}
		}
		
		return 1 + size;
	}
	
	private static List<Coordinate> getNearbyCoordinates(Coordinate coordinate, final int[][] matrix){
		List<Coordinate> coordinates = new LinkedList<Coordinate>();
		if((coordinate.getM() - 1) >= 0 && (coordinate.getN() - 1) >= 0){
			coordinates.add(new Coordinate((coordinate.getM() - 1), (coordinate.getN() - 1)));
		}
		
		if((coordinate.getM() - 1) >= 0){
			coordinates.add(new Coordinate((coordinate.getM() - 1), coordinate.getN()));
		}
		
		if((coordinate.getM() - 1) >= 0 && (coordinate.getN() + 1) < matrix[0].length){
			coordinates.add(new Coordinate((coordinate.getM() - 1), (coordinate.getN() + 1)));
		}
		
		if((coordinate.getN() + 1) < matrix[0].length){
			coordinates.add(new Coordinate(coordinate.getM(), (coordinate.getN() + 1)));
		}
		
		if((coordinate.getM() + 1) < matrix.length && (coordinate.getN() + 1) < matrix[0].length){
			coordinates.add(new Coordinate((coordinate.getM() + 1), (coordinate.getN() + 1)));
		}
		
		if((coordinate.getM() + 1) < matrix.length){
			coordinates.add(new Coordinate((coordinate.getM() + 1), coordinate.getN()));
		}
		
		if((coordinate.getM() + 1) < matrix.length && (coordinate.getN() - 1) >= 0){
			coordinates.add(new Coordinate((coordinate.getM() + 1), (coordinate.getN() - 1)));
		}
		
		if((coordinate.getN() - 1) >= 0){
			coordinates.add(new Coordinate(coordinate.getM(), (coordinate.getN() - 1)));
		}
		
		return coordinates;
	}
	
	static class Coordinate {
		private int m;
		private int n;
		
		public Coordinate(int m, int n) {
			super();
			this.m = m;
			this.n = n;
		}
		
		public int getM() {
			return m;
		}
		
		public int getN() {
			return n;
		}
	}
}
