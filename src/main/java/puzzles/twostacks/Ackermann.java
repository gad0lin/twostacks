package puzzles.twostacks;

import java.math.BigInteger;

/**
 * Ackermann function implementation - combinatorial explosion.
 * 
 * @author krzysztofbarczynski
 * 
 */
public class Ackermann {
	BigInteger zero = new BigInteger("0");
	BigInteger one = new BigInteger("1");

	BigInteger ackermann(BigInteger m, BigInteger n) {
		if (isZero(m)) {
			return n.add(one);
		} else if (m.compareTo(zero) > 0 && isZero(n)) {
			return ackermann(m.subtract(one), one);
		} else {
			return ackermann(m.subtract(one), ackermann(m, n.subtract(one)));
		}
	}

	private boolean isZero(BigInteger m) {
		return m.compareTo(zero) == 0;
	}

	public static void main(String[] args) {
		System.out.println(new Ackermann().ackermann(new BigInteger("3"),
				new BigInteger("3")));
	}

}
