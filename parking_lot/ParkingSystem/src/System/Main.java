package System;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	

	public static void main( String[] args)  {
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(new File("parking_lot file_inputs.txt")));
			
			while(true) {
				
				String line=br.readLine();
				if(line==null)break;
				if(line.startsWith("create_parking_lot")) {
					int size=Integer.parseInt(line.split(" ")[1]);
					ParkingLotDS.setSize(size);
				}else if(line.startsWith("park")){
					String regno=line.split(" ")[1];
					String color=line.split(" ")[2];
					Car car1;
					try {
						car1 = new Car(regno,color);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new Exception("Invalid colour");
					}
					int rerurnIndex=park(car1,car1.getColor());
				}else if(line.startsWith("leave")){
					int index=Integer.parseInt(line.split(" ")[1]);
					System.out.println(leave(index-1));
				}else if(line.startsWith("status")){
					new Utils.PrintLot(ParkingLotDS.getParkingLotDS()).print();
					
				}else if(line.startsWith("registration_numbers_for_cars_with_colour")){
					String color=line.split(" ")[1];
					new Utils.PrintLot(ParkingLotDS.getParkingLotDS()).print("REG",findByColor(color));
				}else if(line.startsWith("slot_numbers_for_cars_with_colour")){
					String color=line.split(" ")[1];
					new Utils.PrintLot(ParkingLotDS.getParkingLotDS()).print("LOT",findByColor(color));
				}else if(line.startsWith("slot_number_for_registration_number")){
					String num =line.split(" ")[1];
					System.out.println(1+findByNumber(num));
				} 
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
				// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		 }catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
		 }
	
	
	
		/*
		Car car1=null;
		Car car2=null;
		try {
			car1=new Car("Kl 13 A-1234","Red");
			car2=new Car("Kl 22 A-1234","Red");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ParkingLotDS.setSize(10);
		int rerurnIndex=park(car1,car1.getColor());
		 rerurnIndex=park(car2,car2.getColor());
		System.out.println("asdf"+rerurnIndex);
		
		System.out.println(findByNumber("Kl 13 A-1234"));
		*/
	
		
		
		
		
	}
	public static Integer findByNumber(String regNo) {
		return RegNumLotDS.getRegNumLotDS().get(regNo);
	}
	public static List findByColor(String color) {
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
