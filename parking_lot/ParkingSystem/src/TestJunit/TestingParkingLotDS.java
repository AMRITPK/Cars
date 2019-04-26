package TestJunit;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Types.*;

/**
 * 
 */

/**
 * @author apresannakumar
 *
 */
public class TestingParkingLotDS {

	@Test
	public void test() {
		//fail("Not yet implemented");
		ParkingLotDS.setSize(10);
		Car[] nparkingLot = ParkingLotDS.getParkingLotDS();
		Car[] nparkingLot1 = ParkingLotDS.getParkingLotDS();
		assertEquals(nparkingLot.length,10);
		assertEquals(nparkingLot.length,nparkingLot1.length);
	}

}
