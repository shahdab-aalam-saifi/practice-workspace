package com.saalamsaifi.evenodd;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.saalamsaifi.evenodd.EvenOddNumbers;

public class EvenOddNumbersTests {
	@Test
	public void testEvenStartEvenEnd() throws Exception {
		int[][] evenOdd = EvenOddNumbers.evenOdd(10, 20);

		assertEquals(evenOdd[0], new int[] { 10, 12, 14, 16, 18, 20 });
		assertEquals(evenOdd[1], new int[] { 11, 13, 15, 17, 19 });
	}

	@Test
	public void testOddStartOddEnd() throws Exception {
		int[][] evenOdd = EvenOddNumbers.evenOdd(11, 21);

		assertEquals(evenOdd[0], new int[] { 12, 14, 16, 18, 20 });
		assertEquals(evenOdd[1], new int[] { 11, 13, 15, 17, 19, 21 });
	}

	@Test
	public void testEvenStartOddEnd() throws Exception {
		int[][] evenOdd = EvenOddNumbers.evenOdd(10, 21);

		assertEquals(evenOdd[0], new int[] { 10, 12, 14, 16, 18, 20 });
		assertEquals(evenOdd[1], new int[] { 11, 13, 15, 17, 19, 21 });
	}

	@Test
	public void testOddStartEvenEnd() throws Exception {
		int[][] evenOdd = EvenOddNumbers.evenOdd(11, 20);

		assertEquals(evenOdd[0], new int[] { 12, 14, 16, 18, 20 });
		assertEquals(evenOdd[1], new int[] { 11, 13, 15, 17, 19 });
	}
	
	@Test(expectedExceptions= {UnsupportedOperationException.class}, expectedExceptionsMessageRegExp="start > end")
	public void testStartGreaterThanEnd() throws Exception {
		EvenOddNumbers.evenOdd(21, 20);
	}

	@Test
	public void testSameStartAndEnd() throws Exception {
		EvenOddNumbers.evenOdd(10, 10);
	}

}
