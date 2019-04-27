package TestJunit;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Invoker.FunctionWrapper;
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
	private FunctionWrapper wrapper;
	@Test
	public void test() {
		//fail("Not yet implemented");
		ParkingLotDS.setSize(10);
		wrapper=new FunctionWrapper();
		Car car1=null;
		Car car2=null;
		try {
			car1=new Car("Kl 13 A-1234","Red");
			car2=new Car("Kl 22 A-1234","Red");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int rerurnIndex;
		try {
			rerurnIndex = wrapper.park(car1,car1.getColor());
			// rerurnIndex=park(car2,car2.getColor());
			//System.out.println(rerurnIndex);
			assertEquals(wrapper.findByNumber("Kl 13 A-1234")+"",rerurnIndex+"");
			//System.out.println(wrapper.findByNumber("Kl 13 A-1234"));
			assertEquals(wrapper.findByNumber("Kl 13 A-1234")+"",0+"");
			//assertEquals(nparkingLot.length,nparkingLot1.length+1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Car a;
		try {
			a = wrapper.leave(10);
			rerurnIndex=wrapper.park(car2,car2.getColor());
			assertEquals(null,a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Car c2=wrapper.leave(0);
			assertEquals(c2.color,Color.Red);
			//System.out.println(wrapper.findByColor("Red").size());
			assertEquals(wrapper.findByColor("Red").size(),1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	


	}

}
