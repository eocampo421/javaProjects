package com.eao.java.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FindPairSumArrayTest {

	private FindPairSumArray findPairSumArray;
	private int[] array;

	@Before
	public void before() {
		findPairSumArray = new FindPairSumArray();
		array = new int[] {1, 4, 45, 6, 10, -8};
	}

	@Test
	public void when_findPair_then_return_true() {
		boolean findPair = findPairSumArray.findPair(array, 16);

		assertTrue(findPair);
	}

	@Test
	public void when_no_findPair_then_return_false() {
		boolean findPair = findPairSumArray.findPair(array, 230);

		assertFalse(findPair);
	}
}
