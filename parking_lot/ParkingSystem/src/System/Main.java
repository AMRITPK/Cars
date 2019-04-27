package System;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Commands.Command;
import Commands.FindCommand;
import Commands.LeaveCommand;
import Commands.ParkCommand;
import Invoker.FunctionWrapper;
import Invoker.Operation;
import Types.Car;
import Types.Color;
import Types.ParkingLotDS;
import Types.RegNumLotDS;

public class Main {
	private static FunctionWrapper wrapper= new FunctionWrapper() ;
	public static void commandParse(String line) throws Exception {
		if(line.startsWith("create_parking_lot")) {
			int size=Integer.parseInt(line.split(" ")[1]);
			wrapper.createLot(size);
			System.out.println("Created a parking lot with "+size+" slots");
		}else if(line.startsWith("park")){
			String regno=line.split(" ")[1];
			String color=line.split(" ")[2];
			Car car1;
			try {
				car1 = new Car(regno,color);
			} catch (Exception e) {

				throw new Exception("Invalid colour");
			}
			try {
				int returnIndex=wrapper.park(car1,car1.getColor());
				if(returnIndex==-1)
					System.out.println("Sorry, parking lot is full");
				else
					System.out.println("Allocated slot number: "+(returnIndex+1));
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}else if(line.startsWith("leave")){
			int index=Integer.parseInt(line.split(" ")[1]);
			Car c= wrapper.leave(index-1);
			if (c!=null)
				System.out.println("Slot number "+(index)+" is free");
			else
				System.out.println("Invalid slot!!");
		}else if(line.startsWith("status")){
			new Utils.PrintLot(ParkingLotDS.getParkingLotDS()).print();

		}else if(line.startsWith("registration_numbers_for_cars_with_colour")){
			String color=line.split(" ")[1];
			new Utils.PrintLot(ParkingLotDS.getParkingLotDS()).print("REG",wrapper.findByColor(color));
		}else if(line.startsWith("slot_numbers_for_cars_with_colour")){
			String color=line.split(" ")[1];
			new Utils.PrintLot(ParkingLotDS.getParkingLotDS()).print("LOT",wrapper.findByColor(color));
		}else if(line.startsWith("slot_number_for_registration_number")){
			String num =line.split(" ")[1];
			Integer i=wrapper.findByNumber(num);
			if(i==null) {
				System.out.println("Not found");
			}else {
				System.out.println((1+i));
			}

		}else if(line.startsWith("exit")){
			System.exit(0);		

		}else {
			BufferedReader br;

			br = new BufferedReader(new FileReader(new File(line)));

			while(true) {

				String line1;
				line1 = br.readLine();
				if(line1==null)break;
				commandParse(line1);


			}
		}
	}
	public static void main( String[] args1)  {
		try {
			if(args1!=null&&args1.length>0) {
				commandParse(args1[0]);
			}
				wrapper=new FunctionWrapper();


				String line;
				Scanner scanner = new Scanner(System.in);
				while((line = scanner.nextLine())!=null) {

					commandParse(line.toString());

				}
			
	




		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Invalid file path or file");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("IO error in reading file");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Generic Error");
			e.printStackTrace();
		}

	}
}
