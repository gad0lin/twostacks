package puzzles.twostacks;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class AckermannTest {

	BigInteger zero = new BigInteger("0");
	BigInteger one = new BigInteger("1");
	BigInteger two = new BigInteger("2");
	BigInteger n125 = new BigInteger("125");
	BigInteger n4 = new BigInteger("4");
	BigInteger n3 = new BigInteger("3");
	private BigInteger ten = new BigInteger("10");
	private BigInteger eleven = new BigInteger("11");

	@Test
	public void shouldCalculdteZeros() {
		Ackermann ak = new Ackermann();
		assertTrue(one.equals(ak.ackermann(zero, zero)));
	}

	@Test
	public void shouldCalculateZeroOne() {
		Ackermann ak = new Ackermann();
		assertTrue(two.equals(ak.ackermann(zero, one)));
	}

	@Test
	public void shouldCalculateOneZero() {
		Ackermann ak = new Ackermann();
		assertTrue(two.equals(ak.ackermann(one, zero)));
	}

	@Test
	public void shouldCalculateThreeFour() {
		Ackermann ak = new Ackermann();
		assertTrue(n125.equals(ak.ackermann(n3, n4)));
	}

}
