package TestJunit;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Types.*;
import System.*;

/**
 * 
 */

/**
 * @author apresannakumar
 *
 */
public class TestingMain {

	@Test
	public void test() {
		//fail("Not yet implemented");
		ParkingLotDS.setSize(10);
		Car car1=null;
		Car car2=null;
		try {
			car1=new Car("Kl 13 A-1234","Red");
			car2=new Car("Kl 22 A-1234","Red");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rerurnIndex=new Main().park(car1,car1.getColor());
		// rerurnIndex=park(car2,car2.getColor());
		System.out.println(rerurnIndex);
		assertEquals(new Main().findByNumber("Kl 13 A-1234")+"",rerurnIndex+"");
		System.out.println(new Main().findByNumber("Kl 13 A-1234"));
		assertEquals(new Main().findByNumber("Kl 13 A-1234")+"",0+"");
		//assertEquals(nparkingLot.length,nparkingLot1.length+1);
	}

}
