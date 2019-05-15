package PracticeArena.Easy;

import java.math.BigInteger;
import java.util.LinkedList;

public class SRM398MinDifference {

	public static int closestElements(int A0, int X, int Y, int M, int n) {
		BigInteger firstElement = new BigInteger(String.valueOf(A0));
		BigInteger secondElement = firstElement.multiply(new BigInteger(String.valueOf(X)))
				.add(new BigInteger(String.valueOf(Y))).mod(new BigInteger(String.valueOf(M)));
		LinkedList<BigInteger> recurrenceElements = new LinkedList<BigInteger>() {
			{
				add(firstElement);
				add(secondElement);
			}
		};

		int minDifference = Math.abs(new BigInteger(String.valueOf(recurrenceElements.get(0)))
				.subtract(new BigInteger(String.valueOf(recurrenceElements.get(1)))).intValue());

		if (firstElement.equals(secondElement)) {
			return 0;
		} else {
			for (int i = 2; i < n; i++) {
				BigInteger listElement = recurrenceElements.get(i - 1).multiply(new BigInteger(String.valueOf(X)))
						.add(new BigInteger(String.valueOf(Y))).mod(new BigInteger(String.valueOf(M)));
				recurrenceElements.add(listElement);

				// find minimum difference between all
				for (int j = 0; j < recurrenceElements.size() - 1; j++) {
					if (Math.abs(listElement.subtract(recurrenceElements.get(j)).intValue()) < minDifference) {
						minDifference = Math.abs(listElement.subtract(recurrenceElements.get(j)).intValue());
					}
				}

				if (minDifference == 0) {
					break;
				}
			}

		}
		return minDifference;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(closestElements(3, 7, 1, 101, 5));
		System.out.println(closestElements(3, 9, 8, 32, 8));
		System.out.println(closestElements(1567, 5003, 9661, 8929, 43));
		System.out.println(closestElements(4765, 5081, 7951, 10000, 10000));
	}

}
