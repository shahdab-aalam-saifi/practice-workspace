package com.saalamsaifi.evenodd;

public final class EvenOddNumbers {
	
	private EvenOddNumbers() {
		// private constructor
	}
	
	private static boolean isEven(int value) {
		return value % 2 == 0;
	}

	public static int[][] evenOdd(int start, int end) {
		if (start > end) {
			throw new UnsupportedOperationException("start > end");
		}

		int[] evenNumbers;
		int[] oddNumbers;
		int totalNumbers = (end - start) + 1;

		if (isEven(totalNumbers)) {
			evenNumbers = new int[totalNumbers / 2];
			oddNumbers = new int[totalNumbers / 2];
		} else {
			if (isEven(start)) {
				evenNumbers = new int[(totalNumbers / 2) + 1];
				oddNumbers = new int[totalNumbers / 2];
			} else {
				evenNumbers = new int[totalNumbers / 2];
				oddNumbers = new int[(totalNumbers / 2) + 1];
			}
		}

		int evenIndex = 0;
		int oddIndex = 0;

		for (int i = start; i <= end; i++) {
			if (i % 2 == 0) {
				evenNumbers[evenIndex++] = i;
			} else {
				oddNumbers[oddIndex++] = i;
			}
		}

		return new int[][] { evenNumbers, oddNumbers };
	}
}
