package TestJunit;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Types.RegNumLotDS;

/**
 * 
 */

/**
 * @author apresannakumar
 *
 */
public class TestingRegNumLotDS {

	@Test
	public void test() {
		//fail("Not yet implemented");
		RegNumLotDS numLot = new RegNumLotDS();
		HashMap<String, Integer> ds = numLot.getRegNumLotDS();
		ds.put("asdf", 1);
		HashMap<String, Integer> ds1 = numLot.getRegNumLotDS();
		assertEquals(ds,ds1);
	}

}
