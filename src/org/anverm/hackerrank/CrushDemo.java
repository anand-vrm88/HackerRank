package org.anverm.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class CrushDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String nAndM = br.readLine();
			String[] nAndMSplited = nAndM.split(" ");
			//int n = Integer.parseInt(nAndMSplited[0]);
			int m = Integer.parseInt(nAndMSplited[1]);
			
			List<Data> dataList = new LinkedList<Data>();
			
			for(int i = 0; i < m; i++){
				String aBAndK = br.readLine();
				String[] aBAndKSplited = aBAndK.split(" ");
				int a = Integer.parseInt(aBAndKSplited[0]);
				int b = Integer.parseInt(aBAndKSplited[1]);
				int k = Integer.parseInt(aBAndKSplited[2]);
				
				int count = -1;
				int startCommulativeValue = 0;
				int endCommulativeValue = 0;
				
				for(Data data : dataList){
					count++;
					if(data.getStartIndex() > a){
						break;
					}
					
					if(data.getDataType() == DataType.START){
						if(data.isInRange(a)){
							startCommulativeValue += data.getValue();
						}	
						if(data.isInRange(b)){
							endCommulativeValue += data.getValue();
						}
					}
				}
				
				if (count == -1) {
					dataList.add(++count, new Data(a, b, k, k + startCommulativeValue, DataType.START));
				} else {
					if(a == dataList.get(count).getStartIndex()){
						dataList.add(new Data(a, b, k, k + startCommulativeValue, DataType.START));
					} else {
						dataList.add(count, new Data(a, b, k, k + startCommulativeValue, DataType.START));
					}
/*					if (count == dataList.size() - 1) {
						dataList.add(new Data(a, b, k, k, DataType.START));
						//dataList.add(new Data(a, b, k, k, DataType.END));
						//continue;
						count++;
					}

					Data startData = dataList.get(count);
					if (startData != null) {
						startData.setCummulativeValue(k + startCommulativeValue);
					} else {
						dataList.add(count, new Data(a, b, k, k + startCommulativeValue, DataType.START));
					}*/
				}
				
				
				count++;
				count++;
				while(count < dataList.size()){
					Data data = dataList.get(count);
					if(data.getStartIndex() != a && data.getEndIndex() > b){
						break;
					}
					
					if(data.getDataType() == DataType.START){
						/*if(data.isInRange(b)){
							endCommulativeValue += data.getValue();
						}*/
						data.setCummulativeValue(k + data.getCummulativeValue());
					}
					count++;
				}
				
				/*if(count == dataList.size()) {
					dataList.add(new Data(a, b, k, k, DataType.END));
					continue;
				}*/
				
/*				Data endData = dataList.get(count);
				if(endData != null){
					endData.setCummulativeValue(k + endCommulativeValue);
				} else {
					dataList.add(count, new Data(a, b, k, k + endCommulativeValue, DataType.END));
				}*/
			}
			
			System.out.println(getMax(dataList));
		} catch (Exception e){
			
		}
	}
	
	private static long getMax(List<Data> dataList){
		long max = 0;
		for(Data data : dataList){
			if(data.getCummulativeValue() > max){
				max = data.getCummulativeValue();
			}
		}
		return max;
	}

	public static class Data {
		private int startIndex;
		private int endIndex;
		private int value;
		private long cummulativeValue;
		private DataType dataType;
		
		public Data(int startIndex, int endIndex, int value, int cummulativeValue, DataType dataType) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.value = value;
			this.cummulativeValue = cummulativeValue;
			this.dataType = dataType;
		}
		
		public int getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public long getCummulativeValue() {
			return cummulativeValue;
		}

		public void setCummulativeValue(long cummulativeValue) {
			this.cummulativeValue = cummulativeValue;
		}

		public DataType getDataType() {
			return dataType;
		}

		public void setDataType(DataType dataType) {
			this.dataType = dataType;
		}

		public boolean isInRange(int index){
			if(index >= startIndex && index <= endIndex){
				return true;
			} else {
				return false;
			}
		}
		

	}
	
	public enum DataType {
		START, END
	}
}


