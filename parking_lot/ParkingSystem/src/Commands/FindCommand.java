package Commands;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import Types.Car;
import Types.Color;
import Types.ParkingLotDS;
import Types.RegNumLotDS;

public class FindCommand implements Command {
	
		private Car[] parkingLot;
		private Map<String,Integer> regNumberMap;
	
		private String color;
		
	
		public FindCommand( String color){
			
			this.parkingLot=ParkingLotDS.getParkingLotDS();
			this.regNumberMap=RegNumLotDS.getRegNumLotDS();
			this.color=color;
		}
		
		@Override
		public Object execute() {
			ArrayList al= new ArrayList();
			// TODO Auto-generated method stub
			for(int i=0;i<this.parkingLot.length;++i) {
				if(this.parkingLot[i] != null) {
					Car c=this.parkingLot[i];
					if(c.getColor()+""==this.color) {
						al.add(i);
					}
				
				}
			}
			return al;
	
	}
		
		

}
