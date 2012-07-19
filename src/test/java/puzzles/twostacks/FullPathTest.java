package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class FullPathTest {

	FullPath fp = new FullPath();

	@Test
	public void shouldParseRoot() {
		assertTrue(fp.getFullPath("/").equals("/"));
	}

	@Test
	public void shouldParseDoubleRoot() {
		assertTrue(fp.getFullPath("//").equals("/"));
	}
	@Test
	public void shouldParseTripleRoot() {
		assertTrue(fp.getFullPath("///").equals("/"));
	}
	
	@Test
	public void shouldParseSingleRootWithDot() {
		assertTrue(fp.getFullPath("/.").equals("/"));
	}
	@Test
	public void shouldParseSingleRootWithDoubleDot() {
		assertTrue(fp.getFullPath("/..").equals("/"));
	}
	
	@Test
	public void shouldParseSingleRootWithMixDot() {
		assertTrue(fp.getFullPath("/a/../").equals("/"));
	}
	@Test
	public void shouldParseSingleRootWithMixDots() {
		System.out.println(fp.getFullPath("/a/.././b/c/../d"));
		assertTrue(fp.getFullPath("/a/.././b/c/../d").equals("/b/d"));
	}
}
