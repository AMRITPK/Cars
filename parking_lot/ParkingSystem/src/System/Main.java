package System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Commands.Command;
import Commands.FindCommand;
import Commands.LeaveCommand;
import Commands.ParkCommand;
import Invoker.Operation;
import Types.Car;
import Types.Color;
import Types.ParkingLotDS;
import Types.RegNumLotDS;

public class Main {
	

	public static void main( String[] args) {
	
		Car car1=null;
		Car car2=null;
		try {
			car1=new Car("Kl 13 A-1234","RED");
			car2=new Car("Kl 22 A-1234","RED");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ParkingLotDS.setSize(10);
		int rerurnIndex=park(car1,car1.getColor());
		 rerurnIndex=park(car2,car2.getColor());
		System.out.println("asdf"+rerurnIndex);
		System.out.println(leave(0));
		System.out.println(findByNumber("Kl 13 A-1234"));
		
		System.out.println(findByColor(Color.RED));
		
		
		new Utils.PrintLot(ParkingLotDS.getParkingLotDS()).print();
		
	}
	public static Integer findByNumber(String regNo) {
		return RegNumLotDS.getRegNumLotDS().get(regNo);
	}
	public static List findByColor(Color color) {
		Command findCAr = new FindCommand(color);
		 Operation parking = new Operation();
		 parking.register("find", findCAr);
		 
		 
		return (List) parking.execute("find");
	}
	public static int park(Car car,Color c) {
		
		Command parkCar = new ParkCommand(car);
		 Operation parking = new Operation();
		 parking.register("park", parkCar);
		 
		 
		return (int) parking.execute("park");
	     
		
	}
	public static Car leave(int index) {
		
		Command leavePosition = new LeaveCommand(index);
		 Operation parking = new Operation();
		 parking.register("leave", leavePosition);
		 
		 
		return (Car) parking.execute("leave");
	     
		
	}
	

}
