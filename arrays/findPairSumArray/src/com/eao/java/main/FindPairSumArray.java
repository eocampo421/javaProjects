package com.eao.java.main;

import java.util.Arrays;

public class FindPairSumArray {

	public boolean findPair(int[] array, int sum) {
		Arrays.sort(array);
		
		int low = 0;
		int hight = array.length - 1;
		
		while (low < hight) {
			if(sumArrayIndex(array, low, hight) == sum) {
				return true;
			}else if(sumArrayIndex(array, low, hight) < sum) {
				low++;
			}else {
				hight--;
			}
		}
		return false;
	}

	private int sumArrayIndex(int[] array, int low, int hight) {
		return array[low] + array[hight];
	}
}
