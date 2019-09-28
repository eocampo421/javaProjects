package com.eao.java.main;

public class BinarySearch {
	
	public int binarySearch(final int[] array, int left, int right,int target) {
		if(left > right) {
			return -1;
		}
		
		int middle = middleIndex(left, right);
			
		if(target == array[middle]) {
			return middle;
		}else if (target < array[middle]) {
			return binarySearch(array, left, middle - 1, target);
		}else {
			return binarySearch(array, middle + 1, right, target);
		}
	}

	private int middleIndex(int left, int right) {
		return (left + right)/2;
	}
}
