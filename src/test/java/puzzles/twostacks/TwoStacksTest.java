package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class TwoStacksTest 
{
	final String two = "2";
	final String three = "3";

	public void init() {
		
	}

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	
    }
    
    @Test
    public void shouldInsertOneElement() {
    	QueueOnStacks queue = new QueueOnStacks(10);
    	String three = "3";
    	assertTrue(queue.insert(three));
    	assertTrue(queue.pull() == three);
	}
    
    @Test
    public void shouldInsertTwoElements() {
    	QueueOnStacks queue = new QueueOnStacks(10);
    
    	queue.insert(two);
    	queue.insert(three);
    	assertTrue(queue.pull() == two);
    	assertTrue(queue.pull() == three);
	}
    
    @Test
    public void shouldRejectIfFull() {
     	QueueOnStacks queue = new QueueOnStacks(1);
     	assertTrue(queue.insert(two));
     	assertTrue(queue.insert(three));
     	assertFalse(queue.insert(three));
	}
    
}
