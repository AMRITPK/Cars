package Invoker;

import java.util.List;

import Commands.Command;
import Commands.FindCommand;
import Commands.LeaveCommand;
import Commands.ParkCommand;
import Types.Car;
import Types.Color;
import Types.ParkingLotDS;
import Types.RegNumLotDS;

public class FunctionWrapper {
	public static Integer findByNumber(String regNo) {

		Integer a= RegNumLotDS.getRegNumLotDS().get(regNo);
		//System.out.println(a);
		return a;
	}
	public static List findByColor(String color) throws Exception {
		Command findCAr = new FindCommand(color);
		Operation parking = new Operation();
		parking.register("find", findCAr);
		return (List) parking.execute("find");
	}
	public static int park(Car car,Color c) throws Exception {

		Command parkCar = new ParkCommand(car);
		Operation parking = new Operation();
		parking.register("park", parkCar);	 
		return (int) parking.execute("park");


	}
	public static Car leave(int index) throws Exception {
		if(index > ParkingLotDS.getSize()-1) {
			return null;
		}
		Command leavePosition = new LeaveCommand(index);
		Operation parking = new Operation();
		parking.register("leave", leavePosition);	 
		return (Car) parking.execute("leave");


	}
	public void createLot(int size) {
		// TODO Auto-generated method stub
		ParkingLotDS.setSize(size);
		
	}

}
