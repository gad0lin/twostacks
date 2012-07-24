package puzzles.twostacks;

public class CountNumbersWithDigit {

	private int searchDigit = 2;

	public CountNumbersWithDigit(int searchDigit) {
		super();
		this.searchDigit = searchDigit;
	}

	public int count(int number) {
		if (number < searchDigit) {
			return 0;
		}
		int[] asArray = numberAsArray(number);
		return count(asArray, asArray.length - 1);
	}

	public int count(int[] number, int digitIndex) {
		int digit = number[digitIndex];
		int numberWithDigitAtIndexCount = numbersWithDigitAtGivenIndex(number,
				digitIndex);
		int geDigit = zeroIfLessThenDigit1Otherwise(digit);
		if (digitIndex == 0) {
			return numberWithDigitAtIndexCount;
		}
		int numberWithDigitAtSmallerPosition = (digit - geDigit)
				* (count((int) Math.pow(10, digitIndex) - 1));
		int numberWithDigitAtSmallerPositionRest = count(arrayToNumber(number,
				digitIndex - 1));
		return numberWithDigitAtIndexCount + numberWithDigitAtSmallerPosition
				+ numberWithDigitAtSmallerPositionRest;
	}

	private int numbersWithDigitAtGivenIndex(int[] number, int digitIndex) {
		int digitValue = number[digitIndex];
		int result = 0;
		if (digitValue < searchDigit) {
			result = 0;
		} else if (digitValue > searchDigit) {
			result = (int) Math.pow(10, digitIndex);
		} else {
			result = arrayToNumber(number, digitIndex - 1) + 1;
		}
		return result;
	}

	public int zeroIfLessThenDigit1Otherwise(int digitValue) {
		return searchDigit > digitValue ? 0 : 1;

	}

	public int[] numberAsArray(int number) {
		String asString = Integer.toString(number);
		int[] asArray = new int[asString.length()];
		for (int i = 0; i < asArray.length; i++) {
			asArray[i] = asString.charAt(asArray.length - i - 1) - '0';
		}
		return asArray;
	}

	public int arrayToNumber(int[] digits, int maxIndex) {
		int result = 0;
		for (int k = maxIndex; k >= 0; k--) {
			result = 10 * result + digits[k];
		}
		return result;
	}

}
