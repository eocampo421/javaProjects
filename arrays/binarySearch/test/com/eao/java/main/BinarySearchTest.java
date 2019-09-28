package com.eao.java.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
	
	private BinarySearch binarySearch;
	private int[] array;
	private int left;
	private int right;
	
	@Before
	public void before() {
		binarySearch = new BinarySearch();
		array = new int[] {2, 5, 6, 8, 9, 10};
		right = array.length - 1;
	}
	
	@Test
	public void when_bs_element_isEqual_target() {
		final int target = 6;
		
		int index = binarySearch.binarySearch(array, left, right, target);

		assertEquals(2, index);
	}

	@Test
	public void when_element_isLessThan_target() {
		final int target = 2;
		
		int index = binarySearch.binarySearch(array, left, right, target);

		assertEquals(0, index);
	}
	
	@Test
	public void when_element_isGreaterThan_target(){
		final int target = 9;
		
		int index = binarySearch.binarySearch(array, left, right, target);

		assertEquals(4, index);
	}
	
	@Test
	public void when_target_isNot_found(){
		final int target = 25;
		
		int index = binarySearch.binarySearch(array, left, right, target);

		assertEquals(-1, index);
	}
}
