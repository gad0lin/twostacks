package puzzles.twostacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class UpperFilterStreamTest {

	@Test
	public void test() throws IOException {
		File test = new File(getClass().getResource("/test.txt").getFile());
		UpperFilterStream ufs = new UpperFilterStream(new FileInputStream(test));
		int c;
		while ((c = ufs.read()) != -1) {
			System.out.print(((char) c));
		}
	}

}
