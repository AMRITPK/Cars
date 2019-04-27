package Commands;

import java.util.HashMap;

import Types.Car;
import Types.ParkingLotDS;
import Types.RegNumLotDS;

public class LeaveCommand implements Command {

	private Car[] parkingLot;
	private int index;
	HashMap<String,Integer> regNumberMap;

	public LeaveCommand( int index){

		this.parkingLot=ParkingLotDS.getParkingLotDS();
		this.regNumberMap=RegNumLotDS.getRegNumLotDS();
		this.index=index;

	}

	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		Car ret=this.parkingLot[this.index];
		this.parkingLot[this.index]=null;
		this.regNumberMap.remove(ret.getRegistraionNO());
		return ret;

	}



}
