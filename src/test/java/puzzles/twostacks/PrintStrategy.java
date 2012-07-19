package puzzles.twostacks;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.only;

public class PrintStrategy {

	@Mock 
	PrintMe printer;
	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void treeDelegatesPrintCalls() {
		//given
		BTree b = new BTree(3);
		b.setPrintMe(printer);
		
		//when
		b.print();
		
		// then
		verify(printer,only()).print(b);
		
	}

}
