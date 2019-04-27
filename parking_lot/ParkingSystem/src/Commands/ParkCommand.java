package Commands;

import java.util.Map;
import java.util.HashMap;

import Types.Car;
import Types.*;

public class ParkCommand implements Command {
	private Car car;
	private Car[] parkingLot;
	private Map<String,Integer> regNumberMap;


	public ParkCommand(Car c){
		this.car=c;

		this.parkingLot=ParkingLotDS.getParkingLotDS();
		this.regNumberMap=RegNumLotDS.getRegNumLotDS();

	}
	public ParkCommand( int index,Car[] parkingLot){

		this.parkingLot=parkingLot;
	}

	@Override
	public Object execute() throws Exception {
		//System.out.println(this.parkingLot.length);
		// TODO Auto-generated method stub
		for(int i=0;i<this.parkingLot.length;++i) {
			if(this.parkingLot[i] == null) {
			
				if(this.regNumberMap.get(this.car.getRegistraionNO()) != null) {
					throw new Exception("Duplicate Reg Number");
				}
				this.parkingLot[i]=this.car;
				this.regNumberMap.put(this.car.getRegistraionNO(), i);
				return i;
			}
		}
		return -1;

	}



}
