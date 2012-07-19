package puzzles.twostacks;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.twostacks.CutRod.CutPreis;

public class CutRodTest {

	@Test
	public void shouldProperlyFindWhenSingleCut() {
		CutPreis[] preices = new CutPreis[] { new CutPreis(1, 1) };
		CutRod cr = new CutRod(Arrays.asList(preices));
		assertTrue(cr.getMaxPrice(1) == 1);
	}

	@Test
	public void shouldReturnOwhenLenghtIs0() {
		CutPreis[] preices = new CutPreis[] { new CutPreis(1, 1) };
		CutRod cr = new CutRod(Arrays.asList(preices));
		assertTrue(cr.getMaxPrice(0) == 0);
	}

	@Test
	public void shouldFindBetterCutThenOne() {
		CutPreis[] preices = new CutPreis[] { new CutPreis(1, 2),
				new CutPreis(2, 1), new CutPreis(3, 3), new CutPreis(4, 3) };
		CutRod cr = new CutRod(Arrays.asList(preices));
		assertTrue(cr.getMaxPrice(4) == 8);
	}

	@Test
	public void shouldFindBetterCutWithVariousCuts() {
		CutPreis[] preices = new CutPreis[] { new CutPreis(1, 1),
				new CutPreis(2, 1), new CutPreis(3, 4), new CutPreis(4, 3) };
		CutRod cr = new CutRod(Arrays.asList(preices));
		assertTrue(cr.getMaxPrice(4) == 5);
	}
}
